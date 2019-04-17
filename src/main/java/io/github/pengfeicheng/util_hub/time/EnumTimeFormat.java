package io.github.pengfeicheng.util_hub.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 时间格式枚举类
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/10 11:46 AM
 * @Version: 1.0
 */
public enum EnumTimeFormat {

    /**
     * 标准时间 示例：2019-04-01 12:32:12
     */
    FORMAT_STANDARD("yyyy-MM-dd HH:mm:ss"),

    /**
     * 标准时间 示例：2019-04-01 09:12
     */
    FORMAT_yyMMddHHmm("yyyy-MM-dd HH:mm"),

    /**
     * 时间戳 示例：20190401123212
     */
    FORMAT_STAMP("yyyyMMddHHmmss"),

    /**
     * 日期 示例：2019-04-01
     */
    FORMAT_DATE("yyyy-MM-dd"),

    /**
     * 日期 示例：04-01
     */
    FORMAT_Md("MM-dd"),

    /**
     * 示例：04-01 12:32
     */
    FORMAT_MMddHHmm("MM-dd HH:mm"),

    /**
     * 示例：04月01日 12:32
     */
    FORMAT_MMDDHHMM_CN("MM月dd日 HH:mm"),

    /**
     * 示例：04月01日
     */
    FORMAT_Hm_CN("MM月dd日"),

    /**
     * 示例 12:32
     */
    FORMAT_HHmm("HH:mm"),

    /**
     * 日期 示例：2019年04月01日
     */
    FORMAT_yMd_CN("yyyy年MM月dd日"),

    /**
     * 日期 示例：2019/04/01
     */
    FORMAT_yMd("yyyy/MM/dd"),

    /**
     * 日期 示例：2019/04/01 12:34:24
     */
    FORMAT_yMdHHmmSS("yyyy/MM/dd HH:mm:ss");

    private SimpleDateFormat format;

    EnumTimeFormat(String format) {
        this.format = new SimpleDateFormat(format);
    }

    public SimpleDateFormat getValue(){
        return format;
    }

    /**
     * 时间转化到指定时间类型枚举
     * @param time
     * @return
     */
    public EnumTimeFormat parseValue(String time){

        Date date = null;
        for(EnumTimeFormat f : EnumTimeFormat.values()){

            try{
                date = f.getValue().parse(time);
                return f;
            }catch (Exception e){}

            if(null != date) break;
        }
        return null;
    }
}
