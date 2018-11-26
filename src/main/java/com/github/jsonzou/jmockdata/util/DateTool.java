package com.github.jsonzou.jmockdata.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author: jsonzou
 * @Date: 2018/11/1 21:22
 * @Description:
 */
public class DateTool {
   public enum DatePattern{
        yyyy_MM_dd(Pattern.compile("\\d{4}-\\d{2}-\\d{2}"),"yyyy-MM-dd"),
        yyyy_MM_dd__HH$mm$ss(Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"),"yyyy-MM-dd HH:mm:ss"),
        yyyylMMldd(Pattern.compile("\\d{4}/\\d{2}/\\d{2}"),"yyyy/MM/dd"),
        yyyylMMlddHH__$mm$ss(Pattern.compile("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}"),"yyyy/MM/dd HH:mm:ss"),
        yyyyMMdd(Pattern.compile("\\d{8}"),"yyyyMMdd"),
        yyyyMMddHHmmss(Pattern.compile("\\d{14}"),"yyyyMMddHHmmss");
        private Pattern regx;
        private String format;



        DatePattern(Pattern regx, String format) {
            this.regx=regx;
            this.format=format;
        }

        public Pattern getRegx() {
            return regx;
        }

        public void setRegx(Pattern regx) {
            this.regx = regx;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }

    /**
     * 日期字符串+日期字符串日期格式 转换为日期对象
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date getString2Date(String dateStr,String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateStr);
    }

    /**
     * 日期字符串自动转换为日期对象
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getString2DateAuto(String dateStr) throws ParseException {
        String dateFormat = getDateFormat(dateStr);
        return getString2Date(dateStr,dateFormat);
    }

    /**
     * 自动适配日期字符串的日期格式描述符
     * @param dateStr
     * @return
     */
    public static String getDateFormat(String dateStr){
        for (DatePattern dt:DatePattern.values()){
            if(dt.getRegx().matcher(dateStr).matches()){
                return dt.getFormat();
            }
        }
        return null;
    }
}
