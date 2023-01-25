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

    public User createAccountHolder(UserDTO userDTO) {
        var accountHolder = new AccountHolder();
        accountHolder.setFirstName(userDTO.getFirstName());
        accountHolder.setLastName(userDTO.getLastName());
        accountHolder.setUsername(userDTO.getUsername());
        accountHolder.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        accountHolder.setRoles("ROLE_USER");
        accountHolder.setIsAccountNonLocked(userDTO.getIsAccountNonLocked());
//        accountHolder.setDateOfBirth(userDTO);
        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }
}
