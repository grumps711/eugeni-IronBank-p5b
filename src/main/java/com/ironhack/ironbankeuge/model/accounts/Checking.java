package com.ironhack.ironbankeuge.model.accounts;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
public class Checking extends Account{

    private final BigDecimal minimumBalance = BigDecimal.valueOf(250);

    private final BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(12);

}
