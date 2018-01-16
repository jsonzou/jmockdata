package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟Map
 */
@SuppressWarnings("unchecked")
public class MapMocker implements Mocker<Map> {

  private Type[] genericTypes;

  MapMocker(Type[] genericTypes) {
    this.genericTypes = genericTypes;
  }

  @Override
  public Map mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Map result = new HashMap(size);
    while (size-- > 0) {
      result.put(mockType(mockConfig, genericTypes[0]), mockType(mockConfig, genericTypes[1]));
    }
    return result;
  }

  private Object mockType(MockConfig mockConfig, Type type) {
    if (type instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) type;
      return new BeanMocker((Class<?>) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments()[0]).mock(mockConfig);
    }
    return JMockData.mock((Class<?>) type, mockConfig);
  }
}
