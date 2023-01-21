package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.Users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {
}
