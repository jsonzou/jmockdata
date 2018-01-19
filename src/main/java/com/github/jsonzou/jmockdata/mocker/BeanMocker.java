package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Bean模拟器
 */
@SuppressWarnings("unchecked")
public class BeanMocker<T> implements Mocker<T> {

  private Class<?> clazz;

  private Type[] genericTypes;

  private Map<String, Type> typeVariableMap;

  public BeanMocker(Class<?> clazz, Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
    TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
    if (typeVariables != null && typeVariables.length > 0) {
      typeVariableMap = new HashMap<>();
      for (int i = 0; i < typeVariables.length; i++) {
        typeVariableMap.put(typeVariables[i].getName(), genericTypes[i]);
      }
    }
  }

  @Override
  public T mock(MockConfig mockConfig) {
    if (clazz.isArray()) {
      Type componentType = genericTypes.length == 0 ? clazz.getComponentType() : genericTypes[0];
      return (T) new ArrayMocker(clazz.getComponentType(), componentType).mock(mockConfig);
    } else if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mock(mockConfig);
    } else if (Collection.class.isAssignableFrom(clazz)) {
      return (T) new CollectionMocker(clazz, genericTypes[0]).mock(mockConfig);
    }
    // 从缓存中取已经构造的Bean
    Object cacheBean = mockConfig.getCacheObject(clazz.getName());
    return cacheBean != null ? (T) cacheBean : mockBean(mockConfig);
  }

  private T mockBean(MockConfig mockConfig) {
    try {
      T result = (T) clazz.newInstance();
      mockConfig.addCache(clazz.getName(), result);
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Field field = entry.getKey();
          Type genericType = field.getGenericType();
          Method method = entry.getValue();
          Class<?> fieldClass = field.getType();
          Object value = null;
          if (genericType instanceof TypeVariable) {
            value = new GenericMocker(typeVariableMap.get(((TypeVariable) genericType).getName())).mock(mockConfig);
          } else {
            // 判断字段是否是Map or Collection
            if (Map.class.isAssignableFrom(fieldClass) || Collection.class.isAssignableFrom(fieldClass)) {
              value = new BeanMocker(fieldClass, ((ParameterizedType) field.getGenericType()).getActualTypeArguments()).mock(mockConfig);
              // 判断字段是否是数组
            } else if (fieldClass.isArray()) {
              Type componentType;
              Type type = field.getGenericType();
              // 字段是数组类型(一维数组)
              if (type instanceof GenericArrayType) {
                componentType = ((GenericArrayType) type).getGenericComponentType();
              } else {
                // 字段是多维数组
                componentType = ((Class) type).getComponentType();
              }
              value = new BeanMocker(fieldClass, componentType).mock(mockConfig);
            } else {
              value = new ClassMocker(fieldClass).mock(mockConfig);
            }
          }
          ReflectionUtils.setRefValue(result, method, value);
        }
      }
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }
}
