package com.yhren.Dao.Bean;

public class MaterialsBasic {
    private Integer matId;

    private String matName;

    private Integer matCount;

    private Integer matOut;

    private Integer matResidue;

    private String matUnit;

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName == null ? null : matName.trim();
    }

    public Integer getMatCount() {
        return matCount;
    }

    public void setMatCount(Integer matCount) {
        this.matCount = matCount;
    }

    public Integer getMatOut() {
        return matOut;
    }

    public void setMatOut(Integer matOut) {
        this.matOut = matOut;
    }

    public Integer getMatResidue() {
        return matResidue;
    }

    public void setMatResidue(Integer matResidue) {
        this.matResidue = matResidue;
    }

    public String getMatUnit() {
        return matUnit;
    }

    public void setMatUnit(String matUnit) {
        this.matUnit = matUnit == null ? null : matUnit.trim();
    }
}