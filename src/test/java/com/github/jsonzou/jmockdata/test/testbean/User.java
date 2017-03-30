/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.testbean;

import java.util.Date;
import java.util.List;

/**
 * Created by v_zoupengfei on 2017/3/30.
 */
public class User {
    private Long id;
    private String name;
    private char status;
    private Date birthday;
    private Integer age;
    private List<Hobby> hobbys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Hobby> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }
}
