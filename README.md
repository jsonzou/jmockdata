# Jmockdata
[![Build Status](https://www.travis-ci.org/jsonzou/jmockdata.svg?branch=dev)](https://www.travis-ci.org/jsonzou/jmockdata)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/com.github.jsonzou/jmockdata/badge.svg)](http://mvnrepository.com/artifact/com.github.jsonzou/jmockdata)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
Jmockdta是一款实现模拟JAVA类型或对象的实例化并随机初始化对象的数据的工具框架。单元测试的利器。    
The plug-in of Jmockdata what through random algorithm mock java data.  
Jmockdata插件通过随机算法模拟Java数据.  
  
示例可以参考单元测试内容，具体介绍和用法可以参考如下：
  
1. 模拟数据入口类Jmockdata 
2. 被模拟的数据最好是plain bean,只提供getter,setter,has,is方法的才可以被模拟 
3. 框架默认实现了40个元数据类型的数据模拟器包括：   
  ``` byte.class,Byte.class,byte[].class,Byte[].class,  
   short.class,Short.class,short[].class,Short[].class,  
   int.class,Integer.class,int[].class,Integer[].class,  
   long.class,Long.class,long[].class,Long[].class,  
   float.class,Float.class,float[].class,Float[].class,  
   double.class,Double.class,double[].class,Double[].class,  
   boolean.class,Boolean.class,boolean[].class,Boolean[].class,  
   char.class,Character.class,char[].class,Character[].class,  
   String.class,String[].class,  
   BigDecimal.class,BigDecimal[].class,  
   BigInteger.class,BigInteger[].class,  
   Date.class,Date[].class  
   ```
     
   通过对以上基本元数据类型的模拟实现，能够进一步实现BEAN，LIST,SET,ARRAY等结构的模拟。  
4. 可以通过JmockDataContext 获取模拟过程的所有上下文信息，甚至可以打印整个模拟类型树   
5. 可以通过JMockDataManager 注册模拟数据类型，重写模拟数据算法，注册模拟数据类拦截器等  
6. 可以通过实现MockData来实现一个模拟数据类型  
7. 可以通过实现JmockDataTemplate，或者继承JmockDataTemplateDefault来重写模拟数据算法  
8. 可以通过实现JmockDataInterceptor来实现一个拦截器  
9. 具体示例实践请参考https://github.com/jsonzou/jmockdata-demo  
10. JDK1.7+
11. 有问题或者对本框架有新的想法，请加QQ群交流：630287196  
