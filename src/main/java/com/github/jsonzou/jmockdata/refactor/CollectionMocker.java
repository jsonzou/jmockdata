package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("unchecked")
public class CollectionMocker implements Mocker {

  private Class clazz;

  private Type genericType;

  public CollectionMocker(Class clazz, Type genericType) {
    this.clazz = clazz;
    this.genericType = genericType;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Collection result;
    if (List.class.isAssignableFrom(clazz)) {
      result = new ArrayList(size);
    } else {
      result = new HashSet(size);
    }
    int index = 0;
    while (index < size) {
      Object value = new BaseMocker(genericType).mock(mockConfig);
      result.add(value);
      index = result.size();
    }
    return result;
  }
}
