package com.xjw.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的json数据
 */
public class Msg {

    private int code;

    private String msg;

    private Map<String,Object> data = new HashMap<String,Object>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(0);
        msg.setMsg("success");
        return msg;
    }

    public Msg add(String key,Object o){
        this.data.put(key,o);
        return this;
    }

    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(-1);
        msg.setMsg("fail");
        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
