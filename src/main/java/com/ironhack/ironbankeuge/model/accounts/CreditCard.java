package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class CreditCard extends Account{

    private BigDecimal creditLimit;

    private BigDecimal interestRate;

    public CreditCard(String secretKey, String accountType, Money balance, BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountStatus accountStatus, BigDecimal creditLimit, BigDecimal interestRate) {
        super(secretKey, "CREDIT", balance, penaltyFee, primaryOwner, secondaryOwner, accountStatus);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }
}
