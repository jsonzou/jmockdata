package com.github.jsonzou.jmockdata.bean;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author: jsonzou<keko-boy@163.com>
 * @date: 2020/1/10 10:22
 * @version:V1.0
 * @description:
 */
public class LocalDateTimeBean {
    private Timestamp timestamp;
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private LocalTime localTime;
    private Timestamp[] timestamps;
    private LocalDateTime[] localDateTimes;
    private LocalDate[] localDates;
    private LocalTime[] localTimes;
    private List<Timestamp> timestamps2;
    private List<LocalDateTime> localDateTimes2;
    private List<LocalDate> localDates2;
    private List<LocalTime> localTimes2;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp[] getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Timestamp[] timestamps) {
        this.timestamps = timestamps;
    }

    public List<Timestamp> getTimestamps2() {
        return timestamps2;
    }

    public void setTimestamps2(List<Timestamp> timestamps2) {
        this.timestamps2 = timestamps2;
    }

    public LocalDateTime[] getLocalDateTimes() {
        return localDateTimes;
    }

    public void setLocalDateTimes(LocalDateTime[] localDateTimes) {
        this.localDateTimes = localDateTimes;
    }

    public LocalDate[] getLocalDates() {
        return localDates;
    }

    public void setLocalDates(LocalDate[] localDates) {
        this.localDates = localDates;
    }

    public LocalTime[] getLocalTimes() {
        return localTimes;
    }

    public void setLocalTimes(LocalTime[] localTimes) {
        this.localTimes = localTimes;
    }

    public List<LocalDateTime> getLocalDateTimes2() {
        return localDateTimes2;
    }

    public void setLocalDateTimes2(List<LocalDateTime> localDateTimes2) {
        this.localDateTimes2 = localDateTimes2;
    }

    public List<LocalDate> getLocalDates2() {
        return localDates2;
    }

    public void setLocalDates2(List<LocalDate> localDates2) {
        this.localDates2 = localDates2;
    }

    public List<LocalTime> getLocalTimes2() {
        return localTimes2;
    }

    public void setLocalTimes2(List<LocalTime> localTimes2) {
        this.localTimes2 = localTimes2;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
