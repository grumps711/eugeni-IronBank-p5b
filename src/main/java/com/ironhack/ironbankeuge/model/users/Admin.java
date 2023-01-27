package com.ironhack.ironbankeuge.model.users;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Admin extends User{

    public Admin(String firstName, String lastName, String username, String password, String roles) {
        super(firstName, lastName, username, password, "ROLE_ADMIN");
    }
}
