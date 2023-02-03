package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CreditCardDTO;
import com.ironhack.ironbankeuge.model.accounts.CreditCard;
import com.ironhack.ironbankeuge.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final AccountHolderService accountHolderService;
    private final CreditCardRepository creditCardRepository;

    public CreditCard createCredit(CreditCardDTO creditCardDTO) {
        var creditCard = new CreditCard();
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(creditCardDTO.getPrimaryOwner().getUsername());

        creditCard.setSecretKey(creditCardDTO.getSecretKey());
        creditCard.setBalance(creditCardDTO.getBalance());
        creditCard.setPrimaryOwner(accountHolderFound);
//        creditCard.setSecondaryOwner();
        creditCard.setPenaltyFee(creditCardDTO.getPenaltyFee());
        creditCard.setAccountType("CREDIT");
//        creditCard.setAccountStatus(AccountStatus.ACTIVE);
        creditCard.setCreditLimit(creditCardDTO.getCreditLimit());
        creditCard.setInterestRate(creditCardDTO.getInterestRate());

        return creditCardRepository.save(creditCard);
    }
}
