package com.ironhack.ironbankeuge.DTO.accountsDTO;

import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDTO extends AccountDTO{

//    creditcard
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCardDTO fromEntity(CreditCard creditCard){
        var creditCardDTO = new CreditCardDTO();
//        account
        creditCardDTO.setSecretKey(creditCard.getSecretKey());
        creditCardDTO.setBalance(creditCard.getBalance());
        creditCardDTO.setPrimaryOwner(creditCard.getPrimaryOwner());
        creditCardDTO.setSecondaryOwner(creditCard.getSecondaryOwner());
        creditCardDTO.setPenaltyFee(creditCard.getPenaltyFee());
        creditCardDTO.setOwner(creditCard.getOwner());
        creditCardDTO.setAccountStatus(creditCard.getAccountStatus());
//        credit-card
        creditCardDTO.setCreditLimit(creditCard.getCreditLimit());
        creditCardDTO.setInterestRate(creditCard.getInterestRate());

        return creditCardDTO;
    }
}
