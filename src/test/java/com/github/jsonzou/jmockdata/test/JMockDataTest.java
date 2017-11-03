/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.github.jsonzou.jmockdata.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockdataWrapperMetaDataAll;
import com.github.jsonzou.jmockdata.mockdata.JmockdataWrapperMetaDataSingle;
import com.github.jsonzou.jmockdata.test.custommocktemplate.CustomJmockDataTemplate;
import com.github.jsonzou.jmockdata.test.interceptor.OneJmockDataInterceptor;
import com.github.jsonzou.jmockdata.test.registermockdatabean.MockDataStringBuffer;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanAnyData;
import com.github.jsonzou.jmockdata.test.testbean.User;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanAnyDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanConfigWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanSelfRefDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoBeanSimpleDataWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoCustomStringBufferWrapper;
import com.github.jsonzou.jmockdata.test.wrapperbean.MockDemoSimpleListStringWrapper;
import com.github.jsonzou.jmockdata.utils.TypeReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
   * 测试模拟简单POJO - User
   */
  @Test
  public void mockTest_mock_mockPOJO() {
    User user = JMockData.mock(User.class);
    print(user);
  }

  /**
   * 测试模拟any
   */
  @Test
  public void mockTest_mock_mockAny() {
    MockDemoBeanAnyData anyData = JMockData.mock(MockDemoBeanAnyData.class);
    print(anyData);
  }

  /**
   * 测试模拟元数据类型
   */
  @Test
  public void mockTest_mock_mockMeta() {

    System.out.println("BigIntegerData => " + JMockData.mock(BigInteger.class));
    System.out.println("BigIntegerArrayData => " + JSON.toJSONString(JMockData.mock(BigInteger[].class), true));

    System.out.println("BigDecimalData => " + JMockData.mock(BigDecimal.class));
    System.out.println("BigDecimalArrayData => " + JSON.toJSONString(JMockData.mock(BigDecimal[].class), true));

    System.out.println("StringData => " + JMockData.mock(String.class));
    System.out.println("StringArrayData => " + JSON.toJSONString(JMockData.mock(String[].class), true));

    System.out.println("DateData => " + JMockData.mock(Date.class));
    System.out.println("DateArrayData => " + JSON.toJSONString(JMockData.mock(Date[].class), true));

    System.out.println("IntegerData => " + JMockData.mock(Integer.class));
    System.out.println("IntegerBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Integer[].class), true));
    System.out.println("IntegerUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(int[].class), true));

    System.out.println("ByteData => " + JMockData.mock(Byte.class));
    System.out.println("ByteBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Byte[].class), true));
    System.out.println("ByteUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(byte[].class), true));

    System.out.println("CharacterData => " + JMockData.mock(Character.class));
    System.out.println("CharacterBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Character[].class), true));
    System.out.println("CharacterUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(char[].class), true));

    System.out.println("BooleanData => " + JMockData.mock(Boolean.class));
    System.out.println("BooleanBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Boolean[].class), true));
    System.out.println("BooleanUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(boolean[].class), true));

    System.out.println("LongData => " + JMockData.mock(Long.class));
    System.out.println("LongBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Long[].class), true));
    System.out.println("LongUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(long[].class), true));

    System.out.println("FloatData => " + JMockData.mock(Float.class));
    System.out.println("FloatBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Float[].class), true));
    System.out.println("FloatUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(float[].class), true));

    System.out.println("ShortData => " + JMockData.mock(Short.class));
    System.out.println("ShortBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Short[].class), true));
    System.out.println("ShortUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(short[].class), true));

    System.out.println("DoubleData => " + JMockData.mock(Double.class));
    System.out.println("DoubleBoxingArrayData => " + JSON.toJSONString(JMockData.mock(Double[].class), true));
    System.out.println("DoubleUnboxingArrayData => " + JSON.toJSONString(JMockData.mock(double[].class), true));
  }

  /**
   * 测试模拟 List,Set,Map三种常见数据结构
   */
  @Test
  public void mockTest_mock() {
    List<String> listStr = JMockData.mock(new TypeReference<List<String>>(){});
    List<User[]> listUser = JMockData.mock(new TypeReference<List<User[]>>() {

    });
    Set<String> setStr = JMockData.mock(new TypeReference<Set<String>>() {
    });
    Map<String, String> mapStr = JMockData.mock(new TypeReference<Map<String, String>>() {
    });
    Map<String, User> mapUser = JMockData.mock(new TypeReference<Map<String, User>>() {
    });

    print(listStr);
    print(listUser);
    print(setStr);
    print(mapStr);
    print(mapUser);

  }


  /**
   * 测试一次模拟全部元数据类型JmockdataWrapperMetaDataAll 元数据类型包括40种 元数据类型不需提供Wrapper类，直接调用JMockData.mockMetaDataAll().getXxxData()即可获取元数据类型模拟数据
   */
  @Test
  public void mockTest_mockMetaDataAll() {
    JmockdataWrapperMetaDataAll metaDataMocker = JMockData.mockMetaDataAll();
    System.out.println("BigIntegerData => " + metaDataMocker.getBigIntegerData());
    System.out.println("BigIntegerArrayData => " + JSON.toJSONString(metaDataMocker.getBigIntegerArrayData(), true));

    System.out.println("BigDecimalData => " + metaDataMocker.getBigDecimalData());
    System.out.println("BigDecimalArrayData => " + JSON.toJSONString(metaDataMocker.getBigDecimalArrayData(), true));

    System.out.println("StringData => " + metaDataMocker.getStringData());
    System.out.println("StringArrayData => " + JSON.toJSONString(metaDataMocker.getStringArrayData(), true));

    System.out.println("DateData => " + metaDataMocker.getDateData());
    System.out.println("DateArrayData => " + JSON.toJSONString(metaDataMocker.getDateArrayData(), true));

    System.out.println("IntegerData => " + metaDataMocker.getIntegerData());
    System.out.println("IntegerBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerBoxingArrayData(), true));
    System.out.println("IntegerUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerUnboxingArrayData(), true));

    System.out.println("ByteData => " + metaDataMocker.getByteData());
    System.out.println("ByteBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getByteBoxingArrayData(), true));
    System.out.println("ByteUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getByteUnboxingArrayData(), true));

    System.out.println("CharacterData => " + metaDataMocker.getCharacterData());
    System.out.println("CharacterBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getCharacterBoxingArrayData(), true));
    System.out.println("CharacterUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getCharacterUnboxingArrayData(), true));

    System.out.println("BooleanData => " + metaDataMocker.getBooleanData());
    System.out.println("BooleanBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getBooleanBoxingArrayData(), true));
    System.out.println("BooleanUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getBooleanUnboxingArrayData(), true));

    System.out.println("LongData => " + metaDataMocker.getLongData());
    System.out.println("LongBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getLongBoxingArrayData(), true));
    System.out.println("LongUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getLongUnboxingArrayData(), true));

    System.out.println("FloatData => " + metaDataMocker.getFloatData());
    System.out.println("FloatBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getFloatBoxingArrayData(), true));
    System.out.println("FloatUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getFloatUnboxingArrayData(), true));

    System.out.println("ShortData => " + metaDataMocker.getShortData());
    System.out.println("ShortBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getShortBoxingArrayData(), true));
    System.out.println("ShortUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getShortUnboxingArrayData(), true));

    System.out.println("DoubleData => " + metaDataMocker.getDoubleData());
    System.out.println("DoubleBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getDoubleBoxingArrayData(), true));
    System.out.println("DoubleUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getDoubleUnboxingArrayData(), true));

  }

  /**
   * 测试模拟单个元数据类型模拟JmockdataWrapperMetaDataSingle 元数据类型包括40种 元数据类型不需提供Wrapper类，直接调用JMockData.mockMetaDataSingle().getXxxData()即可获取元数据类型模拟数据
   */
  @Test
  public void mockTest_mockMetaDataSingle() {
    JmockdataWrapperMetaDataSingle metaDataMocker = JMockData.mockMetaDataSingle();
    System.out.println("BigIntegerData => " + metaDataMocker.getBigIntegerData());
    System.out.println("BigIntegerArrayData => " + JSON.toJSONString(metaDataMocker.getBigIntegerArrayData(), true));

    System.out.println("BigDecimalData => " + metaDataMocker.getBigDecimalData());
    System.out.println("BigDecimalArrayData => " + JSON.toJSONString(metaDataMocker.getBigDecimalArrayData(), true));

    System.out.println("StringData => " + metaDataMocker.getStringData());
    System.out.println("StringArrayData => " + JSON.toJSONString(metaDataMocker.getStringArrayData(), true));

    System.out.println("DateData => " + metaDataMocker.getDateData());
    System.out.println("DateArrayData => " + JSON.toJSONString(metaDataMocker.getDateArrayData(), true));

    System.out.println("IntegerData => " + metaDataMocker.getIntegerData());
    System.out.println("IntegerBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerBoxingArrayData(), true));
    System.out.println("IntegerUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getIntegerUnboxingArrayData(), true));

    System.out.println("ByteData => " + metaDataMocker.getByteData());
    System.out.println("ByteBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getByteBoxingArrayData(), true));
    System.out.println("ByteUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getByteUnboxingArrayData(), true));

    System.out.println("CharacterData => " + metaDataMocker.getCharacterData());
    System.out.println("CharacterBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getCharacterBoxingArrayData(), true));
    System.out.println("CharacterUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getCharacterUnboxingArrayData(), true));

    System.out.println("BooleanData => " + metaDataMocker.getBooleanData());
    System.out.println("BooleanBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getBooleanBoxingArrayData(), true));
    System.out.println("BooleanUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getBooleanUnboxingArrayData(), true));

    System.out.println("LongData => " + metaDataMocker.getLongData());
    System.out.println("LongBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getLongBoxingArrayData(), true));
    System.out.println("LongUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getLongUnboxingArrayData(), true));

    System.out.println("FloatData => " + metaDataMocker.getFloatData());
    System.out.println("FloatBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getFloatBoxingArrayData(), true));
    System.out.println("FloatUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getFloatUnboxingArrayData(), true));

    System.out.println("ShortData => " + metaDataMocker.getShortData());
    System.out.println("ShortBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getShortBoxingArrayData(), true));
    System.out.println("ShortUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getShortUnboxingArrayData(), true));

    System.out.println("DoubleData => " + metaDataMocker.getDoubleData());
    System.out.println("DoubleBoxingArrayData => " + JSON.toJSONString(metaDataMocker.getDoubleBoxingArrayData(), true));
    System.out.println("DoubleUnboxingArrayData => " + JSON.toJSONString(metaDataMocker.getDoubleUnboxingArrayData(), true));


  }

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
   * 测试配置文件 》 改变默认算法行为
   */
  @Test
  public void mockTest_config() {
    JMockDataManager.getInstance().config("config.properties");
    // System.out.println(JSONObject.toJSONString(JMockDataManager.getInstance().config(),true));
    MockDemoBeanConfigWrapper mockData = JMockData.mock(MockDemoBeanConfigWrapper.class);
    mockData.setJmockDataContext(null);
    print(mockData);
  }

  /**
   * 测试配置文件 》 改变默认算法行为
   */
  @Test
  public void mockTest_config_rangeMock() {
    JMockDataManager.getInstance().config("config.properties");
    System.out.println(JMockData.mockMetaDataSingle().getDoubleData());
    System.out.println(JMockData.mockMetaDataSingle().getFloatData());
    System.out.println(JMockData.mockMetaDataSingle().getIntegerData());
    System.out.println(JMockData.mockMetaDataSingle().getLongData());
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
   */
  private void print(Object data) {

    System.out.println(JSON.toJSONStringWithDateFormat(data, "YYYY-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    //   System.out.println(JSON.toJSONString(data, true));
  }
}
