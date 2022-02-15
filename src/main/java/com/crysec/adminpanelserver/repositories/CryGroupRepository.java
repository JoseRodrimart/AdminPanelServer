package com.crysec.adminpanelserver.repositories;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryGroupRepository extends JpaRepository<CryGroup, Long> {
}
