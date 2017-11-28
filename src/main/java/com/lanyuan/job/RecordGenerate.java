package com.lanyuan.job;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lanyuan 2014-11-19
 * @version 3.0v
 * @Email: mmm333zzz520@163.com
 */

public class RecordGenerate implements ServletContextListener{


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            System.out.println("监听器启动成功！");
            Thread spcommThread = new Thread(new SPComm());
            spcommThread.setName("Thread-MyThread");
            spcommThread.start();
        } catch (Exception e) {
            System.out.println("监听器启动失败！");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}