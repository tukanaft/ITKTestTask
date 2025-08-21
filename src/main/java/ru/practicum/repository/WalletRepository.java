package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.model.Wallet;

@org.springframework.stereotype.Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

}
