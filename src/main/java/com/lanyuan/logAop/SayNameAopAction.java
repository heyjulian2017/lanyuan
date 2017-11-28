package com.lanyuan.logAop;

import com.lanyuan.annotation.SayName;
import com.lanyuan.annotation.SystemLog;
import com.lanyuan.entity.LogFormMap;
import com.lanyuan.mapper.LogMapper;
import com.lanyuan.util.Common;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 切点类
 * @author LJN
 * @since 2015-05-05 Pm 20:35
 * @version 1.0
 */
@Aspect
@Component
public  class SayNameAopAction {

	@Pointcut("@annotation(com.lanyuan.annotation.SayName)")
	public  void controllerAspect() {
	}

	@Before("controllerAspect()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知 : " + joinPoint.getSignature().getName());
	}
}
