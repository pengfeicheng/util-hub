package io.github.pengfeicheng.util_hub;

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
     * 判断指定的字段不为空
     *
     * @param str
     * @return true -> 该字段不为空;false -> 为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
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

    /**
     * 字符串内容比较
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equal(String s1, String s2) {
        if (null == s1 && null == s2) return true;
        if (null == s1 && null != s2) return false;
        if (null != s1 && null == s2) return false;
        return s1.equals(s2);
    }

    /**
     * byte数组输出到十六制字符串
     *
     * @param data
     * @return
     */
    public static String byte2Hex(byte[] data) {
        StringBuffer buffer = new StringBuffer();
        if (null != data) {
            for (byte b : data) {
                int temp = b & 0xff;
                String ch = Integer.toHexString(temp);
                if (ch.length() < 2)
                    ch = "0" + ch;
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    /**
     * 十六制字符串到byte数组
     *
     * @param data
     * @return
     */
    public static byte[] hex2Byte(String data) {
        if (null == data || data.length() == 0 || data.length() % 2 != 0) {
            return new byte[0];
        }
        byte[] result = new byte[data.length() / 2];
        char[] source = data.toCharArray();
        for (int i = 0; i < source.length; i += 2) {
            String num = source[i] + "" + source[i + 1];
            int temp = Integer.parseInt(num, 16);
            result[i / 2] = (byte) (temp & 0xff);
        }
        return result;
    }
}
