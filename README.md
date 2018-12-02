# Jmockdata
[![Build Status](https://www.travis-ci.org/jsonzou/jmockdata.svg?branch=master)](https://www.travis-ci.org/jsonzou/jmockdata)
[![Coverage Status](https://coveralls.io/repos/github/jsonzou/jmockdata/badge.svg)](https://coveralls.io/github/jsonzou/jmockdata)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/com.github.jsonzou/jmockdata/badge.svg)](http://mvnrepository.com/artifact/com.github.jsonzou/jmockdata)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


Jmockdta是一款实现模拟JAVA类型或对象的实例化并随机初始化对象的数据的工具框架。单元测试的利器。

![mark](http://p1wz9nw0p.bkt.clouddn.com/blog/180118/0DaEC98Kib.png?imageslim)

The plugin of Jmockdata what through random algorithm mock java data.  
Jmockdata插件通过随机算法模拟Java数据.  

![mark](http://p1wz9nw0p.bkt.clouddn.com/blog/180118/dclH8cgg30.png?imageslim)

## Feature

* 支持丰富多样的数据类型模拟，包括：Java基本类型、字符串、枚举、日期、数组、多维数组、集合[List|Set|Map]、枚举、Java对象等
* 支持泛型
* 支持继承
* 支持循环依赖、自依赖(手动开启enabledCircle)
* 支持忽略字段
* 支持改变mockConfig来自定义模拟数据策略
* 支持JDK1.7+，无任何第三方依赖


## Download

> 
### _Jmockdata-4.0.0_
#### Jar
> [Jmockdata-4.0.0](http://repo.maven.apache.org/maven2/com/github/jsonzou/jmockdata/4.0.0/jmockdata-4.0.0.jar)
#### Maven
 ```
   <dependency>
      <groupId>com.github.jsonzou</groupId>
      <artifactId>jmockdata</artifactId>
      <version>4.0.0</version>
    </dependency>
  ```
#### Gradle
 ```
   compile group: 'com.github.jsonzou', name: 'jmockdata', version: '4.0.0'
  ```
## History version
- 1.0
- 2.0
- 2.1
- 2.2
- 2.3
- 2.4
- 3.0.0
- 3.0.1
- 3.1.0
- 4.0.0


## Usage 

### 基础类型

支持以下基础类型直接模拟

| 描述     | 类型                                       |
| ------ | ---------------------------------------- |
| 基础类型   | ```byte```     ```boolean```     ```char```     ```short```     ```int```     ```long```     ```float```     ```double``` |
| 包装类型包装 | ```Byte```     ```Boolean```     ```Character```     ```Short```     ```Integer```     ```Long```     ```Float```     ```Double``` |
| 常用类型   | ```BigDecimal```        ```BigInteger```        ```Date```        ```String```      枚举 |
| 多维数组   | 以上所有类型的多维数组  如：```int[]```      ```int[][]```  ```int[][][]```  .... 等 |

```java
//基本类型模拟
int intNum = JMockData.mock(int.class);
int[] intArray = JMockData.mock(int[].class);
Integer integer = JMockData.mock(Integer.class);
Integer[] integerArray = JMockData.mock(Integer[].class);
//常用类型模拟
BigDecimal bigDecimal = JMockData.mock(BigDecimal.class);
BigInteger bigInteger = JMockData.mock(BigInteger.class);
Date date = JMockData.mock(Date.class);
String str = JMockData.mock(String.class);
```

### JAVA对象

模拟bean，被模拟的数据必须是plain bean，底层采用了java自带的内省方法来获取字段和对应的setter方法。

支持模拟继承而来的属性。

```java
//模拟Java对象
public class BasicBean {
  //基本类型
  private byte byteNum;
  private boolean booleanNum;
  private char charNum;
  private short shortNum;
  private int integerNum;
  private long longNum;
  private float floatNum;
  private double doubleNum;
  //基本包装类型
  private Byte byteBoxing;
  private Boolean booleanBoxing;
  private Character charBoxing;
  private Short shortBoxing;
  private Integer integerBoxing;
  private Long longBoxing;
  private Float floatBoxing;
  private Double doubleBoxing;
  //基本类型数组
  private byte[] byteNumArray;
  private boolean[] booleanNumArray;
  private char[] charNumArray;
  private short[] shortNumArray;
  private int[] integerNumArray;
  private long[] longNumArray;
  private float[] floatNumArray;
  private double[] doubleNumArray;
  //基本类型二维数组
  private byte[][] byteNumDoubleArray;
  private boolean[][] booleanNumDoubleArray;
  private char[][] charNumDoubleArray;
  private short[][] shortNumDoubleArray;
  private int[][] integerNumDoubleArray;
  private long[][] longNumDoubleArray;
  private float[][] floatNumDoubleArray;
  private double[][] doubleNumDoubleArray;
  //基本包装类型数组
  private Byte[] byteBoxingArray;
  private Boolean[] booleanBoxingArray;
  private Character[] charBoxingArray;
  private Short[] shortBoxingArray;
  private Integer[] integerBoxingArray;
  private Long[] longBoxingArray;
  private Float[] floatBoxingArray;
  private Double[] doubleBoxingArray;
  //基本包装类型二维数组
  private Byte[][] byteBoxingDoubleArray;
  private Boolean[][] booleanBoxingDoubleArray;
  private Character[][] charBoxingDoubleArray;
  private Short[][] shortBoxingDoubleArray;
  private Integer[][] integerBoxingDoubleArray;
  private Long[][] longBoxingDoubleArray;
  private Float[][] floatBoxingDoubleArray;
  private Double[][] doubleBoxingDoubleArray;
  //其他常用类型
  private BigDecimal bigDecimal;
  private BigInteger bigInteger;
  private Date date;
  private String string;
  //其他常用类型数组
  private BigDecimal[] bigDecimalArray;
  private BigInteger[] bigIntegerArray;
  private Date[] dateArray;
  private String[] stringArray;
  //其他常用类型二维数组
  private BigDecimal[][] bigDecimalDoubleArray;
  private BigInteger[][] bigIntegerDoubleArray;
  private Date[][] dateDoubleArray;
  private String[][] stringDoubleArray;
  //集合、MAP数组
  private List<Integer>[] listArray;
  private Set<Integer>[] setArray;
  private Map<Integer, String>[] mapArray;
  //集合、MAP二维数组
  private List<Integer>[][] listDoubleArray;
  private Set<Integer>[][] setDoubleArray;
  private Map<Integer, String>[][] mapDoubleArray;
  //集合、MAP二维数组(内部数组)
  private List<Integer[]>[][] listInnerArrayDoubleArray;
  private Set<Integer[]>[][] setInnerArrayDoubleArray;
  private Map<Integer[], String[]>[][] mapInnerArrayDoubleArray;
  //集合、MAP二维数组(内部二维数组)
  private List<Integer[][]>[][] listInnerDoubleArrayDoubleArray;
  private Set<Integer[][]>[][] setInnerDoubleArrayDoubleArray;
  private Map<Integer[][], String[][]>[][] mapInnerDoubleArrayDoubleArray;
  //LIST
  private List<Byte> byteBoxingList;
  private List<Boolean> booleanBoxingList;
  private List<Character> charBoxingList;
  private List<Short> shortBoxingList;
  private List<Integer> integerBoxingList;
  private List<Long> longBoxingList;
  private List<Float> floatBoxingList;
  private List<Double> doubleBoxingList;
  private List<BigDecimal> bigDecimalList;
  private List<BigInteger> bigIntegerList;
  private List<Date> dateList;
  private List<String> stringList;
  private List<List<String>> stringListList;
  private List<Set<String>> stringSetList;
  private List<Map<Integer, String>> mapList;
  //数组LIST
  private List<Byte[]> byteBoxingArrayList;
  private List<Boolean[]> booleanBoxingArrayList;
  private List<Character[]> charBoxingArrayList;
  private List<Short[]> shortBoxingArrayList;
  private List<Integer[]> integerBoxingArrayList;
  private List<Long[]> longBoxingArrayList;
  private List<Float[]> floatBoxingArrayList;
  private List<Double[]> doubleBoxingArrayList;
  private List<BigDecimal[]> bigDecimalArrayList;
  private List<BigInteger[]> bigIntegerArrayList;
  private List<Date[]> dateArrayList;
  private List<String[]> stringArrayList;
  //二维数组LIST
  private List<Byte[][]> byteBoxingDoubleArrayList;
  private List<Boolean[][]> booleanBoxingDoubleArrayList;
  private List<Character[][]> charBoxingDoubleArrayList;
  private List<Short[][]> shortBoxingDoubleArrayList;
  private List<Integer[][]> integerBoxingDoubleArrayList;
  private List<Long[][]> longBoxingDoubleArrayList;
  private List<Float[][]> floatBoxingDoubleArrayList;
  private List<Double[][]> doubleBoxingDoubleArrayList;
  private List<BigDecimal[][]> bigDecimalDoubleArrayList;
  private List<BigInteger[][]> bigIntegerDoubleArrayList;
  private List<Date[][]> dateDoubleArrayList;
  private List<String[][]> stringDoubleArrayList;
  //SET忽略同List
  //MAP
  private Map<String, Integer> basicMap;
  private Map<String[], Integer> keyArrayMap;
  private Map<String, Integer[]> valueArrayMap;
  private Map<String[], Integer[]> keyValueArrayMap;
  private Map<String[][], Integer[][]> keyValueDoubleArrayMap;
  private Map<List<String>, Map<String, Integer>> keyListValueMapMap;
  private Map<List<String>[], Map<String, Integer>[]> keyArrayListValueArrayMapMap;
  //getter setter省略...
}

//调用模拟数据的方法模拟Java对象
BasicBean basicBean = JMockData.mock(BasicBean.class);
```
### 任意类型（LIST,SET,MAP）

```java
@Test
//******注意TypeReference要加{}才能模拟******
public void testTypeRefrence() {
  //模拟基础类型，不建议使用这种方式，参考基础类型章节直接模拟。
  Integer integerNum = JMockData.mock(new TypeReference<Integer>(){});
  Integer[] integerArray = JMockData.mock(new TypeReference<Integer[]>(){});
  //模拟集合
  List<Integer> integerList = JMockData.mock(new TypeReference<List<Integer>>(){});
  //模拟数组集合
  List<Integer[]> integerArrayList = JMockData.mock(new TypeReference<List<Integer[]>>(){});
  //模拟集合数组
  List<Integer>[] integerListArray = JMockData.mock(new TypeReference<List<Integer>[]>(){});
  //模拟集合实体
  List<BasicBean> basicBeanList = JMockData.mock(new TypeReference<List<BasicBean>>(){});
  //各种组合忽略。。。。map同理。下面模拟一个不知道什么类型的map
  Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>> some = JMockData.mock(new TypeReference<Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>>>(){});
}
```

### 更改随机范围以及排除某些不模拟数据的字段
#### 字段支持三种模式匹配，可快速配置：[\*FieldWord\*]、[\*FieldWord]、[FieldWord\*]
```java
MockConfig mockConfig = new MockConfig()
            // 全局配置
            .globalConfig()
            .sizeRange(1,1)
            .charSeed((char) 97, (char) 98)
            .byteRange((byte) 0, Byte.MAX_VALUE)
            .shortRange((short) 0, Short.MAX_VALUE)

            // 某些字段（名等于integerNum的字段、包含float的字段、double开头的字段）配置
            .subConfig("integerNum","*float*","double*")
            .intRange(10, 11)
            .floatRange(1.22f, 1.50f)
            .doubleRange(1.50,1.99)

            // 某个类的某些字段（long开头的字段、date结尾的字段、包含string的字段）配置。
            .subConfig(BasicBean.class,"long*","*date","*string*")
            .longRange(12, 13)
            .dateRange("2018-11-20", "2018-11-30")
            .stringSeed("SAVED", "REJECT", "APPROVED")
            .sizeRange(1,1)

            // 全局配置
            .globalConfig()
            // 排除所有包含list/set/map字符的字段。表达式不区分大小写。
            .excludes("*List*","*Set*","*Map*")
            // 排除所有Array开头/Boxing结尾的字段。表达式不区分大小写。
            .excludes(BasicBean.class,"*Array","Boxing*");
    BasicBean basicBean = JMockData.mock(BasicBean.class, mockConfig);
```

## 高级特性

### 循环依赖

```java
public class AXB {
  private BXA BXA;
  private String name;
  //getter setter省略...
}
public class BXA {
  private AXB AXB;
  private String name;
  //getter setter省略...
}
@Test
public void testCircular() {
   AXB axb = JMockData.mock(AXB.class);
   AXB circularAxb = axb.getBXA().getAXB();
   assertSame(axb, circularAxb);
}
```

### 自依赖

```java
public class SelfRefData {

  private Integer id;
  private String name;
  private SelfRefData parent;
  private Map<SelfRefData, SelfRefData> parentMap;
  private SelfRefData[] parentArray;
  private List<SelfRefData> list;
  private List<SelfRefData[]> listArray;
  private List<List<SelfRefData[]>> listListArray;
  private List<SelfRefData>[] arrayList;

  private SelfRefData[][][] data;
  private Map<SelfRefData, SelfRefData[]> mapArray;
  private Map<SelfRefData, List<SelfRefData>> mapList;
  private Map<SelfRefData, List<SelfRefData[]>> mapListArray;
  //getter setter省略...
}
@Test
public void testSelf() {
   SelfRefData selfRefData = JMockData.mock(SelfRefData.class);
   assertSame(selfRefData.getParent(), selfRefData);
}
```

### 泛型继承

```java
//定义一个泛型父类
public class GenericData<A, B, C> {
  private A a;
  private B b;
  private C c;
  private A[] aArray;
  private List<B> bList;
  private Map<A, B> map;
  private List<C>[] cArray;
  private Map<Map<A, B>, List<C>>[] d;
  //getter setter省略...
}

@Test
public void testGenericData() {
    GenericData<Integer, String, BasicBean> genericData = JMockData.mock(new TypeReference<GenericData<Integer, String, BasicBean>>() {});
    assertNotNull(genericData);
  }
```
