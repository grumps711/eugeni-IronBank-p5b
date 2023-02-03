package com.ironhack.ironbankeuge.DTO.usersDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderDTO extends UserDTO {

//    accountholder
    private LocalDate dateOfBirth;
    private String primaryAddress;
    private String mailingAddress;
    @JsonIgnore
    private List<Account> accountList;
    private List<Account> secondaryAccountList;

    public AccountHolderDTO(String firstName, String lastName, String username, String password, String roles, LocalDate dateOfBirth, String primaryAddress, String mailingAddress, List<Account> accountList, List<Account> secondaryAccountList) {
        super(firstName, lastName, username, password, roles);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.accountList = accountList;
        this.secondaryAccountList = secondaryAccountList;
    }


    public AccountHolderDTO fromEntity(AccountHolder accountHolder){
        var accountHolderDTO = new AccountHolderDTO();
//        user
        accountHolderDTO.setFirstName(accountHolder.getFirstName());
        accountHolderDTO.setLastName(accountHolder.getLastName());
        accountHolderDTO.setUsername(accountHolder.getUsername());
        accountHolderDTO.setPassword(accountHolder.getPassword());
        accountHolderDTO.setRoles(accountHolder.getRoles());
//        account-holder
        accountHolderDTO.setDateOfBirth(accountHolder.getDateOfBirth());
        accountHolderDTO.setPrimaryAddress(accountHolder.getPrimaryAddress());
        accountHolderDTO.setMailingAddress(accountHolder.getMailingAddress());
        accountHolderDTO.setAccountList(accountHolder.getAccountListAsPrimaryOwner());

        return accountHolderDTO;
    }
}
