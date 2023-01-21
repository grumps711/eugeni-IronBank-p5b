package com.ironhack.ironbankeuge.model.users;

import com.ironhack.ironbankeuge.model.accounts.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
