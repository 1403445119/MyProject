package com.yhren.Dao.Bean;

public class StaffBasic {
    private Integer staffId;

    private String staffName;

    private String staffTel;

    private String staffPath;

    private Integer staffSalary;

    private Integer staffAge;

    private String staffSex;

    private Integer staffStatus;

    private Integer staffCheck;

    private String staffRemarks;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel == null ? null : staffTel.trim();
    }

    public String getStaffPath() {
        return staffPath;
    }

    public void setStaffPath(String staffPath) {
        this.staffPath = staffPath == null ? null : staffPath.trim();
    }

    public Integer getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(Integer staffSalary) {
        this.staffSalary = staffSalary;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public Integer getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Integer staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Integer getStaffCheck() {
        return staffCheck;
    }

    public void setStaffCheck(Integer staffCheck) {
        this.staffCheck = staffCheck;
    }

    public String getStaffRemarks() {
        return staffRemarks;
    }

    public void setStaffRemarks(String staffRemarks) {
        this.staffRemarks = staffRemarks == null ? null : staffRemarks.trim();
    }
}