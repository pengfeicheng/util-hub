package io.github.pengfeicheng.util_hub.time;


import java.security.InvalidParameterException;
import java.util.Calendar;
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

    /**
     * 计算两个日期相差天数，结果说明如下：
     * 正数 A 表示：日期 start 比 日期 end 早 A 天；
     * 负数 B 表示：日期 start 比 日期 end 晚 A 天；
     * @param start 开始日期
     * @param end   结束日期
     * @return
     * @throws InvalidParameterException
     */
    public static long dateDiffByDays(String start, String end) throws InvalidParameterException {

        Date _startDate = format(start);
        Date _endDate = format(end);
        if(null == _startDate || null == _endDate){
            throw new InvalidParameterException(String.format("start:%s end:%s invalid params",start,end));
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(_endDate);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        long _endTime = calendar.getTimeInMillis();

        calendar.setTime(_startDate);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        long _startTime = calendar.getTimeInMillis();

        long diff =  _endTime - _startTime;
        return diff/(24*3600*1000);
    }


    /**
     * 通过 Calendar 的 set(int filed,int value) 方法更新指定的 Date 对象
     * @param date
     * @param filed
     * @param value
     * @return
     */
    public static Date setDateByCalendarFiled(Date date,int filed,int value){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(filed,value);
        return calendar.getTime();
    }

    /**
     * 通过 Calendar 的 add(int filed,int value) 方法更新指定的 Date 对象
     * @param date
     * @param filed
     * @param value
     * @return
     */
    public static Date addDateByCalendarFiled(Date date,int filed,int value){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(filed,value);
        return calendar.getTime();
    }


    /**
     * 格式化时间至指定格式显示
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, EnumTimeFormat format){
        if(null == date || null == format) return "";
        return format.getValue().format(date);
    }
}
