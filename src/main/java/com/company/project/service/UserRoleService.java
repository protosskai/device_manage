package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.UserRole;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2021/03/31.
 */
public interface UserRoleService extends Service<UserRole> {

    public Result queryUserRole(Integer userId);

}
