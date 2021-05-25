package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.LaboratoryInfo;
import com.company.project.core.Service;
import com.company.project.vo.LabInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface LaboratoryInfoService extends Service<LaboratoryInfo> {

    List<LabInfoVo> getLabInfoVoList(Integer querySelected);

    Result addLab(LabInfoVo labInfoVo);
}
