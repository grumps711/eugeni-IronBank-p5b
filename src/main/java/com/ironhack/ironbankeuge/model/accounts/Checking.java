package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Checking extends Account{

    @NotNull
    private BigDecimal MinimumBalance;

    @NotNull
    private BigDecimal MonthlyMaintenanceFee;

    public Checking(String secretKey, String accountType, Money balance, BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(secretKey, "CHECKING", balance, penaltyFee, primaryOwner, secondaryOwner);
        MinimumBalance = minimumBalance;
        MonthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
