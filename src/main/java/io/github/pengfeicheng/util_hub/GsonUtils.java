package io.github.pengfeicheng.util_hub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description:
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/11 5:53 PM
 * @Version: 1.0
 */
public class GsonUtils {

    public static Gson gson = new Gson();

    /**
     * 将 Json 对象转换到字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        return gson.toJson(object);
    }

    /**
     * 格式打印
     * @param object
     * @return
     */
    public static String toJsonPretty(Object object){
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }
}
