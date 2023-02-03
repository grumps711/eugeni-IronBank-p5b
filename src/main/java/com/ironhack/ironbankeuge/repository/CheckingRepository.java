package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckingRepository extends JpaRepository<Checking,Long> {

    public Optional<Checking> findCheckingBySecretKey(String secretKey);
}
