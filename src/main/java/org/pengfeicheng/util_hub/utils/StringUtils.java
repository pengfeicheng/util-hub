package org.pengfeicheng.util_hub.utils;

/**
 * @Description: 字符串工具类
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/3 3:39 PM
 * @Version: 1.0
 */
public final class StringUtils {

    private StringUtils() { }

    /**
     * 判断传入字符串是否为空
     * @param str
     * @return true：传入的字符串为 Null 或者长度为 0
     */
    public static boolean isEmpty(String str){
        return null == str || str.length() < 1;
    }

    /**
     * 截取字符串
     * @param str 待处理的字符串
     * @param maxLength 最大长芦
     * @param suffix 超过最大长度时添加的后缀
     * @return
     */
    public static String cut(String str,int maxLength,String suffix){
        if(isEmpty(str) || str.length() <= maxLength || maxLength < 0) return str;
        if(maxLength < 1) return "";
        String temp = str.substring(0,maxLength);
        if(isEmpty(suffix) || suffix.length() > maxLength){
            return temp;
        }

        temp = str.substring(0,maxLength - suffix.length());
        temp += suffix;
        return temp;
    }
}
