package com.ironhack.ironbankeuge.model.accounts;

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
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard extends Account{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal creditLimit;

    private BigDecimal interestRate;

    public CreditCard(BigDecimal creditLimit, BigDecimal interestRate) {
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        setPenaltyFee(BigDecimal.valueOf(40));
    }
}
