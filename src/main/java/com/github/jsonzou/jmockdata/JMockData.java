package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.BeanMocker;

/**
 * 模拟对象门面类
 *
 * @author jsonzou, kanyuxia, TaoYu
 */
@SuppressWarnings("unchecked")
public class JMockData {

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mock(Class<T> clazz) {
    return mock(clazz, new MockConfig());
  }

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @param mockConfig 模拟数据配置
   * @return 模拟数据对象
   */
  public static <T> T mock(Class<T> clazz, MockConfig mockConfig) {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockConfig);
  }

}
