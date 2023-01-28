package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.CreditCardDTO;
import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavingService {

//    public CreditCard createCredit(String username, CreditCardDTO creditDTO) {
//        var creditCard = new CreditCard();
//        var accountHolderFound = accountHolderService.findAccountHolderByUsername(username);
//
//        creditCard.setSecretKey(creditDTO.getSecretKey());
//        creditCard.setBalance(creditDTO.getBalance());
//        creditCard.setPrimaryOwner(accountHolderFound);
////        creditCard.setSecondaryOwner();
//        creditCard.setPenaltyFee(creditDTO.getPenaltyFee());
//        creditCard.setAccountType("CREDIT");
////        creditCard.setAccountStatus(AccountStatus.ACTIVE);
//        creditCard.setCreditLimit(creditDTO.getCreditLimit());
//        creditCard.setInterestRate(creditDTO.getInterestRate());
//
//        return creditCardRepository.save(creditCard);
//
//    }
}
