package com.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.staff.model.StaffRecord;


@Repository
public interface StaffRepository extends JpaRepository<StaffRecord, Long> {

    @Query(value = "SELECT s FROM StaffRecord s WHERE " + "LOWER(s.firstName) LIKE LOWER(CONCAT(:name)) OR " + "LOWER(s.lastName) LIKE LOWER(:name) OR "
            + "LOWER(s.department) LIKE LOWER(CONCAT(:name))  OR " + "LOWER(s.floor) LIKE LOWER(CONCAT(:name))")
    List<StaffRecord> findByFirstNameOrLastNameOrDepartmentOrFloor(@Param("name") String name);


    @Query("select s from StaffRecord s where s.id=:id ")
    StaffRecord update(@Param("id") Long id);
}
