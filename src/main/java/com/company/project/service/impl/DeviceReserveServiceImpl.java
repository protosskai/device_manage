package com.company.project.service.impl;

import com.company.project.dao.DeviceReserveMapper;
import com.company.project.model.DeviceReserve;
import com.company.project.service.DeviceReserveService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceReserveServiceImpl extends AbstractService<DeviceReserve> implements DeviceReserveService {
    @Resource
    private DeviceReserveMapper deviceReserveMapper;

}
