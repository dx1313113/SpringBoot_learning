package com.whgcdx.demo1.service.impl;

import com.whgcdx.demo1.dao.SysUserDao;
import com.whgcdx.demo1.domain.user.SysUserInsertDTO;
import com.whgcdx.demo1.entity.SysUserEntity;
import com.whgcdx.demo1.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.service.impl
 * @className: SysUserServiceImpl
 * @author: dx
 * @description: TODO
 * @date: 2023/10/10 15:25
 * @version: 1.0
 */

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public boolean insertSysUser( SysUserInsertDTO userInsertDTO) {
        SysUserEntity userEntity = new SysUserEntity();
//        将 DTO 数据复制到 Entity
        BeanUtils.copyProperties(userInsertDTO , userEntity);
        sysUserDao.insert(userEntity);
        return true;
    }
}
