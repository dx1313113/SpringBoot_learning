package com.whgcdx.demo1.service;

import com.whgcdx.demo1.domain.user.SysUserInsertDTO;
import com.whgcdx.demo1.entity.SysUserEntity;
import org.springframework.stereotype.Service;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.service
 * @className: SysUserService
 * @author: dx
 * @description: TODO
 * @date: 2023/10/10 15:03
 * @version: 1.0
 */

public interface SysUserService {
    public boolean insertSysUser(SysUserInsertDTO userInsertDTO);
}
