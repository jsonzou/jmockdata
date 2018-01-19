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
@SuppressWarnings("unchecked")
public class MapMocker implements Mocker<Map> {

  private Type[] genericTypes;

  public MapMocker(Type[] genericTypes) {
    this.genericTypes = genericTypes;
  }

  @Override
  public Map mock(MockConfig mockConfig) {
    int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Map result = new HashMap(size);
    while (size-- > 0) {
      result.put(mockType(genericTypes[0], mockConfig), mockType(genericTypes[1], mockConfig));
    }
    return result;
  }

  private Object mockType(Type type, MockConfig mockConfig) {
    return new GenericMocker(type).mock(mockConfig);
  }

}
