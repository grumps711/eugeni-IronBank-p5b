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

    private String hashedKey;

    public ThirdParty(String roles) {
        super("ROLE_THIRD_PARTY");
    }

    public ThirdParty(String role_third_party, String hashedKey) {
    }
}
