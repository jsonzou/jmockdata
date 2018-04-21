package com.github.jsonzou.jmockdata;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import com.github.jsonzou.jmockdata.bean.BasicBean;
import com.github.jsonzou.jmockdata.bean.ErrorBean;
import com.github.jsonzou.jmockdata.bean.GenericData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import com.github.jsonzou.jmockdata.bean.enums.DayEnum;
import com.github.jsonzou.jmockdata.bean.enums.ErrorEnum;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class JMockDataTest {

  @Test
  public void testBasic() {
    //基本类型模拟
    int intNum = JMockData.mock(int.class);
    assertNotNull(intNum);
    int[] intArray = JMockData.mock(int[].class);
    assertNotNull(intArray);
    Integer integer = JMockData.mock(Integer.class);
    assertNotNull(integer);
    Integer[] integerArray = JMockData.mock(Integer[].class);
    assertNotNull(integerArray);
    //常用类型模拟
    BigDecimal bigDecimal = JMockData.mock(BigDecimal.class);
    assertNotNull(bigDecimal);
    BigInteger bigInteger = JMockData.mock(BigInteger.class);
    assertNotNull(bigInteger);
    Date date = JMockData.mock(Date.class);
    assertNotNull(date);
    String str = JMockData.mock(String.class);
    assertNotNull(str);
    DayEnum dayEnum = JMockData.mock(DayEnum.class);
    assertNotNull(dayEnum);

    try {
      JMockData.mock(ErrorEnum.class);
      fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void testBasicData() {
    BasicBean basicBean = JMockData.mock(BasicBean.class);
    assertNotNull(basicBean);

    try {
      JMockData.mock(ErrorBean.class);
      fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void testCircular() {
    MockConfig mockConfig = new MockConfig().setEnabledCircle(true);
    AXB axb = JMockData.mock(AXB.class,mockConfig);
    AXB circularAxb = axb.getBXA().getAXB();
    assertSame(axb, circularAxb);
  }

  @Test
  public void testSelf() {
    MockConfig mockConfig = new MockConfig().setEnabledCircle(true);
    SelfRefData selfRefData = JMockData.mock(SelfRefData.class,mockConfig);
    assertSame(selfRefData.getParent(), selfRefData);
  }

  @Test
  //******注意TypeReference要加{}才能模拟******
  public void testTypeRefrence() {
    //模拟基础类型，不建议使用这种方式，参考基础类型章节直接模拟。
    Integer integerNum = JMockData.mock(new TypeReference<Integer>() {
    });
    assertNotNull(integerNum);
    Integer[] integerArray = JMockData.mock(new TypeReference<Integer[]>() {
    });
    assertNotNull(integerArray);
    //模拟集合
    List<Integer> integerList = JMockData.mock(new TypeReference<List<Integer>>() {
    });
    assertNotNull(integerList);
    //模拟数组集合
    List<Integer[]> integerArrayList = JMockData.mock(new TypeReference<List<Integer[]>>() {
    });
    assertNotNull(integerArrayList);
    //模拟集合数组
    List<Integer>[] integerListArray = JMockData.mock(new TypeReference<List<Integer>[]>() {
    });
    assertNotNull(integerListArray);
    //模拟集合实体
    List<BasicBean> basicBeanList = JMockData.mock(new TypeReference<List<BasicBean>>() {
    });
    assertNotNull(basicBeanList);
    //各种组合忽略。。。。map同理。下面模拟一个不知道什么类型的map
    Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>> some = JMockData
        .mock(new TypeReference<Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>>>() {
        });
    assertNotNull(some);

    try {
      JMockData.mock(new TypeReference<Integer>(){});
      fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void testGenericData() {
    GenericData<Integer, String, BasicBean> genericData = JMockData.mock(new TypeReference<GenericData<Integer, String, BasicBean>>() {
    });
    assertNotNull(genericData);
  }

  @Test
  public void testMockConfig() {
    MockConfig mockConfig = new MockConfig()
        .byteRange((byte) 0, Byte.MAX_VALUE)
        .shortRange((short) 0, Short.MAX_VALUE)
        .intRange(0, Integer.MAX_VALUE)
        .floatRange(0.0f, Float.MAX_EXPONENT)
        .doubleRange(0.0, Double.MAX_VALUE)
        .longRange(0, Long.MAX_VALUE)
        .dateRange("2010-01-01", "2020-12-30")
        .sizeRange(5, 10)
        .stringSeed("a", "b", "c")
        .charSeed((char) 97, (char) 98);
    BasicBean basicBean = JMockData.mock(BasicBean.class, mockConfig);
    assertNotNull(basicBean);

    try {
      JMockData.mock(BasicBean.class, new MockConfig().dateRange("20100101", "20301230"));
      fail();
    } catch (Exception e) {
    }
  }

}
