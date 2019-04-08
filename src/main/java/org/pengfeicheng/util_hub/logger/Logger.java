package org.pengfeicheng.util_hub.logger;

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
     * Debug
     * @param var
     */
    public void debug(String var){
        String message = String.format("%s %s[D]:%s",timeDateFormat.format(new Date()),tag,var);
        System.out.println(message);
    }

    /**
     * Error
     * @param var
     */
    public void error(String var){
        String message = String.format("%s %s[E]:%s",timeDateFormat.format(new Date()),tag,var);
        System.out.println(message);
    }
}
