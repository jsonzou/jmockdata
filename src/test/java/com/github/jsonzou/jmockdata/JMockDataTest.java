package com.github.jsonzou.jmockdata;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import com.github.jsonzou.jmockdata.bean.BasicData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import java.util.List;
import org.junit.Test;

public class JMockDataTest {

  @Test
  public void testBasicData() {
    BasicData basicData = JMockData.mock(BasicData.class);
    assertNotNull(basicData);
  }

  @Test
  public void testCircular() {
    AXB axb = JMockData.mock(AXB.class);
    AXB circularAxb = axb.getBXA().getAXB();
    assertSame(axb, circularAxb);
  }

  @Test
  public void testSelf() {
    SelfRefData selfRefData = JMockData.mock(SelfRefData.class);
    assertSame(selfRefData.getParent(), selfRefData);
  }

  @Test
  public void testTypeRefrence() {
    Integer integerNum = JMockData.mock(new TypeReference<Integer>() {
    });
    List<String> stringList = JMockData.mock(new TypeReference<List<String>>() {
    });
  }


}
