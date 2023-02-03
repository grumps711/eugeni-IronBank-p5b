package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/thirdparty")
public class ThirdPartyController {


    private final AccountHolderService accountHolderService;

    //update balance
    //llamar ese endpoint y que pses como requestparam la hashedkey
    //que exista la hashedkey y que tenga autorización
    //tambien pasarle el balance que va a tocar

    @PatchMapping("/deposit/")
    public void depositFundsThirdParty(
            @RequestParam String hashedKey,
            @RequestBody TransferDTO transferDTO
        ){
        accountHolderService.depositFundsThirdParty(transferDTO, hashedKey);
    }

    @PatchMapping("/withdraw/")
    public void withdrawFunds (
            @RequestBody TransferDTO transferDTO
    ){
        accountHolderService.withdrawFunds(transferDTO);
    }
}
