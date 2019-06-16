package com.staff.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.staff.dto.StaffRecordRequest;
import com.staff.dto.StaffRecordResponse;
import com.staff.model.StaffRecord;


public interface StaffRecordService {

    StaffRecord addStaffRecord(StaffRecordRequest staffdetails);


    boolean delete(Long id);


    Page<StaffRecord> findAll(Pageable pageable);


    List<StaffRecordResponse> findByFirstNameOrLastNameOrDepartmentOrFloor(String name);


    List<StaffRecordResponse> findStaffById(Long id);


    StaffRecord updateStaffRecordById(StaffRecordRequest record);
}
