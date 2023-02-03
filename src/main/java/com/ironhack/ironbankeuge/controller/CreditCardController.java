package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CheckingDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CreditCardDTO;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import com.ironhack.ironbankeuge.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account/credit")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard updateAccountList (
                                         @RequestBody
                                         CreditCardDTO creditCardDTO
    ){
        return creditCardService.createCredit (creditCardDTO);
    }

}
