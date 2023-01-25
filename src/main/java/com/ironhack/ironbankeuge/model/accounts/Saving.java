package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Saving extends Account{

    private BigDecimal minimumBalance;

    private BigDecimal interestRate;

    public Saving(String secretKey, String accountType, Money balance, BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountStatus accountStatus, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(secretKey, "SAVING", balance, penaltyFee, primaryOwner, secondaryOwner, accountStatus);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }
}
