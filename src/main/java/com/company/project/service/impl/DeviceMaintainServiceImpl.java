package com.company.project.service.impl;

import com.company.project.dao.DeviceMaintainMapper;
import com.company.project.model.DeviceMaintain;
import com.company.project.service.DeviceMaintainService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceMaintainServiceImpl extends AbstractService<DeviceMaintain> implements DeviceMaintainService {
    @Resource
    private DeviceMaintainMapper deviceMaintainMapper;

}
