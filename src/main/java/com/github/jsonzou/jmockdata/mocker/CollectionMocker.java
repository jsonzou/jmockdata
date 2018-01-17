package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author TaoYu
 */
@SuppressWarnings("unchecked")
public class CollectionMocker implements Mocker<Collection> {

  private Class<?> clazz;

  private Type type;

  public CollectionMocker(Class<?> clazz, Type type) {
    this.clazz = clazz;
    this.type = type;
  }

  @Override
  public Collection mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Collection result;
    if (List.class.isAssignableFrom(clazz)) {
      result = new ArrayList(size);
    } else if (Set.class.isAssignableFrom(clazz)) {
      result = new HashSet(size);
    } else {
      throw new MockException("暂时不支持的collection类型");
    }
    while (size-- > 0) {
      Object value;
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        value = new BeanMocker((Class<?>) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments()).mock(mockConfig);
      } else {
        value = JMockData.mock((Class<?>) type, mockConfig);
      }
      result.add(value);
    }
    return result;
  }
}
