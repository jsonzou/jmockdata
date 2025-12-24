package com.github.jsonzou.jmockdata.bean;

import java.sql.Date;
import java.util.List;

/**
 * Test bean for java.sql.Date support
 */
public class SqlDateBean {
    private Date sqlDate;
    private Date[] sqlDates;
    private List<Date> sqlDateList;

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public Date[] getSqlDates() {
        return sqlDates;
    }

    public void setSqlDates(Date[] sqlDates) {
        this.sqlDates = sqlDates;
    }

    public List<Date> getSqlDateList() {
        return sqlDateList;
    }

    public void setSqlDateList(List<Date> sqlDateList) {
        this.sqlDateList = sqlDateList;
    }
}
