package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.UserDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountHolder createAccountHolder(AccountHolderDTO accountHolderDTO) {
        var accountHolder = new AccountHolder();
        accountHolder.setFirstName(accountHolderDTO.getFirstName());
        accountHolder.setLastName(accountHolderDTO.getLastName());
        accountHolder.setUsername(accountHolderDTO.getUsername());
        accountHolder.setPassword(passwordEncoder.encode(accountHolderDTO.getPassword()));
        accountHolder.setRoles("ROLE_USER");
        accountHolder.setIsAccountNonLocked(true);
        accountHolder.setDateOfBirth(accountHolderDTO.getDateOfBirth());
        accountHolder.setPrimaryAddress(accountHolderDTO.getPrimaryAddress());
        accountHolder.setMailingAddress(accountHolderDTO.getMailingAddress());
        accountHolder.setAccountList(accountHolderDTO.getAccountList());
        accountHolder.setSecondaryAccountList(accountHolderDTO.getSecondaryAccountList());

        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }
}
