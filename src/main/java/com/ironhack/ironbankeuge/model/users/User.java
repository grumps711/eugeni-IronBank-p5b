package com.ironhack.ironbankeuge.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="checking_seq_gen")
    @SequenceGenerator(name="checking_seq_gen", sequenceName="checking_sequence")
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    @CreationTimestamp
    private LocalDateTime creationDate;
    private String roles;
    private Boolean isAccountNonLocked;

    public User() {
        this.isAccountNonLocked=true;
    }

    public User(String firstName, String lastName, String username, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAccountNonLocked = true;
    }

    public User(String role_third_party) {
    }
}
