package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import com.ironhack.ironbankeuge.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final AccountHolderService accountHolderService;
    private final AccountService accountService;

    @PatchMapping("/transfer")
    public void transferFunds (
            @RequestBody TransferDTO transferDTO
    ){
        accountHolderService.transferFunds (transferDTO);
    }

    @PatchMapping("/deposit")
    public void depositFunds(
            @RequestBody TransferDTO transferDTO
            ){
        accountHolderService.depositFunds(transferDTO);
    }

    @PatchMapping("/withdraw")
    public void withdrawFunds (
            @RequestBody TransferDTO transferDTO
            ){
        accountHolderService.withdrawFunds(transferDTO);
    }

    @GetMapping("/getallaccounts/{username}")
    @ResponseStatus(HttpStatus.FOUND)
    public AccountHolder findAllAccounts(@PathVariable String username){
        return accountService.findAll(username);
    }

//    @PatchMapping("/deposit/")
//    public Account depositFunds (
//
//            @RequestBody TransferDTO transferDTO
//    ){
//        return accountHolderService.depositFunds (transferDTO);
//    }
}
