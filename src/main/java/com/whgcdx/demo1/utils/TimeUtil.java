package com.whgcdx.demo1.utils;

import java.text.SimpleDateFormat;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.utils
 * @className: timeUtil
 * @author: dx
 * @description: TODO 时间日期相关工具类
 * @date: 2023/10/7 16:19
 * @version: 1.0
 */
public class TimeUtil {

    private long currentTime;

    public TimeUtil() {
        this.currentTime = System.currentTimeMillis();
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }


    public String format() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return formatter.format(currentTime);
    }
}
