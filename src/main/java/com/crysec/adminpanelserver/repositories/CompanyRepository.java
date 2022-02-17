package com.crysec.adminpanelserver.repositories;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c.cryUsers " +
            "FROM Company c " +
            "WHERE c.id = :id"  )
    List<CryUser> findUsers(@Param("id") Long id);

    Optional<Company> findByName(String name);

    @Query("SELECT c.cryGroups " +
            "FROM Company c " +
            "WHERE c.id = :id"  )
    List<CryGroup> findGroups(Long id);

    @Query("SELECT c.id FROM Company c WHERE c.cod = :cod")
    Optional<Long> findByCod(@Param("cod") String cod);



}
