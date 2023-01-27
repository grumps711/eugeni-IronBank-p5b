package com.ironhack.ironbankeuge.DTO.accountsDTO;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckingDTO extends AccountDTO{

//    checking
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;

    public CheckingDTO(String secretKey, Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String accountType, AccountStatus accountStatus, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(secretKey, balance, primaryOwner, secondaryOwner, penaltyFee, accountType, accountStatus);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public CheckingDTO fromEntity(Checking checking){
        var checkingDTO = new CheckingDTO();
//        account
        checkingDTO.setSecretKey(checking.getSecretKey());
        checkingDTO.setBalance(checking.getBalance());
        checkingDTO.setPrimaryOwner(checking.getPrimaryOwner());
        checkingDTO.setSecondaryOwner(checking.getSecondaryOwner());
        checkingDTO.setPenaltyFee(checking.getPenaltyFee());
        checkingDTO.setAccountStatus(checking.getAccountStatus());
//        checking
        checkingDTO.setMinimumBalance(checking.getMinimumBalance());
        checkingDTO.setMonthlyMaintenanceFee(checking.getMonthlyMaintenanceFee());

        return checkingDTO;
    }
}
