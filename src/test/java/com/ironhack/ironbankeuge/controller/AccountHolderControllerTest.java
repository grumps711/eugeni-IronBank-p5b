package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderControllerTest {

    private AccountHolderService accountHolderService = Mockito.mock(AccountHolderService.class);
    private AccountHolderController accountHolderController = new AccountHolderController(accountHolderService);


    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void createAccountHolder_ReturnsAccountHolder() {
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        AccountHolderDTO accountHolderDTO = new AccountHolderDTO("Jane", "Doe", "janedoe", "password", "ROLE_ACCOUNT_HOLDER", dateOfBirth, "123 Main St.", "456 Main St.", null, null);
        AccountHolder accountHolder = new AccountHolder("Jane", "Doe", "janedoe", "password", dateOfBirth, "123 Main St.", "456 Main St.", null);

        when(accountHolderService.createAccountHolder(accountHolderDTO)).thenReturn(accountHolder);

        assertEquals(accountHolder, accountHolderController.createAccountHolder(accountHolderDTO));
    }

//    @Test
//    void findAllAccountHolders_ReturnsListOfAccountHolders() {
//        AccountHolderDTO accountHolderDTO1 = new AccountHolderDTO("Jane", "Doe", "janedoe", "password", LocalDate.of(2000, 1, 1), "123 Main St.", "456 Main St.", null, null, "ROLE_ACCOUNT_HOLDER");
//        AccountHolderDTO accountHolderDTO2 = new AccountHolderDTO("John", "Smith", "johnsmith", "password", LocalDate.of(2000, 1, 1), "789 Main St.", "101112 Main St.", null, null, "ROLE_ACCOUNT_HOLDER");
//        AccountHolder accountHolder1 = new AccountHolder(accountHolderDTO1);
//        AccountHolder accountHolder2 = new AccountHolder(accountHolderDTO2);
//        List<AccountHolder> accountHolders = Arrays.asList(accountHolder1, accountHolder2);
//        when(accountHolderService.findAll()).thenReturn(accountHolders);
//        assertEquals(accountHolders, accountHolderController.findAllAccountHolders());
//    }


    @Test
    void deleteAccountHolder_AccountHolderIsDeleted() {
        String username = "johndoe";
        accountHolderController.deleteAccountHolder(username);
        Mockito.verify(accountHolderService).deleteAccountHolderByUsername(username);
    }

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

    @Test
    void testCreateAccountHolder() {
    }

    @Test
    void findAllAccountHolders() {
    }

    @Test
    void deleteAccountHolder() {
    }

    @Test
    void updateAccountHolder() {
    }
}