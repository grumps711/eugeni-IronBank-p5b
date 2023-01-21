package com.ironhack.ironbankeuge.DTO.UsersDTO;

import com.ironhack.ironbankeuge.model.Accounts.Account;
import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import com.ironhack.ironbankeuge.model.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolderDTO extends UserDTO {

//    accountholder
    private LocalDate dateOfBirth;
    private String primaryAddress;
    private String mailingAddress;
    private List<Account> accountList;
    private List<Account> secondaryAccountList;


    public AccountHolderDTO fromEntity(AccountHolder accountHolder){
        var accountHolderDTO = new AccountHolderDTO();
//        user
        accountHolderDTO.setFirstName(accountHolder.getFirstName());
        accountHolderDTO.setLastName(accountHolder.getLastName());
        accountHolderDTO.setEmail(accountHolder.getEmail());
        accountHolderDTO.setPassword(accountHolder.getPassword());
        accountHolderDTO.setCreationDate(accountHolder.getCreationDate());
//        account-holder
        accountHolderDTO.setDateOfBirth(accountHolder.getDateOfBirth());
        accountHolderDTO.setPrimaryAddress(accountHolder.getPrimaryAddress());
        accountHolderDTO.setMailingAddress(accountHolder.getMailingAddress());
        accountHolderDTO.setAccountList(accountHolder.getAccountList());
        accountHolderDTO.setSecondaryAccountList(accountHolder.getSecondaryAccountList());

        return accountHolderDTO;
    }
}
