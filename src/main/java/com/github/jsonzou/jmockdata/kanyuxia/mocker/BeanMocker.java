package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import com.github.jsonzou.jmockdata.kanyuxia.HandleMock;
import com.github.jsonzou.jmockdata.kanyuxia.utils.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Bean模拟器
 */
@SuppressWarnings("unchecked")
public class BeanMocker<T> extends BaseMocker<T> {

  private final Class<?> clazz;

  private final Type[] genericTypes;

  public BeanMocker(Class<?> clazz, Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  public T mockData() throws Exception {
    if (clazz.isArray()) {
      return (T) new ArrayMocker(clazz.getComponentType()).mockData();
    }
    if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mockData();
    }
    if (List.class.isAssignableFrom(clazz)) {
      return (T) new ListMocker(genericTypes[0]).mockData();
    }
    if (Set.class.isAssignableFrom(clazz)) {
      return (T) new SetMocker(genericTypes[0]).mockData();
    }
    T result = (T) clazz.newInstance();
    // 从子对象向上依次模拟
    for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
      // 模拟有setter、getter方法的字段
      for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
        Field field = entry.getKey();
        Method method = entry.getValue();
        Class<?> fieldClass = field.getType();
        Object value;
        // 判断是否有泛型参数
        if (ReflectionUtils.hasGeneric(fieldClass)) {
          // 模拟有泛型的数据
          Type[] types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
          value = HandleMock.mockData(fieldClass, types);
        } else {
          value = HandleMock.mockData(fieldClass);
        }
        ReflectionUtils.setRefValue(result, method, value);
      }
    }
    return result;
  }
}
