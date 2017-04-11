package com.github.jsonzou.jmockdata.utils;

import java.util.regex.Pattern;

/**
 * Created by jsonzou on 2016/12/19.
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNumber(String num) {
        if (isEmpty(num)) {
            return false;
        }
        if (Pattern.matches("-?\\d+\\.?\\d*", num)) {
            return true;
        }
        return false;
    }

    public static double ifNumberToDoubleElseDefault(String num, double defaultNum) {
        if (isNumber(num)) {
            return Double.parseDouble(num);
        } else {
            return defaultNum;
        }
    }

    public static String firstLetterToUpperCase(String str) {
        if (isNotEmpty(str)) {
            return str.substring(0, 1).toUpperCase().concat(str.substring(1));
        } else {
            return str;
        }
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0; // our position in the old string
        int index = inString.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));
        // remember to append any characters to the right of a match
        return sb.toString();
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static String[] splitString(String str, String regex) {
        if (isEmpty(str)) {
            return null;
        }
        return str.split(regex);
    }

    public static Integer[] splitInteger(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Integer[] arr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i].trim());
        }
        return arr;
    }

    public static Double[] splitDouble(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Double[] arr = new Double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Double.parseDouble(strArr[i].trim());
        }
        return arr;
    }

    public static Long[] splitLong(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Long[] arr = new Long[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Long.parseLong(strArr[i].trim());
        }
        return arr;
    }

    public static Float[] splitFloat(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Float[] arr = new Float[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Float.parseFloat(strArr[i].trim());
        }
        return arr;
    }

    public static Character[] splitCharacter(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Character[] arr = new Character[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = strArr[i].trim().charAt(0);
        }
        return arr;
    }

    public static Short[] splitShort(String str, String regex) {
        String[] strArr = splitString(str, regex);
        if (strArr == null) {
            return null;
        }
        Short[] arr = new Short[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Short.parseShort(strArr[i].trim());
        }
        return arr;
    }


}
