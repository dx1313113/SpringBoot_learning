package com.whgcdx.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whgcdx.demo1.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.dao
 * @className: SysUserDao
 * @author: dx
 * @description: TODO
 * @date: 2023/10/10 15:34
 * @version: 1.0
 */

@Mapper
public interface SysUserDao  extends BaseMapper<SysUserEntity> {

}
