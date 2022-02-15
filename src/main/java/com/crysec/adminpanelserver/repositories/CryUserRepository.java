package com.crysec.adminpanelserver.repositories;

import com.crysec.adminpanelserver.entities.CryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryUserRepository extends JpaRepository<CryUser, Long> {
}
