package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.AccountStatus;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.accounts.Checking;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;
    private final PasswordEncoder passwordEncoder;
    private final CheckingRepository checkingRepository;
    private final SavingRepository savingRepository;
    private final CreditCardRepository creditCardRepository;
    private final AccountRepository accountRepository;



    public AccountHolder createAccountHolder(AccountHolderDTO accountHolderDTO) {
        var accountHolder = new AccountHolder();
        accountHolder.setFirstName(accountHolderDTO.getFirstName());
        accountHolder.setLastName(accountHolderDTO.getLastName());
        accountHolder.setUsername(accountHolderDTO.getUsername());
        accountHolder.setPassword(passwordEncoder.encode(accountHolderDTO.getPassword()));
        accountHolder.setRoles("ROLE_ACCOUNT_HOLDER");
        accountHolder.setIsAccountNonLocked(true);
        accountHolder.setDateOfBirth(accountHolderDTO.getDateOfBirth());
        accountHolder.setPrimaryAddress(accountHolderDTO.getPrimaryAddress());
        accountHolder.setMailingAddress(accountHolderDTO.getMailingAddress());
        accountHolder.setAccountListAsPrimaryOwner(accountHolderDTO.getAccountList());

        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }

    public void deleteAccountHolderByUsername(String username) {
        var accountHolderToDelete = findAccountHolderByUsername(username);
        accountHolderRepository.delete(accountHolderToDelete);
    }

    public AccountHolder findAccountHolderByUsername(String username) {
        return accountHolderRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User updateAccountHolder(String username, Optional<String> username1, Optional<String> firstName, Optional<String> lastName, Optional<String> roles, Optional<Boolean> isAccountNonLocked, Optional<String> password, Optional<LocalDate> dateOfBirth, Optional<String> mailingAddress, Optional<String> primaryAddress) {

        var accountHolderToUpdate = findAccountHolderByUsername (username);

        username1.ifPresent (accountHolderToUpdate::setUsername);
        firstName.ifPresent (accountHolderToUpdate::setFirstName);
        lastName.ifPresent (accountHolderToUpdate::setLastName);
        password.ifPresent(accountHolderToUpdate::setPassword);
        roles.ifPresent(accountHolderToUpdate::setRoles);
        isAccountNonLocked.ifPresent(accountHolderToUpdate::setIsAccountNonLocked);
        dateOfBirth.ifPresent(accountHolderToUpdate::setDateOfBirth);
        mailingAddress.ifPresent(accountHolderToUpdate::setMailingAddress);
        primaryAddress.ifPresent(accountHolderToUpdate::setPrimaryAddress);

        return accountHolderRepository.save(accountHolderToUpdate);
    }

    public User updateAccountLists(String username, Optional<List<Account>> accountList) {
        var accountHolderToUpdate = findAccountHolderByUsername (username);

        accountList.ifPresent(accountHolderToUpdate::setAccountListAsPrimaryOwner);

        return accountHolderRepository.save(accountHolderToUpdate);
    }

    public void transferFunds(TransferDTO transferDTO) {

        if(transferDTO.getAccountTypeOrigin().equals("CHECKING")||transferDTO.getAccountTypeOrigin().equals("STUDENT_CHECKING")){
            var checkingOrigin = checkingRepository.findById(transferDTO.getAccountIdOrigin());
            checkingOrigin.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().subtract(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });

        } else if (transferDTO.getAccountTypeDestination().equals("SAVING")) {
            var savingOrigin = savingRepository.findById(transferDTO.getAccountIdOrigin());
            savingOrigin.ifPresent(saving -> {
                saving.setBalance(saving.getBalance().subtract(transferDTO.getAmount()));
                savingRepository.save(saving);
            });
        } else if (transferDTO.getAccountTypeDestination().equals("CREDIT")) {
            var checkingOrigin = checkingRepository.findById(transferDTO.getAccountIdOrigin());
            checkingOrigin.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().subtract(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });
        }
        
        if(transferDTO.getAccountTypeDestination().equals("CHECKING")||transferDTO.getAccountTypeDestination().equals("STUDENT_CHECKING")){
            var checkingDestination = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingDestination.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });

        } else if (transferDTO.getAccountTypeDestination().equals("SAVING")) {
            var savingDestination = savingRepository.findById(transferDTO.getAccountIdDestination());
            savingDestination.ifPresent(saving -> {
                saving.setBalance(saving.getBalance().add(transferDTO.getAmount()));
                savingRepository.save(saving);
            });
        } else if (transferDTO.getAccountTypeDestination().equals("CREDIT")) {
            var creditDestination = checkingRepository.findById(transferDTO.getAccountIdDestination());
            creditDestination.ifPresent(credit -> {
                credit.setBalance(credit.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(credit);
            });
        }
    }




    public void withdrawFunds(TransferDTO transferDTO) {

        if(transferDTO.getAccountTypeDestination().equals("CHECKING")||transferDTO.getAccountTypeDestination().equals("STUDENT_CHECKING")){
            var checkingToUpdate = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().subtract(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });

        } else if (transferDTO.getAccountTypeDestination().equals("SAVING")) {
            var savingToUpdate = savingRepository.findById(transferDTO.getAccountIdDestination());
            savingToUpdate.ifPresent(saving -> {
                saving.setBalance(saving.getBalance().subtract(transferDTO.getAmount()));
                savingRepository.save(saving);
            });
        } else if (transferDTO.getAccountTypeDestination().equals("CREDIT")) {
            var checkingToUpdate = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().subtract(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });
        }
    }




    public void depositFunds(TransferDTO transferDTO) {

        if(transferDTO.getAccountTypeDestination().equals("CHECKING")||transferDTO.getAccountTypeDestination().equals("STUDENT_CHECKING")){
            var checkingToUpdate = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });

        } else if (transferDTO.getAccountTypeDestination().equals("SAVING")) {
            var savingToUpdate = savingRepository.findById(transferDTO.getAccountIdDestination());
            savingToUpdate.ifPresent(saving -> {
                saving.setBalance(saving.getBalance().add(transferDTO.getAmount()));
                savingRepository.save(saving);
            });
        } else if (transferDTO.getAccountTypeDestination().equals("CREDIT")) {
            var checkingToUpdate = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });
        }
    }

    public void depositFundsThirdParty(TransferDTO transferDTO, String hashedKey) {




        if(transferDTO.getAccountTypeDestination().equals("CHECKING")||transferDTO.getAccountTypeDestination().equals("STUDENT_CHECKING")){
            var checkingToUpdate = checkingRepository.findCheckingBySecretKey(transferDTO.getSecretKey());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });

        } else if (transferDTO.getAccountTypeDestination().equals("SAVING")) {
            var savingToUpdate = savingRepository.findById(transferDTO.getAccountIdDestination());
            savingToUpdate.ifPresent(saving -> {
                saving.setBalance(saving.getBalance().add(transferDTO.getAmount()));
                savingRepository.save(saving);
            });
        } else if (transferDTO.getAccountTypeDestination().equals("CREDIT")) {
            var checkingToUpdate = checkingRepository.findById(transferDTO.getAccountIdDestination());
            checkingToUpdate.ifPresent(checking -> {
                checking.setBalance(checking.getBalance().add(transferDTO.getAmount()));
                checkingRepository.save(checking);
            });
        }

    }
}

//    public Account findAccountById(Long id) {
//        return accountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
//    }


//    public AccountHolder withdrawFunds(AccountHolderDTO accountHolderDTO) {
//    }
//}