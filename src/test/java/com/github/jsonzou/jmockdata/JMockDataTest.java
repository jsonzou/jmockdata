package com.github.jsonzou.jmockdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.jsonzou.jmockdata.bean.*;
import com.github.jsonzou.jmockdata.bean.circular.AXB;
import com.github.jsonzou.jmockdata.bean.enums.DayEnum;
import com.github.jsonzou.jmockdata.bean.enums.ErrorEnum;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

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
      // Ignore
    }
  }

  @Test
  public void testBasicData() {
    BasicBean basicBean = JMockData.mock(BasicBean.class);
    System.out.println(JSON.toJSONString(basicBean,true));
    assertNotNull(basicBean);

    try {
      JMockData.mock(ErrorBean.class);
      fail();
    } catch (Exception e) {
      // Ignore
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
    System.out.println(JSON.toJSONString(genericData,true));
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
      // Ignore
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
  @Test
  public void testBooleanMock() {
    MockConfig mockConfig = new MockConfig()
           // .booleanSeed(true,true)
            .subConfig(Boolean.class)
           // .booleanSeed(false,false)
            .globalConfig();
    for (int i=0;i<100;i++){
      System.out.print(JMockData.mock(Boolean.class,mockConfig)+" ");
    }
  }

  /**
   * 根据正则模拟数据
   */
  @Test
  public void testXegerMock() {
    MockConfig mockConfig = new MockConfig()
            // 随机段落字符串
            .stringRegex("I'am a nice man\\.And I'll just scribble the characters, like：[a-z]{2}-[0-9]{2}-[abc123]{2}-\\w{2}-\\d{2}@\\s{1}-\\S{1}\\.?-.")
            // 邮箱
            .subConfig(RegexTestDataBean.class,"userEmail")
            .stringRegex("[a-z0-9]{5,15}\\@\\w{3,5}\\.[a-z]{2,3}")
            // 用户名规则
            .subConfig(RegexTestDataBean.class,"userName")
            .stringRegex("[a-zA-Z_]{1}[a-z0-9_]{5,15}")
            // 年龄
            .subConfig(RegexTestDataBean.class,"userAge")
            .numberRegex("[1-9]{1}\\d?")
            // 用户现金
            .subConfig(RegexTestDataBean.class,"userMoney")
            .numberRegex("[1-9]{2}\\.\\d?")
            // 用户的得分
            .subConfig(RegexTestDataBean.class,"userScore")
            .numberRegex("[1-9]{1}\\d{1}")
            // 用户身价
            .subConfig(RegexTestDataBean.class,"userValue")
            .numberRegex("[1-9]{1}\\d{3,8}")
            .globalConfig();

    System.out.println(JSONObject.toJSONString(JMockData.mock(RegexTestDataBean.class,mockConfig),true));

  }

  /**
   * 测试小数位数
   */
  @Test
  public void testDecimalScaleMock() {
    MockConfig mockConfig = new MockConfig()
            .doubleRange(-1.1d,9999.99999d)
            .floatRange(-1.11111f,9999.99999f)
            .decimalScale(3) // 设置小数位数为3，默认是2
            .globalConfig();
    for (int i=0;i<100;i++){
      System.out.print(JMockData.mock(BigDecimal.class,mockConfig)+" ");
      System.out.print(JMockData.mock(Double.class,mockConfig)+" ");
      System.out.println(JMockData.mock(Float.class,mockConfig)+" ");
    }
  }

  /**
   * 测试无域对象
   */
  @Test
  public void testNoneFieldBeanMock() {
    NoneFieldObject noneFieldObject = JMockData.mock(NoneFieldObject.class);
    System.out.println(noneFieldObject);
  }

  /**
   * 测试无域对象
   */
  @Test
  public void testInnerBeanMock() {
    InnerBeanObject innerBeanObject = JMockData.mock(InnerBeanObject.class);
    InnerBeanObject.InnerBean innerBean = JMockData.mock(InnerBeanObject.InnerBean.class);
    System.out.println(innerBeanObject);
    System.out.println(innerBean);
  }
  /**
   * 测试Lombok对象
   */
  @Test
  public void testLombokBeanMock() throws IllegalAccessException {
    LombokBean lombokBean = JMockData.mock(LombokBean.class);
    printBeanFieldInfo(LombokBean.class,lombokBean);
  }
  /**
   * 测试Timestamp,LocalDateTime,LocalDate,LocalTime的模拟
   */
  @Test
  public void testLocalDateTimeMock() throws IllegalAccessException {
    LocalDateTimeBean localDateTimeBean = JMockData.mock(LocalDateTimeBean.class);
    printBeanFieldInfo(LocalDateTimeBean.class,localDateTimeBean);
  }
  /**
   * 测试Timestamp,LocalDateTime,LocalDate,LocalTime的模拟
   */
  @Test
  public void noneGetterSetterAndPlainAndChainBeanMock() throws IllegalAccessException {
    NoneGetterSetterAndFluentAndChainBean noneGetterSetterAndFluentAndChainBean = JMockData.mock(NoneGetterSetterAndFluentAndChainBean.class);
    printBeanFieldInfo(NoneGetterSetterAndFluentAndChainBean.class,noneGetterSetterAndFluentAndChainBean);
  }

  /**
   * 测试BeanMockerInterceptor
   */
  @Test
  public void noneBeanMockerInterceptor() throws IllegalAccessException {
      MockConfig mockConfig = new MockConfig();
//      mockConfig.registerBeanMockerInterceptor(new BeanMockerInterceptor() {
      mockConfig.registerBeanMockerInterceptor(SimpleBean.class,new BeanMockerInterceptor<SimpleBean>() {
          @Override
          public Object mock(Class<SimpleBean> clazz, Field field, SimpleBean bean, DataConfig dataConfig) {
              // 场景1
              if(field.getName().startsWith("string")){
                bean.setStringValue("abc");
                return InterceptType.UNMOCK;
              }
              // 场景2
              if(field.getName().startsWith("integer")){
                return 888888999;
              }
               // 场景3
              if(field.getName().startsWith("byte")){
                return InterceptType.UNMOCK;
              }
              // 场景4
              return InterceptType.MOCK;
          }
      });
    SimpleBean simpleBean = JMockData.mock(SimpleBean.class, mockConfig);
      printBeanFieldInfo(SimpleBean.class, simpleBean);
  }

    /**
     * 测试字段修饰符
     * @throws IllegalAccessException
     */
  @Test
  public void noneModifierBean_1() throws IllegalAccessException {
      MockConfig mockConfig = new MockConfig();
      mockConfig.setEnabledStatic(true);
      mockConfig.setEnabledPrivate(false);
      mockConfig.setEnabledPublic(false);
      mockConfig.setEnabledProtected(false);
      ModifierBean basicBean = JMockData.mock(ModifierBean.class, mockConfig);
      printBeanFieldInfo(ModifierBean.class,basicBean);
  }

  /**
   * 打印bean 属性信息
   * @param clazz
   * @param result
   * @throws IllegalAccessException
   */
  private void printBeanFieldInfo(Class<?>clazz,Object result) throws IllegalAccessException {
    Field[] fields = clazz.getDeclaredFields();
    for(Field field:fields){
      field.setAccessible(true);
      System.out.println(field.getName()+" <---> "+JSON.toJSONString(field.get(result)));
    }
  }


}
