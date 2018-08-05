package com.yhren.Dao.Bean;

public class LeaseRecord {
    private Integer leaseId;

    private Integer leaseMar;

    private Integer leaseCom;

    private Double leasePrice;

    private String leaseCreateTime;

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }

    public Integer getLeaseMar() {
        return leaseMar;
    }

    public void setLeaseMar(Integer leaseMar) {
        this.leaseMar = leaseMar;
    }

    public Integer getLeaseCom() {
        return leaseCom;
    }

    public void setLeaseCom(Integer leaseCom) {
        this.leaseCom = leaseCom;
    }

    public Double getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(Double leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeaseCreateTime() {
        return leaseCreateTime;
    }

    public void setLeaseCreateTime(String leaseCreateTime) {
        this.leaseCreateTime = leaseCreateTime == null ? null : leaseCreateTime.trim();
    }
}