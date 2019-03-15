package com.github.jsonzou.jmockdata.bean;

import java.math.BigDecimal;

/**
 * @Author: jsonzou
 * @Date: 2018/12/29 15:53
 * @Description:
 */
public class RegexTestDataBean {
    private String userEmail;
    private String userName;
    private String someThineDesc;
    private Integer userScore;
    private Integer userAge;
    private Double userValue;
    private BigDecimal userMoney;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSomeThineDesc() {
        return someThineDesc;
    }

    public void setSomeThineDesc(String someThineDesc) {
        this.someThineDesc = someThineDesc;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Double getUserValue() {
        return userValue;
    }

    public void setUserValue(Double userValue) {
        this.userValue = userValue;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }
}
