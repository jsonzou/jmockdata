
package com.github.jsonzou.jmockdata.utils;

import java.util.regex.Pattern;

/**
 * Created by jsonzou on 2016/12/19.
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        return str == null || str.length()==0;
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    public static boolean isNumber(String num){
        if(isEmpty(num)){
            return false;
        }
        if(Pattern.matches("-?\\d+\\.?\\d*",num)){
            return true;
        }
        return false;
    }
    public static double ifNumberToDoubleElseDefault(String num,double defaultNum){
        if(isNumber(num)){
            return Double.parseDouble(num);
        }else{
            return defaultNum;
        }
    }

    public static String firstLetterToUpperCase(String str){
        if(isNotEmpty(str)){
            return str.substring(0,1).toUpperCase().concat(str.substring(1));
        }else{
            return str;
        }
    }
}
