package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.LaboratoryLocationMapper;
import com.company.project.model.LaboratoryInfo;
import com.company.project.model.LaboratoryLocation;
import com.company.project.service.LaboratoryInfoService;
import com.company.project.service.LaboratoryLocationService;
import com.company.project.core.AbstractService;
import com.company.project.vo.LaboratoryLocationVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/04/08.
 */
@Service
@Transactional
public class LaboratoryLocationServiceImpl extends AbstractService<LaboratoryLocation> implements LaboratoryLocationService {
    @Resource
    private LaboratoryLocationMapper laboratoryLocationMapper;
    @Resource
    private LaboratoryInfoService laboratoryInfoService;

    @Override
    public Result addLaboratoryLocation(LaboratoryLocationVo laboratoryLocationVo) {
        LaboratoryInfo laboratoryInfo = laboratoryInfoService.findBy("labName", laboratoryLocationVo.getLabName());
        if (laboratoryInfo == null)
            return ResultGenerator.genFailResult("实验室名称不存在 ！");
        LaboratoryLocation laboratoryLocation = this.findBy("labId", laboratoryInfo.getId());
        if (laboratoryLocation == null) {
            laboratoryLocation = new LaboratoryLocation();
            laboratoryLocation.setLabId(laboratoryInfo.getId());
            laboratoryLocation.setLongitude(laboratoryLocationVo.getLongitude());
            laboratoryLocation.setLatitude(laboratoryLocationVo.getLatitude());
            this.save(laboratoryLocation);
        } else {
            laboratoryLocation.setLongitude(laboratoryLocationVo.getLongitude());
            laboratoryLocation.setLatitude(laboratoryLocationVo.getLatitude());
            this.update(laboratoryLocation);
        }
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public List<LaboratoryLocationVo> findAllVo() {
        List<LaboratoryLocation> tmp = this.findAll();
        List<LaboratoryLocationVo> res = new LinkedList<>();
        for (LaboratoryLocation l : tmp) {
            int labId = l.getLabId();
            LaboratoryInfo info = laboratoryInfoService.findById(labId);
            LaboratoryLocationVo locationVo = new LaboratoryLocationVo();
            locationVo.setLabName(info.getLabName());
            locationVo.setLatitude(l.getLatitude());
            locationVo.setLongitude(l.getLongitude());
            res.add(locationVo);
        }
        return res;
    }
}
