package com.cwg.model;


import java.sql.Date;

public class GradeSubBean {
    private String stuID;
    private String stuName;
    private String kindID;
    private String subID;
    private double grade;
    private Date examDate;


    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getKindID() {
        return kindID;
    }

    public void setKindID(String kindID) {
        this.kindID = kindID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
