package com.ironhack.ironbankeuge.model.users;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
public class Admin extends User{

    public Admin(String firstName, String lastName, String username, String password, Instant creationDate, String roles) {
        super(firstName, lastName, username, password, creationDate, "ADMIN");
    }
}
