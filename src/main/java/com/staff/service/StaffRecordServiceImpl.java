package com.staff.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.staff.dto.StaffRecordRequest;
import com.staff.dto.StaffRecordResponse;
import com.staff.model.StaffRecord;
import com.staff.repository.StaffRepository;


@Service("staffRecordService")
public class StaffRecordServiceImpl implements StaffRecordService {

    @Autowired
    StaffRepository staffrepo;


    @Override
    public StaffRecord addStaffRecord(StaffRecordRequest staffdetails) {
        StaffRecord record = new StaffRecord();
        record.setBranch(staffdetails.getBranch());
        record.setDateOfBirth(staffdetails.getDateOfBirth());
        record.setDepartment(staffdetails.getDepartment());
        record.setEmail(staffdetails.getEmail());
        record.setExtension(staffdetails.getExtension());
        record.setFirstName(staffdetails.getFirstName());
        record.setFloor(staffdetails.getFloor());
        record.setImage(staffdetails.getImage());
        record.setLastName(staffdetails.getLastName());
        record.setPhone(staffdetails.getPhone());
        record.setPosition(staffdetails.getPosition());
        return staffrepo.save(record);
    }


    @Override
    public boolean delete(Long id) {
        staffrepo.delete(id);
        return true;
    }


    @Override
    public Page<StaffRecord> findAll(Pageable pageable) {
        return staffrepo.findAll(pageable);
    }


    @Override
    public List<StaffRecordResponse> findByFirstNameOrLastNameOrDepartmentOrFloor(String name) {
        return staffrepo.findByFirstNameOrLastNameOrDepartmentOrFloor("%" + name + "%").stream().map(record -> {
            StaffRecordResponse response = new StaffRecordResponse();
            response.setBranch(record.getBranch());
            response.setDateOfBirth(record.getDateOfBirth());
            response.setDepartment(record.getDepartment());
            response.setEmail(record.getEmail());
            response.setExtension(record.getExtension());
            response.setFirstName(record.getFirstName());
            response.setFloor(record.getFloor());
            response.setImage(record.getImage());
            response.setLastName(record.getLastName());
            response.setPhone(record.getPhone());
            response.setPosition(record.getPosition());
            return response;
        }).collect(Collectors.toList());
    }


    @Override
    public List<StaffRecordResponse> findStaffById(Long id) {
        return staffrepo.findStaffById(id).stream().map(record -> {
            StaffRecordResponse response = new StaffRecordResponse();
            response.setBranch(record.getBranch());
            response.setDateOfBirth(record.getDateOfBirth());
            response.setDepartment(record.getDepartment());
            response.setEmail(record.getEmail());
            response.setExtension(record.getExtension());
            response.setFirstName(record.getFirstName());
            response.setFloor(record.getFloor());
            response.setImage(record.getImage());
            response.setLastName(record.getLastName());
            response.setPhone(record.getPhone());
            response.setPosition(record.getPosition());
            return response;
        }).collect(Collectors.toList());
    }


    @Override
    public StaffRecord updateStaffRecordById(StaffRecordRequest recordRequest) {
        StaffRecord record = new StaffRecord();
        record.setBranch(recordRequest.getBranch());
        record.setDateOfBirth(recordRequest.getDateOfBirth());
        record.setDepartment(recordRequest.getDepartment());
        record.setEmail(recordRequest.getEmail());
        record.setExtension(recordRequest.getExtension());
        record.setFirstName(recordRequest.getFirstName());
        record.setFloor(recordRequest.getFloor());
        record.setImage(recordRequest.getImage());
        record.setLastName(recordRequest.getLastName());
        record.setPhone(recordRequest.getPhone());
        record.setPosition(recordRequest.getPosition());
        return staffrepo.save(record);
    }
}
