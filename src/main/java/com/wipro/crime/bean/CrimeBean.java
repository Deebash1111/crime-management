package com.wipro.crime.bean;
import java.util.Date;
public class CrimeBean {
    private String caseId;
    private String caseTitle;
    private String suspectName;
    private String crimeType;
    private Date crimeDate;
    private String location;
    private String remarks;
    public String getCaseId() {
        return caseId;
    }
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
    public String getCaseTitle() {
        return caseTitle;
    }
    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }
    public String getSuspectName() {
        return suspectName;
    }
    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }
    public String getCrimeType() {
        return crimeType;
    }
    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }
    public Date getCrimeDate() {
        return crimeDate;
    }
    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}