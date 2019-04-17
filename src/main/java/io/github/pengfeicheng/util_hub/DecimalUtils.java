package io.github.pengfeicheng.util_hub;

import java.math.BigDecimal;

/**
 * @Description: 精确运算辅助类，精确到小数点后两位
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/3 4:01 PM
 * @Version: 1.0
 */
public class DecimalUtils {

    /**
     * 加，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double add(double a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.add(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 加，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double add(long a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.add(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 加，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double add(String a,String b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.add(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 减，默认是精确到小数后两位
     * @param a 被减数
     * @param b 减数
     * @return 精确到小数点后两位的 double 数
     */
    public static double subtract(double a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.subtract(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 减，默认是精确到小数后两位
     * @param a 被减数
     * @param b 减数
     * @return 精确到小数点后两位的 double 数
     */
    public static BigDecimal subtract(String a,String b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.subtract(numberB).setScale(2);
        return result.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 减，默认是精确到小数后两位
     * @param a 被减数
     * @param b 减数
     * @return 精确到小数点后两位的 double 数
     */
    public static double subtract(double a,long b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.subtract(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 减，默认是精确到小数后两位
     * @param a 被减数
     * @param b 减数
     * @return 精确到小数点后两位的 double 数
     */
    public static double subtract(long a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.subtract(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(long a,long b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(int a,int b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(String a,String b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(long a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(Double.toString(b));
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(double a,long b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 除，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double divide(double a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(Double.toString(b));
        BigDecimal result = numberA.divide(numberB,2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    /**
     * 乘，默认是精确到小数后两位
     * @param a
     * @param b
     * @return 精确到小数点后两位的 double 数
     */
    public static double multiply(long a,double b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(Double.toString(b));
        BigDecimal result = numberA.multiply(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 乘，默认是精确到小数后两位
     * @param a
     * @param b
     * @return 精确到小数点后两位的 double 数
     */
    public static double multiply(double a,double b){
        BigDecimal numberA = new BigDecimal(Double.toString(a));
        BigDecimal numberB = new BigDecimal(Double.toString(b));
        BigDecimal result = numberA.multiply(numberB).setScale(2);
        return result.doubleValue();
    }

    /**
     * 乘，默认是精确到小数后两位
     * @param a 被除数
     * @param b 除数
     * @return 精确到小数点后两位的 double 数
     */
    public static double multiply(String a,String b){
        BigDecimal numberA = new BigDecimal(a);
        BigDecimal numberB = new BigDecimal(b);
        BigDecimal result = numberA.multiply(numberB).setScale(2);
        return result.doubleValue();
    }


    /**
     * 将字符串转换到 Long
     * @param s
     * @return
     */
    public static long parseLong(String s){
        try{
            return Long.parseLong(s);
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 将字符串转换到 Int
     * @param s
     * @return
     */
    public static int parseInt(String s){
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 将字符串转换到 Double
     * @param s
     * @return
     */
    public static double parseDouble(String s){
        try{
            return Double.parseDouble(s);
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 将字符串转换到 Float
     * @param s
     * @return
     */
    public static float parseFloat(String s){
        try{
            return Float.parseFloat(s);
        }catch (Exception e){
            return 0;
        }
    }
}
