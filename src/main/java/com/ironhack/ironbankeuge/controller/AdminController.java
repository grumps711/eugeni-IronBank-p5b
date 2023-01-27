package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AdminDTO;
import com.ironhack.ironbankeuge.model.users.AccountHolder;
import com.ironhack.ironbankeuge.model.users.Admin;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody AdminDTO adminDTO){
        return adminService.createAdmin(adminDTO);
    }


    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Admin> findAllAdmins(){
        return adminService.findAll();
    }

    @PatchMapping("/modify/{username}")
    public User updateAdmin (@PathVariable String username,
                                     @RequestParam Optional<String> username1,
                                     @RequestParam Optional<String> firstName,
                                     @RequestParam Optional <String> lastName,
                                     @RequestParam Optional <String> password,
                                     @RequestParam Optional <Boolean> isAccountNonLocked
    ){
        return adminService.updateAdmin (username,username1,firstName, lastName, isAccountNonLocked, password);
    }

    @DeleteMapping("delete/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin (@PathVariable ("username") String username) {
        adminService.deleteAdminByUsername(username);
    }
}