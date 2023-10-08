package com.whgcdx.demo1.config.aspectj;

import cn.hutool.http.Header;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.config.aspectj
 * @className: AopLog
 * @author: dx
 * @description: TODO 用于请求的日志处理
 * @date: 2023/10/7 15:25
 * @version: 1.0
 */

@Aspect
@Slf4j
@Component
@Order(0)
public class AopLog {

    private static final String START_TIME = "request-start";
    /**
    *切入点
    * */
    @Pointcut("execution( * com.whgcdx.demo1.controller..*Controller.*(..))")
    public void log(){}


    /***
     * 前置操作
     */
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        //利用 RequestContextHolder 获取 HttpServletRequest 对象
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        UserAgent userAgent = UserAgentUtil.parse(httpServletRequest.getHeader(Header.USER_AGENT.toString()));

        //重组请求信息
        StringBuffer sb = new StringBuffer();
        sb.append("---------------------------------收到请求-------------------------------------------");
        sb.append("\r\n【浏览器类型】: " + userAgent.getBrowser() + " 【版本号】: " + userAgent.getVersion());
        sb.append("\r\n【user-agent】: " + httpServletRequest.getHeader(Header.USER_AGENT.toString()));
        sb.append("\r\n【访问URL】: " + httpServletRequest.getRequestURI());
        sb.append("\r\n【访问Method】: " + httpServletRequest.getMethod());
        sb.append("\r\n【访问IP】: " + httpServletRequest.getRemoteAddr());

        Map<String ,String[]> paramerMap = httpServletRequest.getParameterMap();
        sb.append("\r\n【请求参数】: " + paramerMap);

        log.info(sb.toString());

        httpServletRequest.setAttribute(START_TIME,System.currentTimeMillis());
    }

    /**
     * 环绕操作
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        log.info("【返回值】：{}", JSON.toJSONString(result));
        return result;
    }

    /***
     *
     */
    @After("log()")
    public void afterLog(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Long start= (Long) request.getAttribute(START_TIME);
        Long end=System.currentTimeMillis();
        log.info("【请求耗时】：{}ms",end-start);

        String header=request.getHeader(Header.USER_AGENT.toString());
        UserAgent userAgent=UserAgentUtil.parse(header);
        log.info("【操作系统】：{}，【原始User-Agent】：{}",
                userAgent.getOs().toString(),
                header);
    }


}
