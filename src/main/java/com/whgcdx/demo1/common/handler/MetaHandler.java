package com.whgcdx.demo1.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.handler
 * @className: MyBatisObjectHandler
 * @author: dx
 * @description: TODO 用于处理全局公共填充字段
 * @date: 2023/10/10 20:40
 * @version: 1.0
 */
@Slf4j
@Component//记得加到容器
public class MetaHandler implements MetaObjectHandler {

    //插入时的填充出的略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("star insert fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createdAt",new Date(),metaObject);
    }
    //更新时填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("star update fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("updatedAt",new Date(),metaObject);
    }

    public static MetaHandler of() {
        return new MetaHandler();
    }
}