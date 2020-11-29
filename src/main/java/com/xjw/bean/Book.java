package com.xjw.bean;

public class Book {
    private Integer id;

    private String bookname;

    private Integer boonum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBoonum() {
        return boonum;
    }

    public void setBoonum(Integer boonum) {
        this.boonum = boonum;
    }
}