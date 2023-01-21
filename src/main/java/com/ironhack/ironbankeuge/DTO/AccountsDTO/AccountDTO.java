package com.ironhack.ironbankeuge.DTO.AccountsDTO;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AccountDTO {
    private String secretKey;
    private Money balance;
    private String primaryOwner;
    private String secondaryOwner;
    private BigDecimal penaltyFee;
    private AccountHolder owner;
    private AccountStatus accountStatus;
}
