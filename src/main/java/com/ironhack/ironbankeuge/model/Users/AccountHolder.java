package com.ironhack.ironbankeuge.model.Users;

import com.ironhack.ironbankeuge.model.Accounts.Account;
import com.ironhack.ironbankeuge.model.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolder extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;

    private String primaryAddress;

    private String mailingAddress;

    @OneToMany(mappedBy = "owner")
    private List<Account> accountList;

    @OneToMany(mappedBy = "owner")
    private List<Account> secondaryAccountList;

    public AccountHolder(LocalDate dateOfBirth, String primaryAddress, String mailingAddress, List<Account> accountList, List<Account> secondaryAccountList) {
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.accountList = accountList;
        this.secondaryAccountList = secondaryAccountList;
    }
}
