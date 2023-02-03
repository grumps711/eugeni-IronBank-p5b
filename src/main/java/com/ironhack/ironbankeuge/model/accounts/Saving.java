package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Saving extends Account{

//    default: 1000 Max: 1000 Min: 100
    @Value("${saving.minimum.balance:1000}")
    private BigDecimal minimumBalance;

//    default: 0.0025 Max: 0.5 Min: -
    @Value("${saving.interest.rate:0.0025}")
    private BigDecimal interestRate;


    @PostConstruct
    public void init() {
        if (minimumBalance.compareTo(BigDecimal.valueOf(1000)) > 0 || interestRate.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new IllegalArgumentException("Invalid minimum balance");
        }

        if (interestRate.compareTo(BigDecimal.valueOf(0.5)) > 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
    }
}
