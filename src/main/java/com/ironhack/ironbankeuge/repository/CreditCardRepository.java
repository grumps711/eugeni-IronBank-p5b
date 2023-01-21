package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.Accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
