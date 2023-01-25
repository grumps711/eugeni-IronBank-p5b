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
@NoArgsConstructor
public class Checking extends Account{

    private BigDecimal MinimumBalance;

    private BigDecimal MonthlyMaintenanceFee;

    public Checking(String secretKey, String accountType, Money balance, BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountStatus accountStatus, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(secretKey, "CHECKING", balance, penaltyFee, primaryOwner, secondaryOwner, accountStatus);
        MinimumBalance = minimumBalance;
        MonthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
