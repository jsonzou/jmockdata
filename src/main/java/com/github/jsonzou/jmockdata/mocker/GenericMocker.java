package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

@SuppressWarnings("unchecked")
public class GenericMocker<T> implements Mocker<T> {

  private Class<?> clazz;

  private Type[] genericTypes;

  private Map<String, Type> map = new HashMap<>();

  public GenericMocker(Class<?> clazz, Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
    initMap(clazz, genericTypes);
  }

  private void initMap(Class<?> clazz, Type[] genericTypes) {
    TypeVariable<? extends Class<?>>[] typeVariables = clazz.getTypeParameters();
    for (int i = 0; i < typeVariables.length; i++) {
      map.put(typeVariables[i].getName(), genericTypes[i]);
    }
  }

  @Override
  public T mock(MockConfig mockConfig) {
    try {
      T result = (T) clazz.newInstance();
      mockConfig.addCache(clazz.getName(), result);
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Method method = entry.getValue();
          Field field = entry.getKey();
          Type type = field.getGenericType();
          Class<?> fieldClass = field.getType();
          if (type instanceof TypeVariableImpl) {
            fieldClass = (Class<?>) map.get(((TypeVariableImpl) field.getGenericType()).getName());
          }
          Object value = JMockData.mock(fieldClass, mockConfig);
          ReflectionUtils.setRefValue(result, method, value);
        }

      }
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }
}
