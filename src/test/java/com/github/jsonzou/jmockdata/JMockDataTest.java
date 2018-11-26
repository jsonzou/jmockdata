package com.github.jsonzou.jmockdata;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.bean.BasicBean;
import com.github.jsonzou.jmockdata.bean.ErrorBean;
import com.github.jsonzou.jmockdata.bean.GenericData;
import com.github.jsonzou.jmockdata.bean.SelfRefData;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import com.github.jsonzou.jmockdata.bean.enums.DayEnum;
import com.github.jsonzou.jmockdata.bean.enums.ErrorEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
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

  /**
   * 自定义配置测试
   * 排除字段测试
   */
  @Test
  public void testCustomDataConfigAndExclude(){
    MockConfig mockConfig = new MockConfig()
            // 全局配置
            .globalConfig()
            .sizeRange(1,1)
            .charSeed((char) 97, (char) 98)
            .byteRange((byte) 0, Byte.MAX_VALUE)
            .shortRange((short) 0, Short.MAX_VALUE)

            // 某些字段（名等于integerNum的字段、包含float的字段、double开头的字段）配置
            .subConfig("integerNum","*float*","double*")
            .intRange(10, 11)
            .floatRange(1.22f, 1.50f)
            .doubleRange(1.50,1.99)

            // 某个类的某些字段（long开头的字段、date结尾的字段、包含string的字段）配置。
            .subConfig(BasicBean.class,"long*","*date","*string*")
            .longRange(12, 13)
            .dateRange("2018-11-20", "2018-11-30")
            .stringSeed("SAVED", "REJECT", "APPROVED")
            .sizeRange(1,1)

            // 全局配置
            .globalConfig()
            // 排除所有包含list/set/map字符的字段。表达式不区分大小写。
            .excludes("*List*","*Set*","*Map*")
            // 排除所有Array开头/Boxing结尾的字段。表达式不区分大小写。
            .excludes(BasicBean.class,"*Array","Boxing*");
    BasicBean basicBean = JMockData.mock(BasicBean.class, mockConfig);
    assertNotNull(basicBean);
    List<BasicBean> basicBeans = JMockData.mock(new TypeReference<List<BasicBean>>(){}, mockConfig);
    assertNotNull(basicBeans);
    System.out.println(JSON.toJSONString(basicBean,true));
    System.out.println("==============================");
    System.out.println(JSON.toJSONString(basicBeans,true));
  }


}
