
package com.github.jsonzou.jmockdata.utils;

import java.lang.reflect.Array;

/**
 * Created by jsonzou on 2016/12/18.
 */
public class MockUtil {
    public static <T> T[] mockArray(Class<T> componeType, int minLen, int maxLen) {
        Integer len = RandomUtil.randomIntegerNotZero(maxLen);
        Object mockDataArr = Array.newInstance(componeType, len);

        return (T[]) mockDataArr;
    }
}
