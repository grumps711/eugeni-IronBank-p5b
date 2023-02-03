package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CreditCardDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.SavingDTO;
import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import com.ironhack.ironbankeuge.model.accounts.Saving;
import com.ironhack.ironbankeuge.repository.SavingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavingService {

    private final AccountHolderService accountHolderService;
    private final SavingRepository savingRepository;

    public Saving createSaving(SavingDTO savingDTO) {

        var savingAccount = new Saving();
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(savingDTO.getPrimaryOwner().getUsername());

        savingAccount.setSecretKey(savingDTO.getSecretKey());
        savingAccount.setBalance(savingDTO.getBalance());
        savingAccount.setPrimaryOwner(accountHolderFound);
        savingAccount.setAccountType("SAVING");
        savingAccount.setInterestRate(savingDTO.getInterestRate());
        savingAccount.setMinimumBalance(savingDTO.getMinimumBalance());

        return savingRepository.save(savingAccount);
    }

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
