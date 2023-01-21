package com.ironhack.ironbankeuge.DTO.AccountsDTO;

import com.ironhack.ironbankeuge.DTO.UsersDTO.AdminDTO;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Accounts.Checking;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import com.ironhack.ironbankeuge.model.Users.Admin;
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
