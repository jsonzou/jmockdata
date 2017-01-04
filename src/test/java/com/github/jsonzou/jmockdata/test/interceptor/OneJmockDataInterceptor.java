/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.interceptor;

import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.JmockDataInterceptor;
import com.github.jsonzou.jmockdata.mockdata.MockData;

import java.util.Arrays;

/**
 * Created by jsonzou on 2016/12/27.
 */
public class OneJmockDataInterceptor implements JmockDataInterceptor{
    public Boolean before(MockData mockData, JmockDataContext context) {
        System.out.println("before..."+context.getName());
        return true;
    }

    public void after(MockData mockData, JmockDataContext context) {
        System.out.println("after..."+context.getName());
    }

    public void error(MockData mockData, JmockDataContext context, Throwable e) {
        System.out.println("error..."+context.getName());
    }

    public void finallyDo(MockData mockData, JmockDataContext context) {
        System.out.println("finally..."+context.getName());
    }

    public Boolean interceptRule(MockData mockData, JmockDataContext context) {
         Class[] interceptClass=new Class[]{
                 String.class
         };
        return Arrays.asList(interceptClass).contains(context.getMockType());
    }

}
