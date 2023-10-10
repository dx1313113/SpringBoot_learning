package com.whgcdx.demo1.controller;

import com.whgcdx.demo1.dao.SysUserDao;
import com.whgcdx.demo1.domain.user.SysUserInsertDTO;
import com.whgcdx.demo1.service.impl.SysUserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.controller
 * @className: SysUserController
 * @author: dx
 * @description: TODO
 * @date: 2023/10/10 15:00
 * @version: 1.0
 */

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sysUserService;

    @PostMapping("/insert")
    public boolean insertSysUser(@RequestBody SysUserInsertDTO userInsertDTO){
        sysUserService.insertSysUser(userInsertDTO);
        return true;
    }
}
