package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.SavingDTO;
import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import com.ironhack.ironbankeuge.model.accounts.Saving;
import com.ironhack.ironbankeuge.service.CreditCardService;
import com.ironhack.ironbankeuge.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account/saving")
public class SavingController {

    private final SavingService savingService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Saving updateAccountList (
            @RequestBody
            SavingDTO savingDTO
    ){
        return savingService.createSaving (savingDTO);
    }

}
