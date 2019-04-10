package io.github.pengfeicheng.util_hub.time;


import java.util.Date;

/**
 * @Description:
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/10 11:45 AM
 * @Version: 1.0
 */
public class TimeUtils {

    /**
     * 获取当前时间
     * @param format 指定时间格式
     * @return
     */
    public static String getTime(EnumTimeFormat format){
        Date date = new Date();
        return format.getValue().format(date);
    }


    /**
     * 格式化时间
     * @param time
     * @param format
     * @return
     */
    public static String format(long time, EnumTimeFormat format){
        Date date = new Date();
        date.setTime(time);
        return format.getValue().format(date);
    }


    /**
     * 时间字符串转化日期对象
     * @param time
     * @return
     */
    public static Date format(String time){
        Date date = null;
        for(EnumTimeFormat f : EnumTimeFormat.values()){
            try{
                date = f.getValue().parse(time);
            }catch (Exception e){ }

            if(null != date) break;
        }
        return date;
    }


    /**
     * 格式化时间到指定的格式
     * @param time
     * @param format 指定的时间格式
     * @return
     */
    public static String format(String time,EnumTimeFormat format){
        Date date = null;
        for(EnumTimeFormat f : EnumTimeFormat.values()){
            try{
                date = f.getValue().parse(time);
            }catch (Exception e){
                break;
            }
            if(null != date) break;
        }

        if(null == date) return "";
        return format.getValue().format(date);
    }
}
