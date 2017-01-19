package com.github.jsonzou.jmockdata.test.wrapperbean;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanSimpleData;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoBeanConfigWrapper extends JmockDataWrapper {
    @JSONField(format = "YYYY-MM-dd HH:mm:ss")
    private Date date;
    private String str;
    private List<String> strs;
    private Boolean bl;
    private Integer integ;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    public Boolean getBl() {
        return bl;
    }

    public void setBl(Boolean bl) {
        this.bl = bl;
    }

    public Integer getInteg() {
        return integ;
    }

    public void setInteg(Integer integ) {
        this.integ = integ;
    }
}
