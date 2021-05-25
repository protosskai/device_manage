package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.User;
import com.company.project.core.Service;
import com.company.project.vo.UserInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface UserService extends Service<User> {

    List<UserInfoVo> getUserInfoVoList(Integer querySelect);

    Result addUser(UserInfoVo userInfoVo);

    int queryIdByName(String userName);
    int queryIdByAlias(String userName);
}
