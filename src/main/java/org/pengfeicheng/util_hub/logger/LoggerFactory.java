package org.pengfeicheng.util_hub.logger;

/**
 * @Description: Logger 工厂类
 * @Author: ChengPengFei
 * @CreateDate: 2019/1/29 5:17 PM
 * @Version: 1.0
 */
public class LoggerFactory {

    public static Logger getLogger(Class<?> clazz){
        return new Logger(clazz.getSimpleName());
    }
}
