/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.utils;

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
