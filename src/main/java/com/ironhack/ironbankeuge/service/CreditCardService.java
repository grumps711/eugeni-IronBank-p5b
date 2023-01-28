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

    public CreditCard createCredit(AccountValidationDTO accountValidationDTO) {
        var creditCard = new CreditCard();
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(accountValidationDTO.getUsername());

        creditCard.setSecretKey(accountValidationDTO.getSecretKey());
        creditCard.setBalance(accountValidationDTO.getBalance());
        creditCard.setPrimaryOwner(accountHolderFound);
//        creditCard.setSecondaryOwner();
        creditCard.setPenaltyFee(accountValidationDTO.getPenaltyFee());
        creditCard.setAccountType("CREDIT");
//        creditCard.setAccountStatus(AccountStatus.ACTIVE);
        creditCard.setCreditLimit(accountValidationDTO.getCreditLimit());
        creditCard.setInterestRate(accountValidationDTO.getInterestRate());

        return creditCardRepository.save(creditCard);
    }
}
