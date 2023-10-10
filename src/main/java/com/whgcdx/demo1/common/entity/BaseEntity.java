package com.whgcdx.demo1.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

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
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    protected Long id;
    @TableField(fill = FieldFill.INSERT)
    protected Date createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date updatedAt;
    @TableLogic
    protected Boolean  deletedAt;
}
