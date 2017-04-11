/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jsonzou.jmockdata.utils;

import java.lang.reflect.*;
import java.util.Collection;
import java.util.Map;

/**
 * Created by jsonzou on 2016/12/19.
 */
public class ReflectionUtil {

    private static final String TYPE_CLASS_NAME_PREFIX = "class ";
    private static final String TYPE_INTERFACE_NAME_PREFIX = "interface ";

    private ReflectionUtil() {
    }

    public static String getClassName(Type type) {
        if (type == null) {
            return "";
        }
        String className = type.toString();
        if (className.startsWith(TYPE_CLASS_NAME_PREFIX)) {
            className = className.substring(TYPE_CLASS_NAME_PREFIX.length());
        } else if (className.startsWith(TYPE_INTERFACE_NAME_PREFIX)) {
            className = className.substring(TYPE_INTERFACE_NAME_PREFIX.length());
        }
        if (className.endsWith(";")) {
            className = className.substring(0, className.length() - 1);
        }
        if (className.indexOf("<") != -1) {
            className = className.substring(0, className.indexOf("<"));
        }
        return className;
    }


    public static Class<?> getClass(Type type)
            throws ClassNotFoundException {
        String className = getClassName(type);
        if (className == null || className.isEmpty()) {
            return null;
        }
        if (className.startsWith("[L")) {
            return (Class) type;
        }
        return Class.forName(className);
    }

    public static boolean isComponeClassContains(Class masterClass, Type genericType, Class eqlClass)
            throws ClassNotFoundException {
        if (eqlClass.equals(masterClass)) {
            return true;
        }
        Type[] types;
        if (genericType != null && Map.class.isAssignableFrom(masterClass)) {
            types = ((ParameterizedType) genericType).getActualTypeArguments();
            boolean isEql = false;
            if (types != null) {
                for (Type type : types) {
                    isEql = isEql || isComponeClassContains(getClass(type), getParameterizedType(type), eqlClass);
                }
                return isEql;
            } else {
                return false;
            }

        } else if (genericType != null && Collection.class.isAssignableFrom(masterClass)) {
            types = ((ParameterizedType) genericType).getActualTypeArguments();
            boolean isEql = false;
            if (types != null) {
                for (Type type : types) {
                    isEql = isEql || isComponeClassContains(getClass(type), getParameterizedType(type), eqlClass);
                }
                return isEql;
            } else {
                return false;
            }
        } else if (masterClass.isArray()) {
            if (genericType != null && GenericArrayType.class.isAssignableFrom(genericType.getClass())) {
                return isComponeClassContains(masterClass.getComponentType(), getParameterizedType(genericType), eqlClass);
            } else {
                return isComponeClassContains(masterClass.getComponentType(), null, eqlClass);
            }
        }
        return false;
    }


    public static Object newInstance(Type type)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = getClass(type);
        if (clazz == null) {
            return null;
        }
        return clazz.newInstance();
    }


    public static Type getParameterizedType(Type type) {
        if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
            return type;
        }
        if (GenericArrayType.class.isAssignableFrom(type.getClass())) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return null;
    }


    private static Method getMethodNoException(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            // e.printStackTrace();
        }
        return null;
    }

    public static Method getPlainSetMethod(Class<?> clazz, Field field) {
        Method method = null;
        if (field.getModifiers() == 2) { // pravite 方法
            method = getMethodNoException(clazz, "set" + StringUtil.firstLetterToUpperCase(field.getName()), field.getType());
            if (method == null) {
                method = getMethodNoException(clazz, "set" + field.getName(), field.getType());
            }
        }
        if (method != null && method.getModifiers() == 1) { // public 方法
            return method;
        }
        return null;
    }

    public static Method getPlainGetMethod(Class<?> clazz, Field field) {
        Method method = null;
        if (field.getModifiers() == 2) { // pravite 方法
            method = getMethodNoException(clazz, "get" + StringUtil.firstLetterToUpperCase(field.getName()));
            if (method == null) {
                method = getMethodNoException(clazz, "is" + StringUtil.firstLetterToUpperCase(field.getName()));
            }
            if (method == null) {
                method = getMethodNoException(clazz, "has" + StringUtil.firstLetterToUpperCase(field.getName()));
            }
            if (method == null) {
                method = getMethodNoException(clazz, "get" + field.getName());
            }
            if (method == null) {
                method = getMethodNoException(clazz, "is" + field.getName());
            }
            if (method == null) {
                method = getMethodNoException(clazz, "has" + field.getName());
            }
        }
        if (method != null && method.getModifiers() == 1) { // public 方法
            return method;
        }
        return null;
    }

    public static boolean isContainer(Class<?> clazz) {
        if (Map.class.isAssignableFrom(clazz) || Collection.class.isAssignableFrom(clazz)) {
            return true;
        }
        return false;
    }
}