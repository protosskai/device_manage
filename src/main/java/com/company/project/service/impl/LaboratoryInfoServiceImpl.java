package com.company.project.service.impl;

import com.company.project.dao.LaboratoryInfoMapper;
import com.company.project.model.LaboratoryInfo;
import com.company.project.model.User;
import com.company.project.service.LaboratoryInfoService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.LabInfoVo;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class LaboratoryInfoServiceImpl extends AbstractService<LaboratoryInfo> implements LaboratoryInfoService {
    @Resource
    private LaboratoryInfoMapper laboratoryInfoMapper;
    @Resource
    private UserService userService;

    @Override
    public List<LabInfoVo> getLabInfoVoList(Integer querySelected) {
        List<LaboratoryInfo> laboratoryInfos = this.findAll();
        List<LabInfoVo> res = new ArrayList<>();
        for (LaboratoryInfo laboratoryInfo : laboratoryInfos) {
            if (laboratoryInfo.getIsDeleted() == 1)
                continue;
            int id = laboratoryInfo.getId();
            String labName = laboratoryInfo.getLabName();
            String principalUser = "";
            String region = laboratoryInfo.getRegion();
            String detail = laboratoryInfo.getDetail();
            User user = userService.findById(laboratoryInfo.getPrincipalUserId());
            Preconditions.checkNotNull(user, "给定的用户ID[" + laboratoryInfo.getPrincipalUserId() + "]不存在相应的用户");
            principalUser = user.getUserName();
            LabInfoVo infoVo = new LabInfoVo();
            infoVo.setId(id);
            infoVo.setLabName(labName);
            infoVo.setPrincipalUser(principalUser);
            infoVo.setRegion(region);
            infoVo.setDetail(detail);
            res.add(infoVo);
        }
        return res;
    }
}
