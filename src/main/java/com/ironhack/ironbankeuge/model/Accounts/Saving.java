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
public class Saving extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal minimumBalance;

    private Date CreationDate;

    private BigDecimal interestRate;

    public Saving(BigDecimal minimumBalance, Date creationDate, AccountStatus accountStatus, BigDecimal interestRate) {
        this.minimumBalance = minimumBalance;
        CreationDate = creationDate;
        this.interestRate = interestRate;
        setPenaltyFee(BigDecimal.valueOf(40));
        setMinimumBalance(BigDecimal.valueOf(250));
    }
}
