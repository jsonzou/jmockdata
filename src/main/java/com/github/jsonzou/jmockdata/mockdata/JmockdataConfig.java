package com.github.jsonzou.jmockdata.mockdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

import com.github.jsonzou.jmockdata.utils.ResourceUtil;
import com.github.jsonzou.jmockdata.utils.StringUtil;

/**
 * Created by v_zoupengfei on 2017/1/18.
 */
public class JmockdataConfig {
    // value[seed,seed,seed]
    private Character[] seedCharacter =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z'};
    private String[] seedString =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l",
                    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
                    "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    // valueRange[min,max] / [fixed value]
    private Short[] rangeShort = {0, 100};
    private Integer[] rangeInteger = {0, 100};
    private Double[] rangeDouble = {0.0, 100.00};// Double & BigDecimal
    private Float[] rangeFloat = {0.0f, 100.00f};
    private Long[] rangeLong = {0L, 100L};// Double & BigInteger

    // range-YMDhms[Y-min,Y-max,M-min,M-max,D-min,D-max,h-min,h-max,m-min,m-max,s-min,s-max]
    private Integer[] rangeDateY = {}; // default currency year
    private Integer[] rangeDateM = {0, 12};
    private Integer[] rangeDateD = {0, 30};
    private Integer[] rangeDateH = {0, 60};
    private Integer[] rangeDateMi = {0, 60};
    private Integer[] rangeDateS = {0, 60};

    // range-boolean [false,true] / [fixed value]
    private Boolean[] rangeBoolean = {false, true};

    // arrSizeRange[arrSizeRange-min,arrSizeRange-max] / [fixed size]
    private Integer[] arrsizeBean = {0, 10};
    private Integer[] arrsizeBigdecimal = {0, 10};
    private Integer[] arrsizeBiginteger = {0, 10};
    private Integer[] arrsizeBoolean = {0, 10};
    private Integer[] arrsizeByte = {0, 10};
    private Integer[] arrsizeCharacter = {0, 10};
    private Integer[] arrsizeDate = {0, 10};
    private Integer[] arrsizeDouble = {0, 10};
    private Integer[] arrsizeFloat = {0, 10};
    private Integer[] arrsizeInteger = {0, 10};
    private Integer[] arrsizeLong = {0, 10};
    private Integer[] arrsizeShort = {0, 10};
    private Integer[] arrsizeString = {0, 10};

    public JmockdataConfig() {
        this.readConfig("config_default.properties");
        Calendar cld = Calendar.getInstance();
        this.setRangeDateY(new Integer[] {cld.get(Calendar.YEAR), cld.get(Calendar.YEAR)});
    }

