
package com.github.jsonzou.jmockdata.test;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.test.registermockdatabean.MockDataStringBuffer;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanAnyDataWrapper;
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
     * 测试模拟简单List<String>
     */
    @Test
    public void mockTest_SimpleStringList() {
        MockDemoSimpleListStringWrapper mockData = JMockData.mock(MockDemoSimpleListStringWrapper.class);
        mockData.getJmockDataContext().printTree(); // 打印类型树
        print(mockData.getList());
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
