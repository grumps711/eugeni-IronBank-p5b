package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard extends Account {

//    default: 100 Max: 100000 Min: 100
    @NotNull
    @Value("${credit.card.credit.limit:100}")
    private BigDecimal creditLimit;

//    default: 0.2  Max: 0.2 Min: 0.1
    @NotNull
    @Value("${credit.card.interest.rate:0.2}")
    private BigDecimal interestRate;


    @PostConstruct
    public void init() {
        if (interestRate.compareTo(BigDecimal.valueOf(0.2)) > 0 || interestRate.compareTo(BigDecimal.valueOf(0.1)) < 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }

        if (creditLimit.compareTo(BigDecimal.valueOf(100000)) > 0 || creditLimit.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new IllegalArgumentException("Invalid credit limit");
        }
    }
}

