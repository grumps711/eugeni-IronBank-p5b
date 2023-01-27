package com.ironhack.ironbankeuge.model.users;

import com.ironhack.ironbankeuge.model.accounts.Account;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class AccountHolder extends User {

    private LocalDate dateOfBirth;
    private String primaryAddress;
    private String mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> accountList;

    @OneToMany(mappedBy = "secondaryOwner")
    private List<Account> Account;

    public AccountHolder(String firstName, String lastName, String username, String password, LocalDate dateOfBirth, String primaryAddress, String mailingAddress, List<Account> accountList) {
        super(firstName, lastName, username, password, "ROLE_ACCOUNT_HOLDER");
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.accountList = accountList;
    }

}
