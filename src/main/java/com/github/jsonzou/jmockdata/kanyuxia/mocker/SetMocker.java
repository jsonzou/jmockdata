package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.RandomUtils;

@SuppressWarnings("unchecked")
public class SetMocker implements Mocker<Set> {

  private final Type genericType;

  public SetMocker(Type genericType) {
    this.genericType = genericType;
  }

  @Override
  public Set mockData(final MockConfig mockConfig) throws Exception {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Set result = new HashSet(size);
    int index = 0;
    while (index < size) {
      // 判断是否还有泛型
      if (genericType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) genericType;
        result.add(new BeanMocker((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]).mockData(mockConfig));
        continue;
      }
      result.add(JMock.mockData((Class<?>) genericType, mockConfig));
      index = result.size() - 1;
    }
    return result;
  }
}
