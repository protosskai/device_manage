package com.company.project.service.impl;

import com.company.project.dao.PermissionInfoMapper;
import com.company.project.model.PermissionInfo;
import com.company.project.service.PermissionInfoService;
import com.company.project.core.AbstractService;
import com.company.project.vo.PermissionInfoVo;
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
public class PermissionInfoServiceImpl extends AbstractService<PermissionInfo> implements PermissionInfoService {
    @Resource
    private PermissionInfoMapper permissionInfoMapper;

    @Override
    public List<PermissionInfoVo> getPermissionInfoVoList(Integer querySelect) {
        List<PermissionInfoVo> res = new ArrayList<>();
        List<PermissionInfo> permissionInfos = this.findAll();
        for (PermissionInfo permissionInfo : permissionInfos) {
            int id = permissionInfo.getId();
            String permissionName = permissionInfo.getPermissionName();
            String moduleName = permissionInfo.getModuleName();
            String path = permissionInfo.getPath();
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(permissionInfo.getCreateTime());
            PermissionInfoVo infoVo = new PermissionInfoVo();
            infoVo.setId(id);
            infoVo.setPermissionName(permissionName);
            infoVo.setModuleName(moduleName);
            infoVo.setPath(path);
            infoVo.setCreateTime(createTime);
            res.add(infoVo);
        }
        return res;
    }
}
