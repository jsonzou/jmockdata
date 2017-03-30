package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mockdata.*;
import com.github.jsonzou.jmockdata.utils.ReflectionUtil;
import com.github.jsonzou.jmockdata.utils.TypeReference;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 *  <p>
 *  1.框架默认实现了40个元数据类型的数据模拟器包括：
 *    byte.class,Byte.class,byte[].class,Byte[].class,
 *    short.class,Short.class,short[].class,Short[].class,
 *    int.class,Integer.class,int[].class,Integer[].class,
 *    long.class,Long.class,long[].class,Long[].class,
 *    float.class,Float.class,float[].class,Float[].class,
 *    double.class,Double.class,double[].class,Double[].class,
 *    boolean.class,Boolean.class,boolean[].class,Boolean[].class,
 *    char.class,Character.class,char[].class,Character[].class,
 *    String.class,String[].class,
 *    BigDecimal.class,BigDecimal[].class,
 *    BigInteger.class,BigInteger[].class,
 *    Date.class,Date[].class
 * 2.可以通过JmockDataContext 获取模拟过程的所有上下文信息，甚至可以打印整个模拟类型树
 * 3.可以通过JMockDataManager 注册模拟数据类型，重写模拟数据算法，注册模拟数据类拦截器等
 * 4.可以通过实现MockData来实现一个模拟数据类型
 * 5.可以通过实现JmockDataTemplate，或者继承JmockDataTemplateDefault来重写模拟数据算法
 * 6.可以通过实现JmockDataInterceptor来实现一个拦截器
 * </p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/16
 *
 */
public class JMockData {
    private static final JmockdataWrapperMetaDataSingle jmockdataWrapperMetaDataSingle = new JmockdataWrapperMetaDataSingle();
    public static <T extends JmockDataWrapper> T mock(Class<T> mockType)  {
        JmockDataContext context=JmockDataContext.newRootInstance(mockType);
        JmockDataWrapper data= JMockDataManager.getInstance().getMockDataBean(mockType).mock(context);
        data.setJmockDataContext(context);
        context.printTree();
        return (T)data;
    }

    /**
     * mock collections
     * List
     * Map
     * Set
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T mockCollection(TypeReference<T> type)  {
        ParameterizedTypeImpl dtype=(ParameterizedTypeImpl)type.getType();
        try {
            if(!ReflectionUtil.isContainer(ReflectionUtil.getClass(dtype))){
                return null;
            }
             JmockDataContext context=JmockDataContext.newRootInstance(ReflectionUtil.getClass(dtype));
             MockData md=  JMockDataManager.getInstance().getMockDataBean(ReflectionUtil.getClass(dtype),
                    ReflectionUtil.getParameterizedType(dtype));
            T data=(T)md.mock(context);
            context.printTree();
            return data;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

         return null;

    }

    /**
     * Mock POJO
     * Mock 元数据
     * @param simpleType
     * @param <T>
     * @return
     */
    public static <T> T mockSimpleType(Class<T> simpleType)  {
        JmockDataContext context=JmockDataContext.newRootInstance(simpleType);
        T simple=JMockDataManager.getInstance().getMockDataBean(simpleType).mock(context);
        context.printTree();
        return simple;
    }

    /**
     * mock 全部元数据
     * @return
     */
    public static JmockdataWrapperMetaDataAll mockMetaDataAll()  {

        return mock(JmockdataWrapperMetaDataAll.class);
    }

    /**
     * mock 单个元数据
     * @return
     */
    public static JmockdataWrapperMetaDataSingle mockMetaDataSingle()  {
        return jmockdataWrapperMetaDataSingle;
    }
}
