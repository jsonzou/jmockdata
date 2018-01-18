package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.ArrayMocker;
import com.github.jsonzou.jmockdata.mocker.BeanMocker;
import com.github.jsonzou.jmockdata.mocker.GenericMocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 * 模拟对象门面类
 *
 * @author jsonzou, kanyuxia, TaoYu
 */
@SuppressWarnings("unchecked")
public class JMockData {


  /**
   * 模拟数据
   *
   * @param clazz 模拟数据类型
   * @return 模拟数据对象
   */
  public static <T> T mock(Class<T> clazz) {
    return mock(clazz, new MockConfig());
  }

  /**
   * 模拟数据
   *
   * @param clazz 模拟数据类型
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

  /**
   * 模拟数据</br> 注意typeReference必须以{}结尾
   *
   * @param typeReference 模拟数据包装类型
   * @return 模拟数据对象
   */
  public static <T> T mock(TypeReference<T> typeReference) {
    return mock(typeReference, new MockConfig());
  }

  /**
   * 模拟数据</br> 注意typeReference必须以{}结尾
   *
   * @param typeReference 模拟数据类型
   * @param mockConfig 模拟数据配置
   * @return 模拟数据对象
   */
  public static <T> T mock(TypeReference<T> typeReference, MockConfig mockConfig) {
    Type type = typeReference.getType();
    Mocker mocker;
    if (type instanceof Class) {
      Class<?> clazz = (Class<?>) type;
      mocker = MockerManager.getMocker(clazz);
      if (mocker == null) {
        mocker = new BeanMocker(clazz);
      }
    } else if (type instanceof ParameterizedType) {
      ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) type;
      mocker = new BeanMocker(parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
    } else {
      GenericArrayTypeImpl genericArrayType = (GenericArrayTypeImpl) type;
      ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) genericArrayType.getGenericComponentType();
      mocker = new ArrayMocker(parameterizedType.getRawType(), parameterizedType);
    }
    return (T) mocker.mock(mockConfig);
  }

}
