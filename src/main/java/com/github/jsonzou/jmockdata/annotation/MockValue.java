
/**
 * Project Name: fast-flowable-api
 * File Name: MockValue.java
 * @date 2022年1月17日 下午1:24:48
 * Copyright (c) 2022 jpq.com All Rights Reserved.
 */

package com.github.jsonzou.jmockdata.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @MockIgnore 优先级更高 <br/>
 * @date 2022年1月17日 下午1:24:48
 * @author jpq
 * @version
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MockValue {

	// 默认值，优先级最高；对于布尔值，true/false
	String value() default "";
	
	// 正则格式，只支持字符串、数字！！！
	String regex() default "";
}

 