package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟Map
 */
@SuppressWarnings("unchecked")
public class MapMocker implements Mocker<Map> {

  private final Type[] genericTypes;

  MapMocker(Type[] genericTypes) {
    this.genericTypes = genericTypes;
  }
  @Override
  public Map mockData(final MockConfig mockConfig) throws Exception {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Map result = new HashMap(size);
    Type keyType = genericTypes[0];
    Type valueType = genericTypes[1];
    while (size-- > 0) {
      Object key;
      Object value;
      // 判断key是否还有泛型
      if (keyType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) keyType;
        key = new BeanMocker((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]).mockData(mockConfig);
      } else {
        key = JMock.mockData((Class<?>) keyType);
      }
      // 判断value是否还有泛型
      if (valueType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) valueType;
        value = new BeanMocker((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]).mockData(mockConfig);
      } else {
        value = JMock.mockData((Class<?>) valueType);
      }
      result.put(key, value);
    }
    return result;
  }
}
