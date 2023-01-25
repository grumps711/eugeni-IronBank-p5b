package com.ironhack.ironbankeuge.DTO.accountsDTO;

import com.ironhack.ironbankeuge.model.accounts.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingDTO extends AccountDTO{

//    saving
    private BigDecimal minimumBalance;
    private Date CreationDate;
    private BigDecimal interestRate;

    public SavingDTO fromEntity(Saving saving){
        var savingDTO = new SavingDTO();
//        account
        savingDTO.setSecretKey(saving.getSecretKey());
        savingDTO.setBalance(saving.getBalance());
        savingDTO.setPrimaryOwner(saving.getPrimaryOwner());
        savingDTO.setSecondaryOwner(saving.getSecondaryOwner());
        savingDTO.setPenaltyFee(saving.getPenaltyFee());
        savingDTO.setAccountStatus(saving.getAccountStatus());
//        saving
        savingDTO.setMinimumBalance(saving.getMinimumBalance());
        savingDTO.setInterestRate(saving.getInterestRate());

        return savingDTO;
    }
}
