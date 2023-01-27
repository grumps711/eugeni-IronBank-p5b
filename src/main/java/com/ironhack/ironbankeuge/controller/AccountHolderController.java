package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.UserDTO;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/accountholder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO){
        return accountHolderService.createAccountHolder(accountHolderDTO);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountHolder> findAllAccountHolders(){
        return accountHolderService.findAll();
    }

    @DeleteMapping("delete/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountHolder (@PathVariable ("username") String username) {
        accountHolderService.deleteAccountHolderByUsername(username);
    }

    @PatchMapping("/modify/{username}")
    public User updateAccountHolder (@PathVariable String username,
                                     @RequestParam Optional<String> username1,
                                   @RequestParam Optional<String> firstName,
                                   @RequestParam Optional <String> lastName,
                                   @RequestParam Optional <String> roles,
                                     @RequestParam Optional <String> password,
                                 @RequestParam Optional <LocalDate> dateOfBirth,
                                 @RequestParam Optional <String> mailingAddress,
                                 @RequestParam Optional <String> primaryAddress,
                                   @RequestParam Optional <Boolean> isAccountNonLocked
                                   ){
        return accountHolderService.updateAccountHolder (username,username1,firstName, lastName, roles, isAccountNonLocked, password, dateOfBirth, mailingAddress, primaryAddress);
    }


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
