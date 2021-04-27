package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.UserRoleMapper;
import com.company.project.model.UserRole;
import com.company.project.service.UserRoleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/31.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Result queryUserRole(Integer userId) {
        return null;
    }
}
