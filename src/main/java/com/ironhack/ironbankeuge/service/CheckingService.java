package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.CheckingDTO;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.repository.CheckingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckingService {

    private final AccountHolderRepository accountHolderRepository;
    private final CheckingRepository checkingRepository;
    private final AccountHolderService accountHolderService;

    public Checking createChecking(String username, CheckingDTO checkingDTO) {

        var checkingAccount = new Checking();
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(username);

        checkingAccount.setSecretKey(checkingDTO.getSecretKey());
        checkingAccount.setBalance(checkingDTO.getBalance());
        checkingAccount.setPrimaryOwner(accountHolderFound);
//        checkingAccount.setSecondaryOwner();
        checkingAccount.setPenaltyFee(checkingDTO.getPenaltyFee());
        checkingAccount.setAccountType("CHECKING");
//        checkingAccount.setAccountStatus(AccountStatus.ACTIVE);
        checkingAccount.setMinimumBalance(checkingDTO.getMinimumBalance());
        checkingAccount.setMonthlyMaintenanceFee(checkingDTO.getMonthlyMaintenanceFee());

        return checkingRepository.save(checkingAccount);
    }
}
