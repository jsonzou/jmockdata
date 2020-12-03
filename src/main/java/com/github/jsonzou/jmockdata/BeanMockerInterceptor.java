package com.github.jsonzou.jmockdata;

import java.lang.reflect.Field;

public interface BeanMockerInterceptor<T>{
    /**
     * 返回值类型说明：
     *   - InterceptType.UNMOCK 不模拟：排除此字段的模拟
     *   - InterceptType.MOCK 自动模拟
     *   - 其他返回值，作为Field的值通过反射注入
     * @param clazz
     * @param field
     * @param bean
     * @param dataConfig
     * @return
     * @throws IllegalAccessException
     */
    Object mock(Class<T>clazz, Field field, T bean, DataConfig dataConfig) throws IllegalAccessException;

}
