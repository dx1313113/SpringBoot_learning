package com.whgcdx.demo1.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.common.entity
 * @className: BaseEntity
 * @author: dx
 * @description: TODO
 * @date: 2023/10/8 22:16
 * @version: 1.0
 */

@Data
public class BaseEntity {

    @TableId
    protected Long id;

    protected Integer createAt;

    protected Integer updateAt;

    protected Integer deleteAt;
}
