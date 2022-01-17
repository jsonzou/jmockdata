package com.github.jsonzou.jmockdata.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.github.jsonzou.jmockdata.MockException;

/**
 * 反射工具类
 */
public final class ReflectionUtils {

  private ReflectionUtils() {
  }

  /**
   * 反射设置值
   *
   * @param object 对象
   * @param method 方法
   * @param args 方法参数对象
   * @throws ReflectiveOperationException 反射操作异常
   */
  public static void setRefValue(Object object, Method method, Object... args) throws ReflectiveOperationException {
    method.invoke(object, args);
  }

  /**
   * 反射设置值
   *
   * @param object 对象
   * @param field 属性
   * @param value 属性值
   * @throws ReflectiveOperationException 反射操作异常
   */
  public static void setFieldValue(Object object, Field field, Object value) throws IllegalAccessException {
    field.setAccessible(true);
    field.set(object, value);
  }

  /**
   * 有setter方法的字段及其setter方法
   *
   * @param clazz Class对象
   * @return 有setter方法的 字段及其setter方法
   * @throws IntrospectionException 内省异常
   */
  public static Map<Field, Method> fieldAndSetterMethod(Class clazz) throws IntrospectionException {
    Map<Field, Method> map = new LinkedHashMap<>();
    BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
    for (Field field : clazz.getDeclaredFields()) {
      for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
        if (propertyDescriptor.getName().equals(field.getName()) && propertyDescriptor.getWriteMethod() != null) {
          map.put(field, propertyDescriptor.getWriteMethod());
        }
      }
    }
    return map;
  }

  public static boolean isSystemClass(String name) {
	    return name.startsWith("java.") || name.startsWith("javax.");
  }
  
  /**
   * 将泛型的名称唯一化 <br/>
   * @author jpq
   * @param typeVariable
   * @return
   */
  public static String getTypeVariableName(TypeVariable<?> typeVariable) {
	    GenericDeclaration declaration = typeVariable.getGenericDeclaration();
	    if (!(declaration instanceof Class<?>)) {
	        throw new MockException("unknown error");
	    }

	    return String.format("%s.%s", ((Class<?>) declaration).getName(), typeVariable.getName());
	}
}
