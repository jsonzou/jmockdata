package com.github.jsonzou.jmockdata.kanyuxia;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.kanyuxia.bean.BxA;
import com.github.jsonzou.jmockdata.kanyuxia.bean.People;
import com.github.jsonzou.jmockdata.kanyuxia.bean.Teacher;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanAnyData;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanSelfRefData;
import org.junit.Test;

public class MockDataTest {

  @Test
  @SuppressWarnings("unchecked")
  public void test() throws Exception {
//  小试牛刀
    People people1 = JMock.mockData(People.class);
    System.out.println(people1);
    System.out.println(JMock.mockData(int.class));
    System.out.println(JMock.mockData(int[].class));
   // System.out.println(JMock.mockData(List<String>));
   // System.out.println(JMock.mockData(Set<String>));
   // System.out.println(JMock.mockData(Map<String,String>));

//  改变默认配置
    MockConfig mockConfig = new MockConfig();
    mockConfig.setStringSeed("hello", "world");

//  任何类型
//  MockDemoBeanAnyData mockDemoBeanAnyData = JMock.mockData(MockDemoBeanAnyData.class, mockConfig);
//  System.out.println(mockDemoBeanAnyData);

//  自引用
//  MockDemoBeanSelfRefData mockDemoBeanSelfRefData = JMock.mockData(MockDemoBeanSelfRefData.class, mockConfig);
//  System.out.println(mockDemoBeanSelfRefData);

//   继承-有getter,setter
//   BxA bxa = JMock.mockData(BxA.class, mockConfig);
//   System.out.println(bxa);

// 继承-无getter,setter
     Teacher teacher = JMock.mockData(Teacher.class,mockConfig);
     System.out.println(teacher);
  }

}
