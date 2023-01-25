package com.ironhack.ironbankeuge.service;

import com.ironhack.ironbankeuge.DTO.usersDTO.AdminDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.Admin;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.repository.AccountHolderRepository;
import com.ironhack.ironbankeuge.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        admin.setRoles("ADMIN");
        admin.setIsAccountNonLocked(true);

        return adminRepository.save(admin);

    }

}
