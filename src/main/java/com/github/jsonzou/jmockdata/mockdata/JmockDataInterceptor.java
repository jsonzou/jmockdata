
package com.github.jsonzou.jmockdata.mockdata;

/**
 * <p>模拟数据类型拦截器接口</p>
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public interface JmockDataInterceptor {
    /**
     *  false  停止继续mock，return null.
     *  true 继续执行
     *  @param mockData mockData
     *  @param context context
     *  @return Boolean
     */
    Boolean before(MockData mockData,JmockDataContext context);

    /**
     * mock 数据之后，返回mock数据之前执行
     * @param mockData mockData
     * @param context context
     */
    void after(MockData mockData,JmockDataContext context);

    /**
     * 出现异常时调用
     * @param mockData mockData
     * @param context context
     * @param e e
     */
    void error(MockData mockData,JmockDataContext context,Throwable e);

    /**
     * try ... finally 中执行
     * @param mockData mockData
     * @param context context
     */
    void finallyDo(MockData mockData,JmockDataContext context);

    /**
     * 拦截的规则，也可以说是拦截的条件
     * @param mockData mockData
     * @param context context
     * @return Boolean
     */
    Boolean interceptRule(MockData mockData,JmockDataContext context);
}
