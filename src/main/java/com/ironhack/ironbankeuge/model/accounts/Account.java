package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.Money;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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
