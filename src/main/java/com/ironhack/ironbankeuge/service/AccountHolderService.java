package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.accountsDTO.AccountValidationDTO;
import com.ironhack.ironbankeuge.DTO.accountsDTO.TransferDTO;
import com.ironhack.ironbankeuge.DTO.usersDTO.AccountHolderDTO;
import com.ironhack.ironbankeuge.model.accounts.Account;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;
    private final PasswordEncoder passwordEncoder;

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

    public AccountHolder transferFunds(TransferDTO transferDTO) {

        var accountHolderToUpdate = findAccountHolderByUsername (transferDTO.getUsernameDestination());
//        var accountToUpdate = accountHolderToUpdate.getAccountList().get();

        return accountHolderToUpdate;
    }


    public AccountValidationDTO depositFunds(AccountValidationDTO accountValidationDTO) {

        var accountHolderFound = findAccountHolderByUsername(accountValidationDTO.getUsername());
//        var accountFound = accountHolderFound.getAccountList().get();
        return accountValidationDTO;
    }

//    public AccountHolder withdrawFunds(AccountHolderDTO accountHolderDTO) {
//    }
}
