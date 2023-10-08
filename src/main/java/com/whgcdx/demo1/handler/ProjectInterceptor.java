package com.whgcdx.demo1.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.handler
 * @className: ProjectInterceptor
 * @author: dx
 * @description: TODO 拦截器 开发ing
 * @date: 2023/10/7 13:58
 * @version: 1.0
 */

/*多个拦截器的执行顺序 pre1 - pre2 -pre3 -  controller  - post3 - post2 - post1 - after3 - after2 - after1 */
/* 当 pre return true after 必定执行，当 pre return false post就不会执行，after执行情况看其对应的 pre 是否执行*/

@Component
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}


