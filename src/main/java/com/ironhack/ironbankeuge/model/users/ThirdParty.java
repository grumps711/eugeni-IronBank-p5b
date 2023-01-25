package com.ironhack.ironbankeuge.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
public class ThirdParty extends User{

    public ThirdParty(String firstName, String lastName, String username, String password, String roles) {
        super(firstName, lastName, username, password, "THIRD_PARTY");
    }
}
