package ru.practicum.service;

import ru.practicum.dto.operation.OperationDto;
import ru.practicum.dto.wallet.WalletDto;

public interface WalletService {

    WalletDto walletOperation(OperationDto operation);

    WalletDto getBalance(String vallet);

    void walletAdd(WalletDto wallet);
}
