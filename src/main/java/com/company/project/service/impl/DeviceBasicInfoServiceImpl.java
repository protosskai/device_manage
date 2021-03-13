package com.company.project.service.impl;

import com.company.project.dao.DeviceBasicInfoMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceBasicInfoServiceImpl extends AbstractService<DeviceBasicInfo> implements DeviceBasicInfoService {
    @Resource
    private DeviceBasicInfoMapper deviceBasicInfoMapper;

}
