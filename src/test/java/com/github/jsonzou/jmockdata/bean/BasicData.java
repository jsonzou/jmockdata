package com.github.jsonzou.jmockdata.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;

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

  private Map<String, Integer> basicMap;
  private Map<String, Integer>[] arrayMap;
  private Map<String[], Integer> keyArrayMap;
  private Map<String, Integer[]> valueArrayMap;
  private Map<String[], Integer[]> keyValueArrayMap;
  private Map<String[][], Integer[][]> keyValueDoubleArrayMap;
  private Map<List<String>, Map<String,Integer>> keyListValueMapMap;
  private Map<List<String>[], Map<String,Integer>[]> keyArrayListValueArrayMapMap;

}
