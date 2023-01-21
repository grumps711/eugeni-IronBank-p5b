package com.ironhack.ironbankeuge.model.Accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
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
public class Checking extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal MinimumBalance;

    private BigDecimal MonthlyMaintenanceFee;

    private Date CreationDate;

    public Checking(Money minimumBalance, Money monthlyMaintenanceFee, Date creationDate, AccountStatus accountStatus) {
        CreationDate = creationDate;
        setPenaltyFee(BigDecimal.valueOf(40));
        setMinimumBalance(BigDecimal.valueOf(250));
        setMonthlyMaintenanceFee(BigDecimal.valueOf(12));
    }
}
