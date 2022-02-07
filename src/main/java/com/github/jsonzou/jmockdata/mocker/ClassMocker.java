package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public class ClassMocker implements Mocker<Object> {

  private Class clazz;

  private Type[] genericTypes;

  ClassMocker(Class clazz, Type[] genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  @Override
  public Object mock(DataConfig mockConfig) {
    Mocker mocker;
    if (clazz.isArray()) {
      mocker = new ArrayMocker(clazz);
    } else if (Map.class.isAssignableFrom(clazz)) {
      mocker = mockConfig.globalConfig().getMocker(clazz);
      // MapMocker 默认是HashMap，但是很多包自带的Map，所以先从上面获取，因为可以注入 registerMocker
      mocker = null == mocker ? new MapMocker(genericTypes) : mocker;
    } else if (Collection.class.isAssignableFrom(clazz)) {
      mocker = new CollectionMocker(clazz, genericTypes[0]);
    } else if (clazz.isEnum()) {
      mocker = new EnumMocker(clazz);
    } else {
      mocker = mockConfig.globalConfig().getMocker(clazz);
      if (mocker == null) {
        mocker = new BeanMocker(clazz);
      }
    }
    return mocker.mock(mockConfig);
  }

}
