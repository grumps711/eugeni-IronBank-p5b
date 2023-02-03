package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountHolderService accountHolderService;

    public AccountHolder findAll(String username) {
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(username);
        return accountHolderFound;
    }
}
