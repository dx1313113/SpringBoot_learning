package com.whgcdx.demo1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whgcdx.demo1.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.entity
 * @className: SysUserEntity
 * @author: dx
 * @description: TODO
 * @date: 2023/10/8 21:36
 * @version: 1.0
 */

@Data
@TableName("sys_user")
public class SysUserEntity extends BaseEntity implements Serializable {

    private String userName;

    private String realName;

    private String pwd;

    private Integer mobile;

    private String email;

    private String salt;

}
