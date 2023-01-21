package com.ironhack.ironbankeuge.DTO.usersDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Instant creationDate;

}