    public void readConfig(String classpath) {
        try {

            File file = ResourceUtil.getFile("classpath:" + classpath);
            Properties prop = new Properties();
            prop.load(new FileInputStream(file));
            if (prop != null && prop.size() > 0) {
                String key = null, value = null;
                for (Map.Entry en : prop.entrySet()) {
                    if (en.getKey() != null && en.getValue() != null) {
                        key = en.getKey().toString();
                        value = en.getValue().toString();
                        Object fValueObj = getValue(key);
                        if (key.startsWith("arrsize")
                                || key.startsWith("rangeDate")
                                || key.startsWith("rangeInteger")
                                ) {
                            Integer[] values = StringUtil.splitInteger(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Integer[]) fValueObj)[0] = values[0];
                                        ((Integer[]) fValueObj)[1] = values[0];
                                    } else if (values.length == 2) {
                                        ((Integer[]) fValueObj)[0] = values[0];
                                        ((Integer[]) fValueObj)[1] = values[1];
                                    }
                                }

                            }
                        } else if (key.startsWith("seedCharacter")) {
                            Character[] values = StringUtil.splitCharacter(value, "\\s+");
                            if (values != null) {
                                setValue(key, values);
                            }
                        } else if (key.startsWith("seedString")) {
                            String[] values = StringUtil.splitString(value, "\\s+");
                            if (values != null) {
                                setValue(key, values);
                            }
                        } else if (key.startsWith("rangeDouble")) {
                            Double[] values = StringUtil.splitDouble(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Double[]) fValueObj)[0] = values[0];
                                        ((Double[]) fValueObj)[1] = values[0];
                                    } else if (values.length == 2) {
                                        ((Double[]) fValueObj)[0] = values[0];
                                        ((Double[]) fValueObj)[1] = values[1];
                                    }
                                }
                            }
                        } else if (key.startsWith("rangeFloat")) {
                            Float[] values = StringUtil.splitFloat(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Float[]) fValueObj)[0] = values[0];
                                        ((Float[]) fValueObj)[1] = values[0];
                                    } else if (values.length == 2) {
                                        ((Float[]) fValueObj)[0] = values[0];
                                        ((Float[]) fValueObj)[1] = values[1];
                                    }
                                }
                            }
                        } else if (key.startsWith("rangeLong")) {
                            Long[] values = StringUtil.splitLong(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Long[]) fValueObj)[0] = values[0];
                                        ((Long[]) fValueObj)[1] = values[0];
                                    } else if (values.length == 2) {
                                        ((Long[]) fValueObj)[0] = values[0];
                                        ((Long[]) fValueObj)[1] = values[1];
                                    }
                                }
                            }
                        } else if (key.startsWith("rangeShort")) {
                            Short[] values = StringUtil.splitShort(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Short[]) fValueObj)[0] = values[0];
                                        ((Short[]) fValueObj)[1] = values[0];
                                    } else if (values.length == 2) {
                                        ((Short[]) fValueObj)[0] = values[0];
                                        ((Short[]) fValueObj)[1] = values[1];
                                    }
                                }
                            }
                        } else if (key.startsWith("rangeBoolean")) {
                            String[] values = StringUtil.splitString(value, ",");
                            if (values != null) {
                                if (fValueObj != null) {
                                    if (values.length == 1) {
                                        ((Boolean[]) fValueObj)[0] = Boolean.parseBoolean(values[0]);
                                        ((Boolean[]) fValueObj)[1] = Boolean.parseBoolean(values[0]);
                                    } else if (values.length == 2) {
                                        ((Boolean[]) fValueObj)[0] = Boolean.parseBoolean(values[0]);
                                        ((Boolean[]) fValueObj)[1] = Boolean.parseBoolean(values[1]);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void setValue(String fieldName, Object value) {
        Class configClazz = this.getClass();
        try {
            Field field = configClazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private Object getValue(String fieldName) {
        Class configClazz = this.getClass();
        try {
            Field field = configClazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public Character[] getSeedCharacter() {
        return seedCharacter;
    }

    public void setSeedCharacter(Character[] seedCharacter) {
        this.seedCharacter = seedCharacter;
    }

    public String[] getSeedString() {
        return seedString;
    }

    public void setSeedString(String[] seedString) {
        this.seedString = seedString;
    }

    public Short[] getRangeShort() {
        return rangeShort;
    }

    public void setRangeShort(Short[] rangeShort) {
        this.rangeShort = rangeShort;
    }

    public Integer[] getRangeInteger() {
        return rangeInteger;
    }

    public void setRangeInteger(Integer[] rangeInteger) {
        this.rangeInteger = rangeInteger;
    }

    public Double[] getRangeDouble() {
        return rangeDouble;
    }

    public void setRangeDouble(Double[] rangeDouble) {
        this.rangeDouble = rangeDouble;
    }

    public Float[] getRangeFloat() {
        return rangeFloat;
    }

    public void setRangeFloat(Float[] rangeFloat) {
        this.rangeFloat = rangeFloat;
    }

    public Long[] getRangeLong() {
        return rangeLong;
    }

    public void setRangeLong(Long[] rangeLong) {
        this.rangeLong = rangeLong;
    }

    public Integer[] getRangeDateY() {
        return rangeDateY;
    }

    public void setRangeDateY(Integer[] rangeDateY) {
        this.rangeDateY = rangeDateY;
    }

    public Integer[] getRangeDateM() {
        return rangeDateM;
    }

    public void setRangeDateM(Integer[] rangeDateM) {
        this.rangeDateM = rangeDateM;
    }

    public Integer[] getRangeDateD() {
        return rangeDateD;
    }

    public void setRangeDateD(Integer[] rangeDateD) {
        this.rangeDateD = rangeDateD;
    }

    public Integer[] getRangeDateH() {
        return rangeDateH;
    }

    public void setRangeDateH(Integer[] rangeDateH) {
        this.rangeDateH = rangeDateH;
    }

    public Integer[] getRangeDateMi() {
        return rangeDateMi;
    }

    public void setRangeDateMi(Integer[] rangeDateMi) {
        this.rangeDateMi = rangeDateMi;
    }

    public Integer[] getRangeDateS() {
        return rangeDateS;
    }

    public void setRangeDateS(Integer[] rangeDateS) {
        this.rangeDateS = rangeDateS;
    }

    public Boolean[] getRangeBoolean() {
        return rangeBoolean;
    }

    public void setRangeBoolean(Boolean[] rangeBoolean) {
        this.rangeBoolean = rangeBoolean;
    }

    public Integer[] getArrsizeBean() {
        return arrsizeBean;
    }

    public void setArrsizeBean(Integer[] arrsizeBean) {
        this.arrsizeBean = arrsizeBean;
    }

    public Integer[] getArrsizeBigdecimal() {
        return arrsizeBigdecimal;
    }

    public void setArrsizeBigdecimal(Integer[] arrsizeBigdecimal) {
        this.arrsizeBigdecimal = arrsizeBigdecimal;
    }

    public Integer[] getArrsizeBiginteger() {
        return arrsizeBiginteger;
    }

    public void setArrsizeBiginteger(Integer[] arrsizeBiginteger) {
        this.arrsizeBiginteger = arrsizeBiginteger;
    }

    public Integer[] getArrsizeBoolean() {
        return arrsizeBoolean;
    }

    public void setArrsizeBoolean(Integer[] arrsizeBoolean) {
        this.arrsizeBoolean = arrsizeBoolean;
    }

    public Integer[] getArrsizeByte() {
        return arrsizeByte;
    }

    public void setArrsizeByte(Integer[] arrsizeByte) {
        this.arrsizeByte = arrsizeByte;
    }

    public Integer[] getArrsizeCharacter() {
        return arrsizeCharacter;
    }

    public void setArrsizeCharacter(Integer[] arrsizeCharacter) {
        this.arrsizeCharacter = arrsizeCharacter;
    }

    public Integer[] getArrsizeDate() {
        return arrsizeDate;
    }

    public void setArrsizeDate(Integer[] arrsizeDate) {
        this.arrsizeDate = arrsizeDate;
    }

    public Integer[] getArrsizeDouble() {
        return arrsizeDouble;
    }

    public void setArrsizeDouble(Integer[] arrsizeDouble) {
        this.arrsizeDouble = arrsizeDouble;
    }

    public Integer[] getArrsizeFloat() {
        return arrsizeFloat;
    }

    public void setArrsizeFloat(Integer[] arrsizeFloat) {
        this.arrsizeFloat = arrsizeFloat;
    }

    public Integer[] getArrsizeInteger() {
        return arrsizeInteger;
    }

    public void setArrsizeInteger(Integer[] arrsizeInteger) {
        this.arrsizeInteger = arrsizeInteger;
    }

    public Integer[] getArrsizeLong() {
        return arrsizeLong;
    }

    public void setArrsizeLong(Integer[] arrsizeLong) {
        this.arrsizeLong = arrsizeLong;
    }

    public Integer[] getArrsizeShort() {
        return arrsizeShort;
    }

    public void setArrsizeShort(Integer[] arrsizeShort) {
        this.arrsizeShort = arrsizeShort;
    }

    public Integer[] getArrsizeString() {
        return arrsizeString;
    }

    public void setArrsizeString(Integer[] arrsizeString) {
        this.arrsizeString = arrsizeString;
    }
}
