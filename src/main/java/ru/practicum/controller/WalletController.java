package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.operation.OperationDto;
import ru.practicum.dto.wallet.WalletDto;
import ru.practicum.service.WalletService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/v1")
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/wallet")
    public WalletDto walletOperation(@RequestBody OperationDto operation) {
        log.info("WalletController: выполнение операции с кошельком");
        return walletService.walletOperation(operation);
    }

    @GetMapping("/{valletId}")
    public WalletDto getBalance(@PathVariable String vallet) {
        log.info("WalletController: выполнение запроса на отправление информации о болансе кошелька");
        return walletService.getBalance(vallet);
    }

    @PostMapping("/wallet/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void walletadd(@RequestBody WalletDto wallet) {
        log.info("WalletController: выполнение операции с догбавлением кошелька");
        walletService.walletAdd(wallet);
    }
}
