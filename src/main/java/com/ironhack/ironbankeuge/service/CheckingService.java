package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.CheckingDTO;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.repository.CheckingRepository;
import com.ironhack.ironbankeuge.repository.StudentCheckingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class CheckingService {

    private final AccountHolderRepository accountHolderRepository;
    private final StudentCheckingRepository studentCheckingRepository;
    private final CheckingRepository checkingRepository;
    private final AccountHolderService accountHolderService;

    public Checking createChecking(CheckingDTO checkingDTO) {

        var checkingAccount = new Checking();
        var accountHolderFound = accountHolderService.findAccountHolderByUsername(checkingDTO.getPrimaryOwner().getUsername());

        checkingAccount.setSecretKey(checkingDTO.getSecretKey());
        checkingAccount.setBalance(checkingDTO.getBalance());
        checkingAccount.setPrimaryOwner(accountHolderFound);
//        checkingAccount.setSecondaryOwner();
        checkingAccount.setPenaltyFee(checkingDTO.getPenaltyFee());
        checkingAccount.setAccountStatus(AccountStatus.ACTIVE);
        checkingAccount.getPrimaryOwner().getDateOfBirth();

        if(isStudent(accountHolderFound)){
            checkingAccount.setAccountType("STUDENT_CHECKING");
        }   else{
            checkingAccount.setAccountType("CHECKING");
            checkingAccount.setMinimumBalance(BigDecimal.valueOf(250));
            checkingAccount.setMonthlyMaintenanceFee(BigDecimal.valueOf(12));
        }

        return checkingRepository.save(checkingAccount);
    }

    public Boolean isStudent(AccountHolder accountHolderFound){

        Boolean isStudentChecking;
        LocalDate dateOfBirth = accountHolderFound.getDateOfBirth();
        LocalDate today = LocalDate.now();

        Period age = Period.between(dateOfBirth,today);

        if(age.getYears() < 25){
            return isStudentChecking = true;
        } else {
            return false;
        }
    }
}
