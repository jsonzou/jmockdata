package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 数组模拟器
 */
@SuppressWarnings("unchecked")
// TODO 2018/1/19 多维数组、一维数组这里的判断有点问题
public class ArrayMocker implements Mocker<Object> {

  private final Type type;

  ArrayMocker(Type type) {
    this.type = type;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    if (type instanceof Class) {
      return multipartArray(mockConfig);
    }
    return singleArray(mockConfig);

  }

  /**
   * 创建一维数组
   */
  private Object singleArray(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Type componentType = ((GenericArrayType) type).getGenericComponentType();
    Class componentClass;
    if (componentType instanceof ParameterizedType) {
      componentClass = (Class) ((ParameterizedType) componentType).getRawType();
    } else {
      componentClass = (Class) componentType;
    }
    Object result = Array.newInstance(componentClass, size);
    for (int index = 0; index < size; index++) {
      Object value = new BaseMocker(componentType).mock(mockConfig);
      Array.set(result, index, value);
    }
    return result;
  }

  /**
   * 创建多维数组
   */
  private Object multipartArray(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Class componentClass = ((Class) type).getComponentType();
    Object result = Array.newInstance(componentClass, size);
    for (int index = 0; index < size; index++) {
      Object value = new BaseMocker(componentClass).mock(mockConfig);
      Array.set(result, index, value);
    }
    return result;
  }
}
