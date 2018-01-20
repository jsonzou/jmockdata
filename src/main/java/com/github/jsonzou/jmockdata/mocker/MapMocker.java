package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟Map
 */
public class MapMocker implements Mocker<Object> {

  private Type[] types;

  MapMocker(Type[] types) {
    this.types = types;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Map<Object, Object> result = new HashMap<>(size);
    for (int index = 0; index < size; index++) {
      Object key = new BaseMocker(types[0]).mock(mockConfig);
      Object value = new BaseMocker(types[1]).mock(mockConfig);
      result.put(key, value);
    }
    return result;
  }
}
