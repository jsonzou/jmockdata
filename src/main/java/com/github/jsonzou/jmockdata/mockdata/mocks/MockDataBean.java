
package com.github.jsonzou.jmockdata.mockdata.mocks;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;
import com.github.jsonzou.jmockdata.utils.RandomUtil;
import com.github.jsonzou.jmockdata.utils.ReflectionUtil;

/**
 * mock the Bean data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBean<E> implements MockData<E> {
    private Class<E> clazz = null;
    private Type genericType = null;

    public MockDataBean() {

    }

    public MockDataBean(Class<E> clazz) {
        this.clazz = clazz;
    }

    public MockDataBean(Class<E> clazz, Type genericType) {
        this.clazz = clazz;
        this.genericType = genericType;
    }

    public E mock(JmockDataContext context) {

        E mockData;
        Type[] types;
        try {
            if (Map.class.isAssignableFrom(clazz)) {
                if (genericType == null) {
                    return null;
                }
                types = ((ParameterizedType) genericType).getActualTypeArguments();
                if (types != null && types.length > 0) {
                    int size = RandomUtil.randomInteger(JMockDataManager.getInstance().getConfig()
                            .getArrsizeBean()[0], JMockDataManager.getInstance().getConfig().getArrsizeBean()[1]);
                    Map tempMap = new HashMap();
                    if (context.getSelfRefLevel() != null && context.getSelfRefLevel() > JMockDataManager.getInstance()
                            .getMaxSelfRefLevel()) {
                        return (E) tempMap;
                    }
                    MockData mdK = JMockDataManager.getInstance().getMockDataBean(ReflectionUtil.getClass(types[0]),
                            ReflectionUtil.getParameterizedType(types[0]));
                    MockData mdV = JMockDataManager.getInstance().getMockDataBean(ReflectionUtil.getClass(types[1]),
                            ReflectionUtil.getParameterizedType(types[1]));
                    int i = 0;
                    JmockDataContext kContext, vContext;
                    while (i++ < size) {
                        kContext = JmockDataContext
                                .newInstance(context, "$key_" + (i - 1), ReflectionUtil.getClass(types[0]),
                                        ReflectionUtil.getParameterizedType(types[0]));
                        vContext = JmockDataContext
                                .newInstance(context, "$value_" + (i - 1), ReflectionUtil.getClass(types[1]),
                                        ReflectionUtil.getParameterizedType(types[1]));
                        Object k = mdK.mock(kContext);
                        Object v = mdV.mock(vContext);
                        if (k != null && mdV.mock(vContext) != null) {
                            tempMap.put(k, v);
                        }

                    }

                    return (E) tempMap;
                }
            } else if (Collection.class.isAssignableFrom(clazz)) {
                if (genericType == null) {
                    return null;
                }
                if (List.class.isAssignableFrom(clazz)) {
                    types = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (types != null && types.length > 0) {
                        int size = RandomUtil.randomInteger(JMockDataManager.getInstance().getConfig()
                                .getArrsizeBean()[0], JMockDataManager.getInstance().getConfig().getArrsizeBean()[1]);
                        List tempList = new ArrayList();
                        if (context.getSelfRefLevel() != null && context.getSelfRefLevel() > JMockDataManager
                                .getInstance().getMaxSelfRefLevel()) {
                            return (E) tempList;
                        }
                        MockData md = JMockDataManager.getInstance().getMockDataBean(ReflectionUtil.getClass(types[0]),
                                ReflectionUtil.getParameterizedType(types[0]));
                        int i = 0;
                        JmockDataContext vContext;
                        while (i++ < size) {
                            vContext = JmockDataContext
                                    .newInstance(context, "$element_" + (i - 1), ReflectionUtil.getClass(types[0]),
                                            ReflectionUtil.getParameterizedType(types[0]));
                            Object v = md.mock(vContext);
                            if (v != null) {
                                tempList.add(v);
                            }

                        }

                        return (E) tempList;
                    }
                } else if (Set.class.isAssignableFrom(clazz)) {
                    types = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (types != null && types.length > 0) {
                        int size = RandomUtil.randomInteger(JMockDataManager.getInstance().getConfig()
                                .getArrsizeBean()[0], JMockDataManager.getInstance().getConfig().getArrsizeBean()[1]);
                        Set tempSet = new HashSet();
                        if (context.getSelfRefLevel() != null && context.getSelfRefLevel() > JMockDataManager
                                .getInstance().getMaxSelfRefLevel()) {
                            return (E) tempSet;
                        }
                        MockData md = JMockDataManager.getInstance().getMockDataBean(ReflectionUtil.getClass(types[0]),
                                ReflectionUtil.getParameterizedType(types[0]));
                        int i = 0;
                        JmockDataContext vContext;
                        while (i++ < size) {
                            vContext = JmockDataContext
                                    .newInstance(context, "$element_" + (i - 1), ReflectionUtil.getClass(types[0]),
                                            ReflectionUtil.getParameterizedType(types[0]));
                            Object v = md.mock(vContext);
                            if (v != null) {
                                tempSet.add(v);
                            }
                        }
                        return (E) tempSet;
                    }
                }
                return null;
            } else if (clazz.isArray()) {
                if (clazz.getComponentType() != null && clazz.getComponentType() != Object.class) {
                    int len = RandomUtil.randomInteger(JMockDataManager.getInstance().getConfig()
                            .getArrsizeBean()[0], JMockDataManager.getInstance().getConfig().getArrsizeBean()[1]);
                    Object tempArray = Array.newInstance(clazz.getComponentType(), len);
                    if (context.getSelfRefLevel() != null && context.getSelfRefLevel() > JMockDataManager.getInstance()
                            .getMaxSelfRefLevel()) {
                        return (E) tempArray;
                    }
                    MockData md = null;
                    int i = 0;
                    JmockDataContext vContext;
                    boolean isComponeGeneric = false;
                    if (genericType != null && GenericArrayType.class.isAssignableFrom(genericType.getClass())) {
                        md = JMockDataManager.getInstance().getMockDataBean(clazz.getComponentType(),
                                ReflectionUtil.getParameterizedType(genericType));
                        isComponeGeneric = true;
                    } else {
                        md = JMockDataManager.getInstance().getMockDataBean(clazz.getComponentType(), null);

                    }

                    while (i++ < len) {
                        if (isComponeGeneric) {
                            vContext = JmockDataContext
                                    .newInstance(context, "$element_" + (i - 1), clazz.getComponentType(),
                                            ReflectionUtil.getParameterizedType(genericType));
                        } else {
                            vContext = JmockDataContext
                                    .newInstance(context, "$element_" + (i - 1), clazz.getComponentType(), null);
                        }
                        Object v = md.mock(vContext);
                        if (v != null) {
                            Array.set(tempArray, (i - 1), v);
                        }

                    }
                    return (E) tempArray;
                }
                return null;
            } else {

                if (clazz.isInterface()
                        || clazz.isEnum()
                        || clazz.isAnnotation()
                        || clazz.getModifiers() != 1
                        || Modifier.isAbstract(clazz.getModifiers())
                        || Modifier.isStatic(clazz.getModifiers())
                        || Modifier.isFinal(clazz.getModifiers())
                        ) {
                    return null;
                }
                if (context.getSelfRefLevel() != null && context.getSelfRefLevel() > JMockDataManager.getInstance()
                        .getMaxSelfRefLevel()) {
                    return JMockDataManager.getInstance().getDefaultMockDataBean(clazz).mock(null);
                }
                mockData = (E) ReflectionUtil.newInstance(clazz);

                Field[] fields = clazz.getDeclaredFields();
                MockData mockDataFieldBean = null;
                Method setMethod = null;
                Method getMethod = null;
                for (Field field : fields) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (field.getName().equals("jmockDataContext")) {
                        continue;
                    }

                    if (ReflectionUtil.isContainer(field.getType())) {
                        if (field.getGenericType() == null) {
                            continue;
                        }
                        types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
                        if (types == null || types.length == 0) {
                            continue;
                        }
                        /*
                        boolean isSelfGeneric = false;
                        for (Type type : types) {
                            if (ReflectionUtil.getClass(type).equals(clazz)) {
                                isSelfGeneric = true;
                                break;
                            }
                        }
                        if (isSelfGeneric) {
                            continue;
                        }*/
                    }
                    setMethod = ReflectionUtil.getPlainSetMethod(clazz, field);
                    getMethod = ReflectionUtil.getPlainGetMethod(clazz, field);
                    if (setMethod != null && getMethod != null) { // 只对get,set方法的属性进行mock
                        mockDataFieldBean =
                                JMockDataManager.getInstance().getMockDataBean(field.getType(), field.getGenericType());
                        JmockDataContext vContext = JmockDataContext
                                .newInstance(context, field.getName(), field.getType(), field.getGenericType());
                        setMethod.invoke(mockData, mockDataFieldBean.mock(vContext));
                    }
                }
                return mockData;

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MockType mockType() {
        return MockType.BEAN;
    }
}
