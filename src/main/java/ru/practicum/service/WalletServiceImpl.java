package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.practicum.dto.operation.OperationDto;
import ru.practicum.dto.operation.OperationType;
import ru.practicum.dto.wallet.WalletDto;
import ru.practicum.exeptions.NotFoundException;
import ru.practicum.exeptions.ValidationException;
import ru.practicum.mappers.WalletMapper;
import ru.practicum.model.Wallet;
import ru.practicum.repository.WalletRepository;

import java.util.Optional;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    final WalletRepository walletRepository;
    final WalletMapper walletMapper;

    @Override
    public WalletDto walletOperation(OperationDto operation) {
        log.info("WalletService: выполение операции с кошельком");
        Wallet wallet = getWallet(operation.getValletId());
        if (operation.getOperationType().equals(OperationType.DEPOSIT)) {
            wallet.setBalance(wallet.getBalance() + operation.getAmount());
        } else {
            if (wallet.getBalance() > operation.getAmount()) {
                wallet.setBalance(wallet.getBalance() - operation.getAmount());
            } else {
                throw new ValidationException("операция невозможно не достаточно средств");
            }
        }
        return walletMapper.toWalletDto(walletRepository.save(wallet));
    }

    @Override
    public WalletDto getBalance(String valletId) {
        log.info("WalletService: отправление информации о балансе кошелька");
        return walletMapper.toWalletDto(getWallet(valletId));
    }

    @Override
    public void walletAdd(WalletDto wallet) {
        walletRepository.save(walletMapper.toWallet(wallet));
    }

    private Wallet getWallet(String vallet) {
        Optional<Wallet> wallet = walletRepository.findById(vallet);
        if (wallet.isEmpty()) {
            throw new NotFoundException("кошелька с таким ID нет в базе");
        }
        return wallet.orElse(null);
    }
}