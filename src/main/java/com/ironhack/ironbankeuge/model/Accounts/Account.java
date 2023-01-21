package com.ironhack.ironbankeuge.model.Accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import com.ironhack.ironbankeuge.model.Money;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secretKey;

    @Embedded
    private Money balance;

    private String primaryOwner;

    private String secondaryOwner;

    private BigDecimal penaltyFee;

    @ManyToOne
    private AccountHolder owner;

    @Enumerated
    private AccountStatus accountStatus;

}
