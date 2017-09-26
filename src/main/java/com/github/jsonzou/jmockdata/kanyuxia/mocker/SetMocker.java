package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
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
        result.add(new BeanMocker((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]).mockData());
        continue;
      }
      result.add(JMock.mockData((Class<?>) genericType));
    }
    return result;
  }
}
