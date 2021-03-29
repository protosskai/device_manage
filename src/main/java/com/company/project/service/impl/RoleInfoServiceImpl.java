package com.company.project.service.impl;

import com.company.project.dao.RoleInfoMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.RoleInfo;
import com.company.project.service.RoleInfoService;
import com.company.project.core.AbstractService;
import com.company.project.vo.RoleInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class RoleInfoServiceImpl extends AbstractService<RoleInfo> implements RoleInfoService {
    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Override
    public List<RoleInfoVo> getRoleInfoVoList(Integer querySelect) {
        List<RoleInfoVo> res = new ArrayList<>();
        List<RoleInfo> roleInfos = this.findAll();
        for (RoleInfo roleInfo : roleInfos) {
            int id = roleInfo.getId();
            String roleName = roleInfo.getRoleName();
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roleInfo.getCreateTime());
            RoleInfoVo infoVo = new RoleInfoVo();
            infoVo.setId(id);
            infoVo.setRoleName(roleName);
            infoVo.setCreateTime(createTime);
            res.add(infoVo);
        }
        return res;
    }

    @Override
    public void addRole(RoleInfoVo roleInfoVo) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName(roleInfoVo.getRoleName());
        this.save(roleInfo);
    }
}
