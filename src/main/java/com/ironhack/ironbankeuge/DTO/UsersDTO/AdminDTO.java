package com.ironhack.ironbankeuge.DTO.UsersDTO;

import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import com.ironhack.ironbankeuge.model.Users.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO extends UserDTO{

    public AdminDTO fromEntity(Admin admin){
        var adminDTO = new AdminDTO();
//        user
        adminDTO.setFirstName(admin.getFirstName());
        adminDTO.setLastName(admin.getLastName());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setCreationDate(admin.getCreationDate());
//        admin

        return adminDTO;
    }
}
