package com.company.project.service;

import com.company.project.model.SysToken;
import com.company.project.core.Service;
import com.company.project.model.User;

import java.util.Map;


/**
 * Created by CodeGenerator on 2021/03/18.
 */
public interface SysTokenService extends Service<SysToken> {
    SysToken findByToken(String accessToken);

    public User findByUserId(Integer userId);

    Map<String, Object> createToken(Integer userId);


}
