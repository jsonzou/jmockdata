
package com.github.jsonzou.jmockdata.test;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.mockdata.JmockdataWrapperMetaDataAll;
import com.github.jsonzou.jmockdata.mockdata.JmockdataWrapperMetaDataSingle;
import com.github.jsonzou.jmockdata.test.registermockdatabean.MockDataStringBuffer;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanAnyDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanConfigWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanSelfRefDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanSimpleDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoCustomStringBufferWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoSimpleListStringWrapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.test.custommocktemplate.CustomJmockDataTemplate;
import com.github.jsonzou.jmockdata.test.interceptor.OneJmockDataInterceptor;

import org.junit.Test;

/**
 * 测试
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public class JMockDataTest {
    /**
     * 测试一次模拟全部元数据类型JmockdataWrapperMetaDataAll
     * 元数据类型包括40种
     * 元数据类型不需提供Wrapper类，直接调用JMockData.mockMetaDataAll().getXxxData()即可获取元数据类型模拟数据
     */
    @Test
    public void mockTest_mockMetaDataAll() {
        JmockdataWrapperMetaDataAll metaDataMocker=JMockData.mockMetaDataAll();
        System.out.println("StringData => " + metaDataMocker.getStringData());
        System.out.println("StringArrayData => " + JSON.toJSONString(metaDataMocker.getStringArrayData(), true));
        System.out.println("IntegerData => " + metaDataMocker.getIntegerData());
        System.out.println("IntegerBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerBoxingArrayData(), true));
        System.out.println("IntegerUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerUnboxingArrayData(), true));
        System.out.println("DateArrayData => " + JSON.toJSONString(metaDataMocker.getDateArrayData(), true));
        System.out.println("ByteData => " +  metaDataMocker.getByteData());
        System.out.println("CharacterUnboxingArrayData => " +  JSON.toJSONString(metaDataMocker.getCharacterUnboxingArrayData(), true));

    }
    /**
     * 测试模拟单个元数据类型模拟JmockdataWrapperMetaDataSingle
     * 元数据类型包括40种
     * 元数据类型不需提供Wrapper类，直接调用JMockData.mockMetaDataSingle().getXxxData()即可获取元数据类型模拟数据
     */
    @Test
    public void mockTest_mockMetaDataSingle() {
        JmockdataWrapperMetaDataSingle metaDataMocker=JMockData.mockMetaDataSingle();
        System.out.println("StringData => " + metaDataMocker.getStringData());
        System.out.println("StringArrayData => " + JSON.toJSONString(metaDataMocker.getStringArrayData(), true));
        System.out.println("IntegerData => " + metaDataMocker.getIntegerData());
        System.out.println("IntegerBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerBoxingArrayData(), true));
        System.out.println("IntegerUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerUnboxingArrayData(), true));
        System.out.println("DateArrayData => " + JSON.toJSONString(metaDataMocker.getDateArrayData(), true));
        System.out.println("ByteData => " +  metaDataMocker.getByteData());
        System.out.println("CharacterUnboxingArrayData => " +  JSON.toJSONString(metaDataMocker.getCharacterUnboxingArrayData(), true));

    }

    /**
     * 测试模拟简单List<String>
     */
    @Test
    public void mockTest_SimpleStringList() {
        MockDemoSimpleListStringWrapper mockData = JMockData.mock(MockDemoSimpleListStringWrapper.class);
        mockData.getJmockDataContext().printTree(); // 打印类型树
        print(mockData.getList());
    }

    /**
     * 测试配置文件 》 改变默认算法行为
     */
    @Test
    public void mockTest_config() {
        JMockDataManager.getInstance().config("config.properties");
       // System.out.println(JSONObject.toJSONString(JMockDataManager.getInstance().config(),true));
        MockDemoBeanConfigWrapper mockData = JMockData.mock(MockDemoBeanConfigWrapper.class);
        mockData.setJmockDataContext(null);
        print(mockData);
    }

    /**
     * 测试模拟任意类型的数据
     */
    @Test
    public void mockTest_MockAnyData() {
        MockDemoBeanAnyDataWrapper mockData = JMockData.mock(MockDemoBeanAnyDataWrapper.class);
        // mockData.getJmockDataContext().printTree(); // 打印类型树
        mockData.setJmockDataContext(null);
        print(mockData);
    }


    /**
     * 测试模拟自循环引用的数据
     */
    @Test
    public void mockTest_MockSelfRefData() {
        JMockDataManager.getInstance().setMaxSelfRefLevel(4);// 设置自循环体循环层级上限
        MockDemoBeanSelfRefDataWrapper mockData = JMockData.mock(MockDemoBeanSelfRefDataWrapper.class);
        // mockData.getJmockDataContext().printTree(); // 打印类型树
        mockData.setJmockDataContext(null);
        print(mockData);
    }


    /**
     * 测试模拟类型拦截器，之拦截String类型的模拟
     */
    @Test
    public void mockTest_Interceptor() {
        JMockDataManager.getInstance().interceptors(OneJmockDataInterceptor.class); // 拦截器 =》只拦截String类型
        MockDemoBeanSimpleDataWrapper mockData = JMockData.mock(MockDemoBeanSimpleDataWrapper.class);
        print(mockData.getSimpleData());
    }

    /**
     * 测试模拟，增加自定义模拟类型，StringBuffer
     */
    @Test
    public void mockTest_RegisterMockDataBean() {
        JMockDataManager.getInstance().registerMockData(new MockDataStringBuffer(), StringBuffer.class);
        MockDemoCustomStringBufferWrapper mockData = JMockData.mock(MockDemoCustomStringBufferWrapper.class);
        print(mockData.getStringBuffer());
    }

    /**
     * 测试模拟，自定义模拟数据模板方法
     */
    @Test
    public void mockTest_CustomJmockDataTemplate() {
        JMockDataManager.getInstance().setMockTemplate(new CustomJmockDataTemplate());
        MockDemoBeanSimpleDataWrapper mockData = JMockData.mock(MockDemoBeanSimpleDataWrapper.class);
        print(mockData.getSimpleData());
    }


    /**
     * 打印json结构
     *
     * @param data
     */
    private void print(Object data) {
        System.out.println(JSON.toJSONString(data, true));
    }
}
