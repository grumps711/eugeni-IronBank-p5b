package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.Accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking,Long> {
}
