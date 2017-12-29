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
    People people1 = JMock.mockData(People.class);
    System.out.println(people1);
    MockConfig mockConfig = new MockConfig();
    mockConfig.setStringSeed("hello", "world");
    MockDemoBeanAnyData mockDemoBeanAnyData = JMock.mockData(MockDemoBeanAnyData.class, mockConfig);
    //System.out.println(JSON.toJSONString(mockDemoBeanAnyData,true));
   // MockDemoBeanSelfRefData mockDemoBeanSelfRefData = JMock.mockData(MockDemoBeanSelfRefData.class, mockConfig);
    //System.out.println(JSON.toJSONString(mockDemoBeanSelfRefData,true));
    //BxA bxa = JMock.mockData(BxA.class, mockConfig);
    //System.out.println(JSON.toJSONString(bxa,true));
    System.out.println(  JMock.mockData(int[].class));
    Teacher teacher = JMock.mockData(Teacher.class,mockConfig);
    System.out.println(JSON.toJSONString(teacher,true));
  }

}
