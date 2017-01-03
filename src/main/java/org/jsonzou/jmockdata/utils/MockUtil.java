/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.utils;

import org.jsonzou.jmockdata.mockdata.JmockDataContext;

import java.lang.reflect.Array;

/**
 * Created by jsonzou on 2016/12/18.
 */
public class MockUtil {
    public static <T> T[] mockArray(Class<T> componeType){
        int len= RandomUtil.randomIntNotZero(10);
        Object mockDataArr=Array.newInstance(componeType,len);
        return (T[])mockDataArr;
    }
}
