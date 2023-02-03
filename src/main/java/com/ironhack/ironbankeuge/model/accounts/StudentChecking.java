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
public class StudentChecking extends Account{

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public StudentChecking(String secretKey, String accountType, BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountStatus accountStatus, AccountStatus accountStatus1) {
        super(secretKey, "STUDENT_CHECKING", balance, primaryOwner, secondaryOwner);
        this.accountStatus = accountStatus1;
    }
}
