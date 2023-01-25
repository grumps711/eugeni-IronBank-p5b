package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.UserDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/accountholder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO){
        return accountHolderService.createAccountHolder(accountHolderDTO);
    }

//    @GetMapping("/getall")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<AccountHolder> findAll(){
//        return accountHolderService.findAll();
//    }
//
//    @GetMapping("/getbyid")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<AccountHolder> findAll(){
//        return accountHolderService.findAll();
//    }
//    @GetMapping
//    public List<ResolutionDto> findAll(){
//        return resolutionService.findAll();
//    }
//
//    @GetMapping
//    public List<ResolutionDto> findAll(){
//        return resolutionService.findAll();
//    }

}
