package ru.practicum.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.dto.wallet.WalletDto;
import ru.practicum.model.Wallet;

@RequiredArgsConstructor
@Component
public class WalletMapper {
    public WalletDto toWalletDto(Wallet wallet) {
        return new WalletDto(
                wallet.getId(),
                wallet.getBalance()
        );
    }

    public Wallet toWallet(WalletDto wallet){
        return new Wallet(
                wallet.getId(),
                wallet.getBalance()
        );
    }
}
