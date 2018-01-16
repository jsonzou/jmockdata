package com.github.jsonzou.jmockdata;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.bean.AnyData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
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
  }


}
