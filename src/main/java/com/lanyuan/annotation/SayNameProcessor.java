package com.lanyuan.annotation;

import java.lang.reflect.Method;

/**
 * Created by ln on 2017/1/12.
 */
public class SayNameProcessor {

    public static void process(String clazz) throws ClassNotFoundException{

        for(Method m:Class.forName(clazz).getMethods()){
            if(m.isAnnotationPresent(SayName.class)){
                try{
                    SayName temp =   m.getAnnotation(SayName.class);
                    System.out.println(m.getName()+"名字是："+temp.name());
                }
                catch (Exception e){

                }
            }
        }

    }
}
