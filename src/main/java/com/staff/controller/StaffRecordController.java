package com.staff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staff.dto.StaffRecordRequest;
import com.staff.dto.StaffRecordResponse;
import com.staff.model.StaffRecord;
import com.staff.service.StaffRecordService;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class StaffRecordController {

    private StaffRecordService staffRecordService;


    @Autowired
    public StaffRecordController(StaffRecordService staffRecordService) {
        this.staffRecordService = staffRecordService;
    }


    @RequestMapping(value = "/staff/delete/{id}", method = RequestMethod.POST)
    public boolean deleteStaffRecordById(@PathVariable Long id) {
        return staffRecordService.delete(id);
    }


    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET)
    public List<StaffRecordResponse> getStaffRecordById(@PathVariable Long id) {
        return staffRecordService.findStaffById(id);
    }


    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public Page<StaffRecord> getStaffRecords(Pageable pageable) {
        return staffRecordService.findAll(pageable);
    }


    @RequestMapping(value = "/staff/name", method = RequestMethod.GET)
    public List<StaffRecordResponse> getStaffRecords(@RequestParam String name) {
        if (!StringUtils.isEmpty(name)) {
            return staffRecordService.findByFirstNameOrLastNameOrDepartmentOrFloor("%" + name + "%");
        }
        return new ArrayList<StaffRecordResponse>();
    }


    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public StaffRecord postStaffRecord(@RequestBody StaffRecordRequest staffdetails) {
        return staffRecordService.addStaffRecord(staffdetails);
    }


    @RequestMapping(value = "/staff/id/{id}", method = RequestMethod.POST)
    public StaffRecord updateStaffRecordById(@PathVariable Long id, @RequestBody StaffRecordRequest record) {
        record.setId(id);
        return staffRecordService.updateStaffRecordById(record);
    }
}
