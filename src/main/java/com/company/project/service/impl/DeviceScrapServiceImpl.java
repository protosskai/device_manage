package com.company.project.service.impl;

import com.company.project.dao.DeviceScrapMapper;
import com.company.project.model.DeviceScrap;
import com.company.project.service.DeviceScrapService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceScrapServiceImpl extends AbstractService<DeviceScrap> implements DeviceScrapService {
    @Resource
    private DeviceScrapMapper deviceScrapMapper;

}
