package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.usersDTO.AdminDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.Admin;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public Admin createAdmin(AdminDTO adminDTO) {

        var admin = new Admin();
        admin.setFirstName(adminDTO.getFirstName());
        admin.setLastName(adminDTO.getLastName());
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        admin.setRoles("ROLE_ADMIN");
        admin.setIsAccountNonLocked(true);

        return adminRepository.save(admin);

    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public void deleteAdminByUsername(String username) {
        var adminToDelete = findAdminByUsername(username);
        adminRepository.delete(adminToDelete);
    }

    private Admin findAdminByUsername(String username) {
        return adminRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User updateAdmin(String username, Optional<String> username1, Optional<String> firstName, Optional<String> lastName, Optional<Boolean> isAccountNonLocked, Optional<String> password) {
        var adminToUpdate = findAdminByUsername (username);

        username1.ifPresent (adminToUpdate::setUsername);
        firstName.ifPresent (adminToUpdate::setFirstName);
        lastName.ifPresent (adminToUpdate::setLastName);
        password.ifPresent(adminToUpdate::setPassword);
        isAccountNonLocked.ifPresent(adminToUpdate::setIsAccountNonLocked);

        return adminRepository.save(adminToUpdate);
    }
}
