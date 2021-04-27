package com.company.project.service;

import com.company.project.core.Result;
import com.company.project.model.LaboratoryLocation;
import com.company.project.core.Service;
import com.company.project.vo.LaboratoryLocationVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/04/08.
 */
public interface LaboratoryLocationService extends Service<LaboratoryLocation> {

    public Result addLaboratoryLocation(LaboratoryLocationVo laboratoryLocationVo);

    List<LaboratoryLocationVo> findAllVo();
}
