package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.kanyuxia.HandleMock;

/**
 * 模拟对象门面类(version by kanyuxia)
 */
@SuppressWarnings("unchecked")
public class JMock {

  /**
   * 模拟数据接口
   *
   * @param mockType 模拟数据类型
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mockData(Class<T> mockType) throws Exception {
    return HandleMock.mockData(mockType);
  }

}
