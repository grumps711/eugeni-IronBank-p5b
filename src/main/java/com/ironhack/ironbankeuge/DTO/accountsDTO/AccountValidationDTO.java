package com.ironhack.ironbankeuge.DTO.accountsDTO;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountValidationDTO {

    private String username;
    private String accountType;
    private AccountStatus accountStatus;
    private String secretKey;
    private Money balance;
    private AccountHolder primaryOwner;
    private BigDecimal penaltyFee;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
    private Date CreationDate;

}