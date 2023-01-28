package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CheckingDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.CheckingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account/checking")
public class CheckingController {

    private final CheckingService checkingService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking updateAccountList (
                                   @RequestBody
                                   AccountValidationDTO accountValidationDTO
        ){
        return checkingService.createChecking (accountValidationDTO);
    }

}
