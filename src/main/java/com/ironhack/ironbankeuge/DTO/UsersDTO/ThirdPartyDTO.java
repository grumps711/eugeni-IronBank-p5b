package com.ironhack.ironbankeuge.DTO.UsersDTO;

import com.ironhack.ironbankeuge.model.Users.Admin;
import com.ironhack.ironbankeuge.model.Users.ThirdParty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyDTO extends UserDTO{


    public ThirdPartyDTO fromEntity(ThirdParty thirdParty){
        var thirdPartyDTO = new ThirdPartyDTO();
//        user
        thirdPartyDTO.setFirstName(thirdParty.getFirstName());
        thirdPartyDTO.setLastName(thirdParty.getLastName());
        thirdPartyDTO.setEmail(thirdParty.getEmail());
        thirdPartyDTO.setPassword(thirdParty.getPassword());
        thirdPartyDTO.setCreationDate(thirdParty.getCreationDate());
//        third-party

        return thirdPartyDTO;
    }
}
