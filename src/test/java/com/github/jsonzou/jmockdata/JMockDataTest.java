package com.github.jsonzou.jmockdata;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.bean.AnyData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class JMockDataTest {

  @Test
  public void testAll() {
    AnyData anyData = JMockData.mock(AnyData.class);
    System.out.println(JSON.toJSONString(anyData));
  }

  @Test
  public void testCircular() {
    AXB axb = JMockData.mock(AXB.class);
    AXB circularAxb = axb.getBXA().getAXB();
    Assert.assertSame(axb, circularAxb);
    System.out.println(JSON.toJSONString(axb));
  }

  @Test
  public void testSelf() {
    SelfRefData selfRefData = JMockData.mock(SelfRefData.class);
    System.out.println(selfRefData);
  }

  @Test
  public void testModifyConfig() {
    MockerManager.local().config().stringSeed("hello", "world");
    AnyData anyData = JMockData.mock(AnyData.class);
    System.out.println(JSON.toJSONString(anyData));
  }

  @Test
  public void testMockInterface() {
    List<String> stringList = JMockData.mockList(String.class);
    Set<String> stringSet = JMockData.mockSet(String.class);
    Map<String, String> map = JMockData.mockMap(String.class, String.class);
    System.out.println(JSON.toJSONString(stringList));
    System.out.println(JSON.toJSONString(stringSet));
    System.out.println(JSON.toJSONString(map));
  }

}
