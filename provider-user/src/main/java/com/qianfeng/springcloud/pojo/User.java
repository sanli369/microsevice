package com.qianfeng.springcloud.pojo;

import java.util.Date;
public class User {
    private  Long id;
    private Date date;
    private  String  remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User(Long id) {
        this.id = id;
        this.date=new Date();
    }

    public User() {
    }
}
