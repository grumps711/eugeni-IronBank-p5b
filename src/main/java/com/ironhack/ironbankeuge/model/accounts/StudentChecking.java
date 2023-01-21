package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
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
public class StudentChecking extends Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public StudentChecking(Date creationDate, AccountStatus accountStatus) {
        this.creationDate = creationDate;
        this.accountStatus = accountStatus;
        setPenaltyFee(BigDecimal.valueOf(40));
    }
}
