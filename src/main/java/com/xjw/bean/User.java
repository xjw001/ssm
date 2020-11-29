package com.xjw.bean;

import java.util.Date;

public class User {
    private Integer uid;

    private String uname;

    private String addr;

    private Date createtime;

    public User(Integer uid, String uname, String addr, Date createtime) {
        this.uid = uid;
        this.uname = uname;
        this.addr = addr;
        this.createtime = createtime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}