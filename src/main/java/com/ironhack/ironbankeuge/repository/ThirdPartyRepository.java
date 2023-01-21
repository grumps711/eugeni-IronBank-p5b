package com.ironhack.ironbankeuge.repository;

import com.ironhack.ironbankeuge.model.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty,Long> {
}
