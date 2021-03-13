package com.company.project.service.impl;

import com.company.project.dao.PermissionInfoMapper;
import com.company.project.model.PermissionInfo;
import com.company.project.service.PermissionInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class PermissionInfoServiceImpl extends AbstractService<PermissionInfo> implements PermissionInfoService {
    @Resource
    private PermissionInfoMapper permissionInfoMapper;

}
