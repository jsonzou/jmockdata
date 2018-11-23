package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
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
  public Object mock(DataConfig mockConfig) {
    int size = RandomUtils.nextSize(mockConfig.sizeRange()[0], mockConfig.sizeRange()[1]);
    Map<Object, Object> result = new HashMap<>(size);
    BaseMocker keyMocker = new BaseMocker(types[0]);
    BaseMocker valueMocker = new BaseMocker(types[1]);
    for (int index = 0; index < size; index++) {
      result.put(keyMocker.mock(mockConfig), valueMocker.mock(mockConfig));
    }
    return result;
  }

}
