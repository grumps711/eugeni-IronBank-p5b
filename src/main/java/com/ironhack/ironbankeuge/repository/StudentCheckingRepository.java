package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking,Long> {
}
