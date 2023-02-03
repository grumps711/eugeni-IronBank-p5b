package com.ironhack.ironbankeuge.demo;

import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.Admin;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {

    private final AccountHolderRepository accountHolderRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser() {
        log.info("Starting demo user loading...");

        AccountHolder accountHolderTest = new AccountHolder(
                "AccountHolder",
                "Testing",
                "accountholdertest",
                passwordEncoder.encode("accountholdertest"),
                LocalDate.parse("2010-01-01"),
                "Hamburger St.",
                "Pickle Alley",
                null
        );
        accountHolderRepository.save(accountHolderTest);
        log.info("Account Holder user named " + accountHolderTest.getUsername() + " was created successfully");

        Admin AdminTest = new Admin(
                "Admin",
                "Testing",
                "admintest",
                passwordEncoder.encode("admintest"),
                "ROLE_ADMIN"
        );
        adminRepository.save(AdminTest);
        log.info("Admin user named " + AdminTest.getUsername() + " was created successfully");

        log.info("Finished demo user loading.");
    }
}
