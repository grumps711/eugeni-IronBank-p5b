package com.ironhack.ironbankeuge.DTO.accountsDTO;

import com.ironhack.ironbankeuge.model.accounts.Checking;
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
    private BigDecimal MinimumBalance;
    private BigDecimal MonthlyMaintenanceFee;
    private Date CreationDate;

    public CheckingDTO fromEntity(Checking checking){
        var checkingDTO = new CheckingDTO();
//        account
        checkingDTO.setSecretKey(checking.getSecretKey());
        checkingDTO.setBalance(checking.getBalance());
        checkingDTO.setPrimaryOwner(checking.getPrimaryOwner());
        checkingDTO.setSecondaryOwner(checking.getSecondaryOwner());
        checkingDTO.setPenaltyFee(checking.getPenaltyFee());
        checkingDTO.setOwner(checking.getOwner());
        checkingDTO.setAccountStatus(checking.getAccountStatus());
//        checking
        checkingDTO.setMinimumBalance(checking.getMinimumBalance());
        checkingDTO.setMonthlyMaintenanceFee(checking.getMonthlyMaintenanceFee());
        checkingDTO.setCreationDate(checking.getCreationDate());

        return checkingDTO;
    }
}
