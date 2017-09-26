package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import com.github.jsonzou.jmockdata.kanyuxia.HandleMock;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.RandomUtils;

public class SetMocker extends BaseMocker<Set> {

  private final Type genericType;

  public SetMocker(Type genericType) {
    this.genericType = genericType;
  }

  @SuppressWarnings("unchecked")
  public Set mockData() throws Exception {
    int size = RandomUtils.nextInt(config.getSizeRange()[0], config.getSizeRange()[1]);
    Set result = new HashSet(size);
    while (size-- > 0) {
      // 判断是否还有泛型
      if (genericType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) genericType;
        result.add(HandleMock.mockData((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]));
        continue;
      }
      result.add(HandleMock.mockData((Class<?>) genericType));
    }
    return result;
  }
}
