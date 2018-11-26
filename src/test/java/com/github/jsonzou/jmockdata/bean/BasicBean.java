package com.github.jsonzou.jmockdata.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import com.github.jsonzou.jmockdata.bean.enums.DayEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Data
public class BasicBean {

  //基本类型
  @MockIgnore
  private byte byteNum;
  private boolean booleanNum;
  private char charNum;
  private short shortNum;
  private int integerNum;
  private long longNum;
  private float floatNum;
  private double doubleNum;
  //基本包装类型
  @MockIgnore
  private Byte byteBoxing;
  private Boolean booleanBoxing;
  private Character charBoxing;
  private Short shortBoxing;
  private Integer integerBoxing;
  private Long longBoxing;
  private Float floatBoxing;
  private Double doubleBoxing;
  //基本类型数组
  @MockIgnore
  private byte[] byteNumArray;
  private boolean[] booleanNumArray;
  private char[] charNumArray;
  private short[] shortNumArray;
  private int[] integerNumArray;
  private long[] longNumArray;
  private float[] floatNumArray;
  private double[] doubleNumArray;
  //基本类型二维数组
  @MockIgnore
  private byte[][] byteNumDoubleArray;
  private boolean[][] booleanNumDoubleArray;
  private char[][] charNumDoubleArray;
  private short[][] shortNumDoubleArray;
  private int[][] integerNumDoubleArray;
  private long[][] longNumDoubleArray;
  private float[][] floatNumDoubleArray;
  private double[][] doubleNumDoubleArray;
  //基本包装类型数组
  @MockIgnore
  private Byte[] byteBoxingArray;
  private Boolean[] booleanBoxingArray;
  private Character[] charBoxingArray;
  private Short[] shortBoxingArray;
  private Integer[] integerBoxingArray;
  private Long[] longBoxingArray;
  private Float[] floatBoxingArray;
  private Double[] doubleBoxingArray;
  //基本包装类型二维数组
  @MockIgnore
  private Byte[][] byteBoxingDoubleArray;
  private Boolean[][] booleanBoxingDoubleArray;
  private Character[][] charBoxingDoubleArray;
  private Short[][] shortBoxingDoubleArray;
  private Integer[][] integerBoxingDoubleArray;
  private Long[][] longBoxingDoubleArray;
  private Float[][] floatBoxingDoubleArray;
  private Double[][] doubleBoxingDoubleArray;
  //其他常用类型
  @MockIgnore
  private BigDecimal bigDecimal;
  private BigInteger bigInteger;
  @JSONField(format="yyyy-MM-dd")
  private Date date;
  private String string;
  private DayEnum dayEnum;
  private TimeUnit timeUnit;
  //其他常用类型数组
  @MockIgnore
  private BigDecimal[] bigDecimalArray;
  private BigInteger[] bigIntegerArray;
  private Date[] dateArray;
  private String[] stringArray;
  private DayEnum[] dayEnumArray;
  //其他常用类型二维数组
  @MockIgnore
  private BigDecimal[][] bigDecimalDoubleArray;
  private BigInteger[][] bigIntegerDoubleArray;
  private Date[][] dateDoubleArray;
  private String[][] stringDoubleArray;
  private DayEnum[][] dayEnumDoubleArray;
  //集合、MAP数组
  @MockIgnore
  private List<Integer>[] listArray;
  private Set<Integer>[] setArray;
  private Map<Integer, String>[] mapArray;
  //集合、MAP二维数组
  @MockIgnore
  private List<Integer>[][] listDoubleArray;
  private Set<Integer>[][] setDoubleArray;
  private Map<Integer, String>[][] mapDoubleArray;
  //集合、MAP二维数组(内部数组)
  @MockIgnore
  private List<Integer[]>[][] listInnerArrayDoubleArray;
  private Set<Integer[]>[][] setInnerArrayDoubleArray;
  private Map<Integer[], String[]>[][] mapInnerArrayDoubleArray;
  //集合、MAP二维数组(内部二维数组)
  @MockIgnore
  private List<Integer[][]>[][] listInnerDoubleArrayDoubleArray;
  private Set<Integer[][]>[][] setInnerDoubleArrayDoubleArray;
  private Map<Integer[][], String[][]>[][] mapInnerDoubleArrayDoubleArray;
  //LIST
  @MockIgnore
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
  @MockIgnore
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
  @MockIgnore
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
  //SET
  @MockIgnore
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
  private Set<List<String>> stringListSet;
  private Set<Set<String>> stringSetSet;
  private Set<Map<Integer, String>> mapSet;
  //数组SET
  @MockIgnore
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
  //二维数组SET
  @MockIgnore
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
  //Map
  @MockIgnore
  private Map<String, Integer> basicMap;
  private Map<String[], Integer> keyArrayMap;
  private Map<String, Integer[]> valueArrayMap;
  private Map<String[], Integer[]> keyValueArrayMap;
  private Map<String[][], Integer[][]> keyValueDoubleArrayMap;
  private Map<List<String>, Map<String, Integer>> keyListValueMapMap;
  private Map<List<String>[], Map<String, Integer>[]> keyArrayListValueArrayMapMap;

}
