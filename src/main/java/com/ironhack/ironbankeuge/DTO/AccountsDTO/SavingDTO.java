package com.ironhack.ironbankeuge.DTO.AccountsDTO;

import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.Accounts.Checking;
import com.ironhack.ironbankeuge.model.Accounts.Saving;
import com.ironhack.ironbankeuge.model.Money;
import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import jakarta.persistence.Embedded;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
        savingDTO.setOwner(saving.getOwner());
        savingDTO.setAccountStatus(saving.getAccountStatus());
//        saving
        savingDTO.setMinimumBalance(saving.getMinimumBalance());
        savingDTO.setCreationDate(saving.getCreationDate());
        savingDTO.setInterestRate(saving.getInterestRate());

        return savingDTO;
    }
}
