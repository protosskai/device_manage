package com.company.project.service.impl;

import com.company.project.dao.LaboratoryInfoMapper;
import com.company.project.model.LaboratoryInfo;
import com.company.project.service.LaboratoryInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class LaboratoryInfoServiceImpl extends AbstractService<LaboratoryInfo> implements LaboratoryInfoService {
    @Resource
    private LaboratoryInfoMapper laboratoryInfoMapper;

}
