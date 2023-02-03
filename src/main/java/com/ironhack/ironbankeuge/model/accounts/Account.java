package com.ironhack.ironbankeuge.model.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    private long id;

    @NotNull
    private String secretKey;

    private BigDecimal balance;

//1. validation instalado  2. @min @notnull etc. en atributos   3. que tenga el @valid en el endpoint
    @CreationTimestamp
    private Date CreationDate;

    @NotNull
    private String accountType;

    private final BigDecimal penaltyFee = BigDecimal.valueOf(40);

    @ManyToOne
    @JsonIgnore
    private AccountHolder primaryOwner;

    @ManyToOne
    @JsonIgnore
    private AccountHolder secondaryOwner;

    @Enumerated
    private AccountStatus accountStatus;

    public Account(String secretKey, String accountType, BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.secretKey = secretKey;
        this.accountType = accountType;
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.accountStatus = AccountStatus.ACTIVE;
    }
}
