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
public class CollectionMocker implements Mocker<Collection> {

  private Class<?> clazz;

  private Type genericType;

  public CollectionMocker(Class<?> clazz, Type genericType) {
    this.clazz = clazz;
    this.genericType = genericType;
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
      if (genericType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) genericType;
        result.add(new BeanMocker((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]).mock(mockConfig));
        continue;
      }
      result.add(JMockData.mock((Class<?>) genericType, mockConfig));
    }
    return result;
  }
}
