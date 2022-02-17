package com.crysec.adminpanelserver.repositories;

import com.crysec.adminpanelserver.entities.Company;
import com.crysec.adminpanelserver.entities.CryGroup;
import com.crysec.adminpanelserver.entities.CryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryGroupRepository extends JpaRepository<CryGroup, Long> {

    // CryGroup_regularUsers
/*
    @Query(value= "select * from cry_user c where c.id not in (select cg.regular_users_id from cry_group_regular_users cg where cg.cry_group_id = :id)", nativeQuery = true)
    public List<DeadlineType> usersNotIncluded(@Param("id") Long id);*/

}
