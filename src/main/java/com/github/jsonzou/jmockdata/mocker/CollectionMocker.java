package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
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
    int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Collection result = initCollection(size);
    while (size-- > 0) {
      result.add(new GenericMocker(type).mock(mockConfig));
    }
    return result;
  }

  private Collection initCollection(int size) {
    Collection result;
    if (List.class.isAssignableFrom(clazz)) {
      result = new ArrayList(size);
    } else if (Set.class.isAssignableFrom(clazz)) {
      result = new HashSet(size);
    } else {
      try {
        result = (Collection) clazz.newInstance();
      } catch (Exception e) {
        throw new MockException("暂时不支持的collection类型", e);
      }
    }
    return result;
  }
}
