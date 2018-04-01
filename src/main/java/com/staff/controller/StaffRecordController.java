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

import com.staff.model.StaffRecord;
import com.staff.repository.StaffRepository;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class StaffRecordController {

    private StaffRepository staffrepo;


    @Autowired
    public StaffRecordController(StaffRepository staffrepo) {
        this.staffrepo = staffrepo;
    }


    @RequestMapping(value = "/staff/delete/{id}", method = RequestMethod.POST)
    public boolean deleteStaffRecordById(@PathVariable Long id) {
        staffrepo.delete(id);
        return true;
    }


    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET)
    public StaffRecord getStaffRecordById(@PathVariable Long id) {
        return staffrepo.findOne(id);
    }


    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public Page<StaffRecord> getStaffRecords(Pageable pageable) {
        return staffrepo.findAll(pageable);
    }


    @RequestMapping(value = "/staff/name", method = RequestMethod.GET)
    public List<StaffRecord> getStaffRecords(@RequestParam String name) {
        if (!StringUtils.isEmpty(name)) {
            return staffrepo.findByFirstNameOrLastNameOrDepartmentOrFloor("%" + name + "%");
        }
        return new ArrayList<StaffRecord>();
    }


    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public StaffRecord postStaffRecord(@RequestBody StaffRecord staffdetails) {
        return staffrepo.saveAndFlush(staffdetails);
    }


    @RequestMapping(value = "/staff/id/{id}", method = RequestMethod.POST)
    public StaffRecord updateStaffRecord(@PathVariable Long id, @RequestBody StaffRecord record) {
        record.setId(id);
        return staffrepo.save(record);
    }
}
