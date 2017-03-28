package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mockdata.*;

/**
 *  <p>模拟数据入口方法
 *  1.被模拟数据必须继承JmockDataWrapper经过它的包装
 *  2.被模拟的数据必须是plain bean,只提供getter,setter方法的才可以被模拟
 *  3.框架默认实现了40个元数据类型的数据模拟器包括：
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
 * 4.可以通过JmockDataContext 获取模拟过程的所有上下文信息，甚至可以打印整个模拟类型树
 * 5.可以通过JMockDataManager 注册模拟数据类型，重写模拟数据算法，注册模拟数据类拦截器等
 * 6.可以通过实现MockData来实现一个模拟数据类型
 * 7.可以通过实现JmockDataTemplate，或者继承JmockDataTemplateDefault来重写模拟数据算法
 * 8.可以通过实现JmockDataInterceptor来实现一个拦截器
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
        return (T)data;
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
