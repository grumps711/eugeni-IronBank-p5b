package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransferController {

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

//    @PatchMapping("/withdraw")
//    public AccountHolder withdrawFunds (
//            @RequestBody AccountHolderDTO accountHolderDTO
//            ){
//        return accountHolderService.withdrawFunds (accountHolderDTO);
//    }
}
