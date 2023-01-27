package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderControllerTest {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Test
    void createAccountHolder() {

        var accountHolderDTO = new AccountHolderDTO(
                "AccountHolderTest",
                "AccountHolderTest",
                "accountholder",
                "hola",
                null,
                LocalDate.parse("1994-11-30"),
                "Hamburger St.",
                "Pickle Alley",
                null,
                null
               );
        var newUser = accountHolderService.createAccountHolder(accountHolderDTO);
        var allUsers = accountHolderRepository.findAll();
        assertEquals(2, allUsers.size());

    }

    @AfterEach
    void deleteAccountHolders(){
        accountHolderRepository.deleteAll();
    }
}