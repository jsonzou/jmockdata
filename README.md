# Jmockdata
[![Build Status](https://www.travis-ci.org/jsonzou/jmockdata.svg?branch=dev)](https://www.travis-ci.org/jsonzou/jmockdata)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/com.github.jsonzou/jmockdata/badge.svg)](http://mvnrepository.com/artifact/com.github.jsonzou/jmockdata)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Coverage Status](https://coveralls.io/repos/github/jsonzou/jmockdata/badge.svg?branch=dev)](https://coveralls.io/github/jsonzou/jmockdata?branch=dev)
Jmockdta是一款实现模拟JAVA类型或对象的实例化并随机初始化对象的数据的工具框架。单元测试的利器。

The plugin of Jmockdata what through random algorithm mock java data.  
Jmockdata插件通过随机算法模拟Java数据.  

![mark](http://p1wz9nw0p.bkt.clouddn.com/blog/180118/dclH8cgg30.png?imageslim)

## Feature

* 模拟数据类型多，基本类型，基本包装类型，数组，多维数组，集合，泛型包装，泛型继承等。
* 循环依赖，自依赖支持。
* 改变mockConfig自定义模拟数据范围。
* 支持JDK1.7+，无任何第三方依赖。

## Usage 

### 基础类型和对象

模拟bean，被模拟的数据必须是plain bean，底层采用了java自带的内省方法来获取字段和对应的setter方法。

```java
@Data
public class BasicData {

  //基本类型
  private byte byteUnboxing;
  private boolean booleanUnboxing;
  private char charUnboxing;
  private short shortUnboxing;
  private int integerUnboxing;
  private long longUnboxing;
  private float floatUnboxing;
  private double doubleUnboxing;
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
  private byte[] byteUnboxingArray;
  private boolean[] booleanUnboxingArray;
  private char[] charUnboxingArray;
  private short[] shortUnboxingArray;
  private int[] integerUnboxingArray;
  private long[] longUnboxingArray;
  private float[] floatUnboxingArray;
  private double[] doubleUnboxingArray;
  //基本类型二维数组
  private byte[][] byteUnboxingDoubleArray;
  private boolean[][] booleanUnboxingDoubleArray;
  private char[][] charUnboxingDoubleArray;
  private short[][] shortUnboxingDoubleArray;
  private int[][] integerUnboxingDoubleArray;
  private long[][] longUnboxingDoubleArray;
  private float[][] floatUnboxingDoubleArray;
  private double[][] doubleUnboxingDoubleArray;
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

  private BigDecimal[] bigDecimalArray;
  private BigInteger[] bigIntegerArray;
  private Date[] dateArray;
  private String[] stringArray;

  private BigDecimal[][] bigDecimalDoubleArray;
  private BigInteger[][] bigIntegerDoubleArray;
  private Date[][] dateDoubleArray;
  private String[][] stringDoubleArray;
  //集合
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

  private Set<Byte> byteBoxingSet;
  private Set<Boolean> booleanBoxingSet;
  private Set<Character> charBoxingSet;
  private Set<Short> shortBoxingSet;
  private Set<Integer> integerBoxingSet;
  private Set<Long> longBoxingSet;
  private Set<Float> floatBoxingSet;
  private Set<Double> doubleBoxingSet;
  private Set<BigDecimal> bigDecimalSet;
  private Set<BigInteger> bigIntegerSet;
  private Set<Date> dateSet;
  private Set<String> stringSet;

  private Set<Byte[]> byteBoxingArraySet;
  private Set<Boolean[]> booleanBoxingArraySet;
  private Set<Character[]> charBoxingArraySet;
  private Set<Short[]> shortBoxingArraySet;
  private Set<Integer[]> integerBoxingArraySet;
  private Set<Long[]> longBoxingArraySet;
  private Set<Float[]> floatBoxingArraySet;
  private Set<Double[]> doubleBoxingArraySet;
  private Set<BigDecimal[]> bigDecimalArraySet;
  private Set<BigInteger[]> bigIntegerArraySet;
  private Set<Date[]> dateArraySet;
  private Set<String[]> stringArraySet;

  private Set<Byte[][]> byteBoxingDoubleArraySet;
  private Set<Boolean[][]> booleanBoxingDoubleArraySet;
  private Set<Character[][]> charBoxingDoubleArraySet;
  private Set<Short[][]> shortBoxingDoubleArraySet;
  private Set<Integer[][]> integerBoxingDoubleArraySet;
  private Set<Long[][]> longBoxingDoubleArraySet;
  private Set<Float[][]> floatBoxingDoubleArraySet;
  private Set<Double[][]> doubleBoxingDoubleArraySet;
  private Set<BigDecimal[][]> bigDecimalDoubleArraySet;
  private Set<BigInteger[][]> bigIntegerDoubleArraySet;
  private Set<Date[][]> dateDoubleArraySet;
  private Set<String[][]> stringDoubleArraySet;

}
//调用模拟数据的方法
BasicData basicData = JMockData.mock(BasicData.class);
```

### 循环依赖对象

```java
@Data
public class AXB {
  private BXA BXA;
  private String name;
}
@Data
public class BXA {
  private AXB AXB;
  private String name;
}
@Test
public void testCircular() {
   AXB axb = JMockData.mock(AXB.class);
   AXB circularAxb = axb.getBXA().getAXB();
   assertSame(axb, circularAxb);
}
```

### 自依赖对象

```java
Getter
@Setter
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

}
@Test
public void testSelf() {
   SelfRefData selfRefData = JMockData.mock(SelfRefData.class);
   assertSame(selfRefData.getParent(), selfRefData);
}
```

### 集合对象

```java
 @Test
//注意TypeReference要加{}才能模拟
  public void testTypeRefrence() {
    Integer integerNum = JMockData.mock(new TypeReference<Integer>() {
    });
    assertNotNull(integerNum);
    Integer[] integerArray = JMockData.mock(new TypeReference<Integer[]>() {
    });
    assertNotNull(integerArray);
    List<Integer[]> integerArrayList = JMockData.mock(new TypeReference<List<Integer[]>>() {
    });
    assertNotNull(integerArrayList);
    List<Integer>[] integerListArray = JMockData.mock(new TypeReference<List<Integer>[]>() {
    });
    assertNotNull(integerListArray);
    Map<String, Integer> map = JMockData.mock(new TypeReference<Map<String, Integer>>() {
    });
    assertNotNull(map);
    Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>> some = JMockData
        .mock(new TypeReference<Map<List<Map<Integer, String[][]>>, Map<Set<String>, Double[]>>>() {
        });
    assertNotNull(some);
  }
```

