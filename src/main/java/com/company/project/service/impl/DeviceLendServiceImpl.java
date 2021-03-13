package com.company.project.service.impl;

import com.company.project.dao.DeviceLendMapper;
import com.company.project.model.DeviceLend;
import com.company.project.service.DeviceLendService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceLendServiceImpl extends AbstractService<DeviceLend> implements DeviceLendService {
    @Resource
    private DeviceLendMapper deviceLendMapper;

}
