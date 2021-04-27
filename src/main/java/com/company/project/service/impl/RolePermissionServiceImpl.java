package com.company.project.service.impl;

import com.company.project.dao.RolePermissionMapper;
import com.company.project.model.RolePermission;
import com.company.project.service.RolePermissionService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/31.
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;

}
