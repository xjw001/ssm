package com.xjw.bean;

public class Dept {
    private Integer deptid;

    private String deptname;

    public Dept(Integer deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }
    public Dept() {
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }
}