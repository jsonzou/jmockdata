package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.kanyuxia.mocker.BeanMocker;

/**
 * 模拟对象门面类(version by kanyuxia)
 */
@SuppressWarnings("unchecked")
public class JMock {

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mockData(final Class<?> clazz) throws Exception {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mockData(new MockConfig());
  }

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @param mockConfig 模拟数据配置
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mockData(final Class<T> clazz, final MockConfig mockConfig) throws Exception {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mockData(mockConfig);
  }

}
