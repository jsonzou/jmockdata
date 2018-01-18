package com.github.jsonzou.jmockdata;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import com.github.jsonzou.jmockdata.bean.BasicData;
import com.github.jsonzou.jmockdata.bean.GenericData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    assertNotNull(integerNum);
    Integer[] integerArray = JMockData.mock(new TypeReference<Integer[]>() {
    });
    assertNotNull(integerArray);
    List<Integer[]> integerArrayList = JMockData.mock(new TypeReference<List<Integer[]>>() {
    });
    assertNotNull(integerArrayList);
    List<Integer>[] integerListArray = JMockData.mock(new TypeReference<List<Integer>[]>() {
    });
    assertNotNull(integerListArray);
    Map<String, Integer> map = JMockData.mock(new TypeReference<Map<String, Integer>>() {
    });
    assertNotNull(map);
    Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>> some = JMockData
        .mock(new TypeReference<Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>>>() {
        });
    assertNotNull(some);
  }

  @Test
  public void testGenericData() {
    GenericData<String, BasicData> genericData = JMockData.mock(new TypeReference<GenericData<String, BasicData>>() {
    });
    assertNotNull(genericData);
  }

}
