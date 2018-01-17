package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.BeanMocker;
import java.lang.reflect.Type;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

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
   * @return 模拟数据对象
   */
  public static <T> T mock(Class<T> clazz) {
    return mock(clazz, new MockConfig());
  }

  public static <T> T mock(Class<T> clazz, MockConfig mockConfig) {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockConfig);
  }

  public static <T> T mock(TypeReference<T> typeReference) {
    return mock(typeReference, new MockConfig());
  }

  public static <T> T mock(TypeReference<T> typeReference, MockConfig mockConfig) {
    Type type = typeReference.getType();
    Mocker mocker = MockerManager.getMocker((Class<?>) type);
    if (mocker == null) {
      ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) type;
      return new BeanMocker<T>(parameterizedType.getRawType(), parameterizedType.getActualTypeArguments()).mock(mockConfig);
    }
    return (T) mocker.mock(mockConfig);
  }

}
