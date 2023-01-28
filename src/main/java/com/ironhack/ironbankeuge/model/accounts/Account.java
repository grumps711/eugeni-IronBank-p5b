package com.ironhack.ironbankeuge.model.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.Money;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secretKey;

    @Embedded
    private Money balance;


    @CreationTimestamp
    private Date CreationDate;

    private String accountType;

    private BigDecimal penaltyFee;

    @ManyToOne
    @JsonIgnore
    private AccountHolder primaryOwner;

    @ManyToOne
    @JsonIgnore
    private AccountHolder secondaryOwner;

    @Enumerated
    private AccountStatus accountStatus;

    public Account(String secretKey, String accountType, Money balance, BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.secretKey = secretKey;
        this.accountType = accountType;
        this.balance = balance;
        this.penaltyFee = penaltyFee;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.accountStatus = AccountStatus.ACTIVE;
    }
}
