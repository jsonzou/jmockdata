package com.github.jsonzou.jmockdata.util;

/**
 * @Auther: jsonzou
 * @Date: 2019/3/15 15:10
 * @Description:
 */
public class StringUtils {
    /**
     *  The String Is Empty Or Null Will Be Return False,Else Return True.
     * @param str
     * @return boolean
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    /**
     *  The String Is Empty Or Null Will Be Return True,Else Return False.
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str){
        return str==null || str.length()==0;
    }
}
