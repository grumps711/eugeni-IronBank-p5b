package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final AccountHolderService accountHolderService;

//    @PatchMapping("/transfer")
//    public AccountHolder transferFunds (
//            @RequestBody TransferDTO transferDTO
//    ){
//        return accountHolderService.transferFunds (transferDTO);
//    }
//
//    @PatchMapping("/deposit")
//    public AccountHolder depositFunds(
//            @RequestBody AccountValidationDTO accountValidationDTO
//            ){
//        return accountHolderService.depositFunds(accountValidationDTO);
//    }

    @PatchMapping("/withdraw/")
    public void withdrawFunds (

            @RequestBody TransferDTO transferDTO
            ){
        accountHolderService.withdrawFunds(transferDTO);
    }


//    @PatchMapping("/deposit/")
//    public Account depositFunds (
//
//            @RequestBody TransferDTO transferDTO
//    ){
//        return accountHolderService.depositFunds (transferDTO);
//    }
}
