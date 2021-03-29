package com.company.project.service;
import com.company.project.model.RoleInfo;
import com.company.project.core.Service;
import com.company.project.vo.RoleInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface RoleInfoService extends Service<RoleInfo> {

    List<RoleInfoVo> getRoleInfoVoList(Integer querySelect);

    void addRole(RoleInfoVo roleInfo);
}
