package com.yhren.Dao.Bean;

public class CompanyBasic {
    private Integer companyId;

    private String companyName;

    private String companyPath;

    private String companyContacts;

    private String companyTel;

    private Integer companyPass;

    private String companyCreateTime;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyPath() {
        return companyPath;
    }

    public void setCompanyPath(String companyPath) {
        this.companyPath = companyPath == null ? null : companyPath.trim();
    }

    public String getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(String companyContacts) {
        this.companyContacts = companyContacts == null ? null : companyContacts.trim();
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public Integer getCompanyPass() {
        return companyPass;
    }

    public void setCompanyPass(Integer companyPass) {
        this.companyPass = companyPass;
    }

    public String getCompanyCreateTime() {
        return companyCreateTime;
    }

    public void setCompanyCreateTime(String companyCreateTime) {
        this.companyCreateTime = companyCreateTime == null ? null : companyCreateTime.trim();
    }
}