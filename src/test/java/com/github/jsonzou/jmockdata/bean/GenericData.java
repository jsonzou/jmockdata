package com.github.jsonzou.jmockdata.bean;

/**
 * Created by jsonzou on 2018/1/17.
 */
public class GenericData<T> {
   private String message;
   private T Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
