package io.github.pengfeicheng.util_hub.log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 日志记录工具类
 * @Author: ChengPengFei
 * @CreateDate: 2019/1/29 5:12 PM
 * @Version: 1.0
 */
public final class Logger {

    private String tag;
    private SimpleDateFormat timeDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    protected Logger(String tag){
        this.tag = tag;
    }

    /**
     * 获取一个实例对象
     * @param clazz 当前类
     * @return
     */
    public static Logger getInstance(Class<?> clazz){
        return new Logger(clazz.getSimpleName());
    }


    /**
     * Debug
     * @param var
     */
    public void debug(String var){
        String message = String.format("%s %s[D]:%s",timeDateFormat.format(new Date()),tag,var);
        System.out.println(message);
    }

    /**
     * Debug
     * @param var
     */
    public void debugs(Object... var){
        String message = String.format("%s %s[D]:%s",timeDateFormat.format(new Date()),tag,_convertToString(var));
        System.out.println(message);
    }


    /**
     * Error
     * @param var
     */
    public void error(String var){
        String message = String.format("%s %s[E]:%s",timeDateFormat.format(new Date()),tag,var);
        System.err.println(message);
    }

    /**
     * Error
     * @param var
     */
    public void errors(Object... var){
        String message = String.format("%s %s[E]:%s",timeDateFormat.format(new Date()),tag,_convertToString(var));
        System.err.println(message);
    }

    /**
     * 将对象数组转换到字符串
     * @param params
     * @return
     */
    private static StringBuffer _convertToString(Object... params){
        StringBuffer buffer = new StringBuffer();
        for(Object obj : params)
        {
            buffer.append(obj);
            buffer.append(" ");
        }
        return buffer;
    }
}
