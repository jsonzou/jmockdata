package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.kanyuxia.mocker.BeanMocker;
import java.lang.reflect.Type;

/**
 * 处理模拟数据
 */
@SuppressWarnings("unchecked")
public class HandleMock {

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mockData(Class<?> clazz) throws Exception {
    Mocker mocker = MockerManage.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker<>(clazz);
    }
    return (T) mocker.mockData();
  }

  /**
   * 模拟数据接口
   *
   * @param clazz Class对象接口
   * @param genericTypes 泛型对象数组
   * @return 模拟数据对象
   * @throws Exception 模拟数据异常
   */
  public static <T> T mockData(Class<T> clazz, Type... genericTypes) throws Exception {
    Mocker<T> mock = MockerManage.getMocker(clazz);
    if (mock == null) {
      mock = new BeanMocker<>(clazz, genericTypes);
    }
    return mock.mockData();
  }
}
