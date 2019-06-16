package com.staff.dto;

import java.beans.Transient;
import java.io.Serializable;


public class StaffRecordResponse implements Serializable {

    private String branch;

    private String dateOfBirth;

    private String department;

    private String email;

    private String extension;

    private String firstName;

    private String floor;

    private Long id;

    private String image;

    private String lastName;

    private String phone;

    private String position;


    public String getBranch() {
        return branch;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public String getDepartment() {
        return department;
    }


    public String getEmail() {
        return email;
    }


    public String getExtension() {
        return extension;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getFloor() {
        return floor;
    }


    public Long getId() {
        return id;
    }


    public String getImage() {
        return image;
    }


    public String getLastName() {
        return lastName;
    }


    @Transient
    public String getName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }


    public String getPhone() {
        return phone;
    }


    public String getPosition() {
        return position;
    }


    public void setBranch(String branch) {
        this.branch = branch;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setFloor(String floor) {
        this.floor = floor;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setPosition(String position) {
        this.position = position;
    }
}
