package com.company.project.service;
import com.company.project.model.PermissionInfo;
import com.company.project.core.Service;
import com.company.project.vo.PermissionInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface PermissionInfoService extends Service<PermissionInfo> {

    List<PermissionInfoVo> getPermissionInfoVoList(Integer querySelect);
}
