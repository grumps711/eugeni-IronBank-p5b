package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.accounts.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingRepository extends JpaRepository<Saving,Long> {
    Optional<Saving> findSavingBySecretKey(String secretKey);
}
