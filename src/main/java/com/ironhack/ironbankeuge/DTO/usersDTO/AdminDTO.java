package com.ironhack.ironbankeuge.DTO.usersDTO;

import com.ironhack.ironbankeuge.model.users.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
