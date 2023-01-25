package com.ironhack.ironbankeuge.controller;

import com.ironhack.ironbankeuge.DTO.usersDTO.AdminDTO;
import com.ironhack.ironbankeuge.model.users.User;
import com.ironhack.ironbankeuge.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/admin")
public class AdminController {

    private final AdminService adminService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public User createAdmin(@RequestBody AdminDTO adminDTO){
//        return adminService.createAdmin(adminDTO);
//    }
}