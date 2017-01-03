/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata;

import org.jsonzou.jmockdata.mockdata.mocks.*;
import org.jsonzou.jmockdata.utils.ReflectionUtil;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>模拟数据管理类
 * - 注册模拟类型bean
 * - 获取模拟类型bean
 * - 注册模拟类型拦截器
 * - 获取模拟类型拦截器
 * - 判断是否已注册某模拟类型
 * - 注册模拟数据模板方法
 * - 获取模拟数据模板方法</p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public class JMockDataManager {
    private static final String $_DEFAULT = "$_DEFAULT";

    private Map<String, MockData> mockDataMappings = new ConcurrentHashMap<String, MockData>();
    private List<JmockDataInterceptor> interceptors = new ArrayList<JmockDataInterceptor>();
    private JmockDataTemplate mockTemplate = new JmockDataTemplateDefault();
    private Integer maxSelfRefLevel = 3;

    private JMockDataManager() {
        registerMockData(new MockDataByte(), byte.class, Byte.class);
        registerMockData(new MockDataByteUnboxingArray(), byte[].class);
        registerMockData(new MockDataByteBoxingArray(), Byte[].class);

        registerMockData(new MockDataShort(), short.class, Short.class);
        registerMockData(new MockDataShortUnboxingArray(), short[].class);
        registerMockData(new MockDataShortBoxingArray(), Short[].class);

        registerMockData(new MockDataInteger(), int.class, Integer.class);
        registerMockData(new MockDataIntegerUnboxingArray(), int[].class);
        registerMockData(new MockDataIntegerBoxingArray(), Integer[].class);

        registerMockData(new MockDataLong(), long.class, Long.class);
        registerMockData(new MockDataLongUnboxingArray(), long[].class);
        registerMockData(new MockDataLongBoxingArray(), Long[].class);


        registerMockData(new MockDataFloat(), float.class, Float.class);
        registerMockData(new MockDataFloatUnboxingArray(), float[].class);
        registerMockData(new MockDataFloatBoxingArray(), Float[].class);


        registerMockData(new MockDataDouble(), double.class, Double.class);
        registerMockData(new MockDataDoubleUnboxingArray(), double[].class);
        registerMockData(new MockDataDoubleBoxingArray(), Double[].class);


        registerMockData(new MockDataBoolean(), boolean.class, Boolean.class);
        registerMockData(new MockDataBooleanUnboxingArray(), boolean[].class);
        registerMockData(new MockDataBooleanBoxingArray(), Boolean[].class);


        registerMockData(new MockDataCharacter(), char.class, Character.class);
        registerMockData(new MockDataCharacterUnboxingArray(), char[].class);
        registerMockData(new MockDataCharacterBoxingArray(), Character[].class);

        registerMockData(new MockDataString(), String.class);
        registerMockData(new MockDataStringArray(), String[].class);

        registerMockData(new MockDataBigDecimal(), BigDecimal.class);
        registerMockData(new MockDataBigDecimalArray(), BigDecimal[].class);

        registerMockData(new MockDataBigInteger(), BigInteger.class);
        registerMockData(new MockDataBigIntegerArray(), BigInteger[].class);

        registerMockData(new MockDataDate(), Date.class);
        registerMockData(new MockDataDateArray(), Date[].class);

        mockDataMappings.put($_DEFAULT, new MockDataDefaultNull());

    }

    private static class JMockDataFactoryHolder {
        public static JMockDataManager manager = new JMockDataManager();
    }

    /**
     * 获取单例实例
     *
     * @return
     */
    public static JMockDataManager getInstance() {
        return JMockDataFactoryHolder.manager;
    }

    /**
     * 获取模拟数据类型bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> MockData<T> getMockDataBean(Class<T> clazz) {
        MockData mockData = mockDataMappings.get(ReflectionUtil.getClassName(clazz));
        if (mockData == null) {
            return new MockDataBean<T>(clazz);
        }
        return mockData;
    }

    /**
     * 获取模拟数据类型bean
     *
     * @param clazz
     * @param genericType
     * @param <T>
     * @return
     */
    public <T> MockData<T> getMockDataBean(Class<T> clazz, Type genericType) {
        MockData mockData = mockDataMappings.get(ReflectionUtil.getClassName(clazz));
        if (mockData == null) {
            return new MockDataBean<T>(clazz, genericType);
        }
        return mockData;
    }

    /**
     * 获取默认模拟数据类型bean
     *
     * @param <T>
     * @return
     */
    public <T> MockData<T> getDefaultMockDataBean(Class<T> clazz) {
        return new MockDataDefaultNull<T>();
    }

    /**
     * 是否已有某类型的模拟方法
     *
     * @param clazz
     * @return
     */
    public Boolean isHas(Class clazz) {
        return mockDataMappings.containsKey(clazz.getName());
    }

    /**
     * 注册模拟类型bean
     *
     * @param mockData
     * @param registerClazz
     */
    public void registerMockData(MockData mockData, Class... registerClazz) {
        if (registerClazz != null && registerClazz.length > 0) {
            for (Class cla : registerClazz)
                mockDataMappings.put(ReflectionUtil.getClassName(cla), proxy(mockData));
        }

    }

    /**
     * 获取拦截器
     *
     * @return
     */
    public List<JmockDataInterceptor> interceptors() {
        return interceptors;
    }

    /**
     * 注册拦截器
     *
     * @param interceptors
     * @param <T>
     */
    public <T extends JmockDataInterceptor> void interceptors(Class<T>... interceptors) {
        if (interceptors != null && interceptors.length > 0) {
            for (Class<T> inter : interceptors) {
                try {
                    this.interceptors().add((JmockDataInterceptor) ReflectionUtil.newInstance(inter));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取模拟数据模板方法
     *
     * @return
     */
    public JmockDataTemplate getMockTemplate() {
        return mockTemplate;
    }

    /**
     * 设置模拟数据模板方法
     *
     * @param mockTemplate
     */
    public void setMockTemplate(JmockDataTemplate mockTemplate) {
        this.mockTemplate = mockTemplate;
    }

    public List<JmockDataInterceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<JmockDataInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public Map<String, MockData> getMockDataMappings() {
        return mockDataMappings;
    }

    public void setMockDataMappings(Map<String, MockData> mockDataMappings) {
        this.mockDataMappings = mockDataMappings;
    }

    public Integer getMaxSelfRefLevel() {
        return maxSelfRefLevel;
    }

    public void setMaxSelfRefLevel(Integer maxSelfRefLevel) {
        this.maxSelfRefLevel = maxSelfRefLevel;
    }

    private MockData proxy(MockData mockData) {
        return new MockDataProxy(mockData);
    }
}
