
/**
 * Project Name: jmockdata
 * File Name: GlobalBeanMockerInterceptor.java
 * @date 2022年1月17日 下午7:37:48
 * Copyright (c) 2022 jpq.com All Rights Reserved.
 */

package com.github.jsonzou.jmockdata;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.github.jsonzou.jmockdata.annotation.MockValue;
import com.github.jsonzou.jmockdata.util.StringUtils;

/**
 * TODO <br/>
 * @date 2022年1月17日 下午7:37:48
 * @author jpq
 * @version
 */
public class GlobalBeanMockerInterceptor<T> implements BeanMockerInterceptor<T> {
	@Override
	public Object mock(Class<T> clazz, Field field, T bean, DataConfig dataConfig) throws IllegalAccessException {
		MockValue mockValue = field.getAnnotation(MockValue.class);
		if(null != mockValue) {
			if(StringUtils.isNotEmpty(mockValue.value())) {
				dataConfig.subConfig(clazz, field.getName());
				if(CharSequence.class.isAssignableFrom(field.getType())) {
					field.set(bean, mockValue.value());
				} else {
					field.set(bean, dataConfig.setVal(mockValue.value()).getMocker(field.getType()).mock(dataConfig));
					dataConfig.setVal(null);
				}
				return InterceptType.UNMOCK;
			}
			if(StringUtils.isNotEmpty(mockValue.regex())) {
				dataConfig.subConfig(clazz, field.getName());
				if(CharSequence.class.isAssignableFrom(field.getType())) {
					dataConfig.stringRegex(mockValue.regex());
				} else {
					dataConfig.numberRegex(mockValue.regex());
				}
				return InterceptType.MOCK;
			}
//			if(!StringUtils.isAnyBlank(mockValue.rangeMin(), mockValue.rangeMax())) {
//				dataConfig.subConfig(clazz, field.getName()).dateRange(mockValue.rangeMin(), mockValue.rangeMax());
//				return InterceptType.MOCK;
//			}
		}
		return InterceptType.MOCK;
    }
}