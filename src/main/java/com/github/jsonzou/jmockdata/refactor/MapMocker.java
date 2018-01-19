package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class MapMocker implements Mocker {

  private Type[] types;

  MapMocker(Type[] types) {
    this.types = types;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Map result = new HashMap(size);
    int index = 0;
    while (index < size) {
      Object key = new BaseMocker(types[0]).mock(mockConfig);
      Object value = new BaseMocker(types[1]).mock(mockConfig);
      result.put(key, value);
      index = result.size();
    }
    return result;
  }
}
