package io.github.pengfeicheng.util_hub.utils;

import io.github.pengfeicheng.util_hub.log.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/10 10:59 AM
 * @Version: 1.0
 */
public class ReflectUtils {

    private static Logger logger = Logger.getInstance(ReflectUtils.class);

    /**
     * 获取指定对象中的属性
     * @param obj 待引用的对象
     * @param fieldName 属性名称
     * @return 属性
     */
    public static Field getField(Object obj, String fieldName){
        try{
            return obj.getClass().getDeclaredField(fieldName);
        }catch (NoSuchFieldException e){
            logger.errors(obj.getClass().getName(),"no field",fieldName);
            return null;
        }
    }


    /**
     * 获取指定对象中的属性
     * @param obj 待引用的对象
     * @return 属性
     */
    public static Field[] getFields(Object obj){
        try{
            return obj.getClass().getDeclaredFields();
        }catch (SecurityException e){
            logger.errors(obj.getClass().getName() , " getFields failed'");
            return null;
        }
    }


    /**
     * 获取指定对象中的方法
     * @param obj
     * @param methodName
     * @return 如果不存在对应名称的方法，则返回 null
     */
    public static Method getMethod(Object obj, String methodName){
        try{
            return obj.getClass().getMethod(methodName);
        }catch (NoSuchMethodException e){
            logger.errors(obj.getClass().getName(),"no method",methodName);
            return null;
        }
    }

    /**
     * 引用对象指定方法
     * @param obj 待引用的对象
     * @param method 待引用的方法
     * @param args 待传入的参数
     * @return 执行结果
     */
    public static Object invoke(Object obj,Method method,Object... args){
        try{
            method.setAccessible(true);
            return method.invoke(obj,args);
        }catch (InvocationTargetException e){
            logger.errors(obj.getClass().getName(),"invoke InvocationTargetException",e.getMessage());
        }catch (IllegalAccessException e){
            logger.errors(obj.getClass().getName(),"invoke IllegalAccessException",e.getMessage());
        }
        return null;
    }

    /**
     * 引用对象指定方法
     * @param obj 待引用的对象
     * @param methodName 待引用的方法
     * @param args 待传入的参数
     * @return 执行结果
     */
    public static Object invoke(Object obj,String methodName,Object... args){
        Method method = getMethod(obj,methodName);
        if(null != method){
            return invoke(obj,method,args);
        }
        return null;
    }


    /**
     * 反射获取指定对象的属性
     * @param field
     * @param object
     * @return
     */
    public static Object get(Field field,Object object){

        try{
            field.setAccessible(true);
            Object obj = field.get(object);
            return obj;
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射设置指定对象的属性
     * @param field
     * @param object
     * @return
     */
    public static void set(Field field,Object object,Object newBinder){

        try{
            field.setAccessible(true);
            field.set(object,newBinder);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
