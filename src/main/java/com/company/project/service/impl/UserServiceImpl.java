package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.UserMapper;
import com.company.project.model.LaboratoryInfo;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;
import com.company.project.vo.LabInfoVo;
import com.company.project.vo.UserInfoVo;
import com.google.common.base.Preconditions;
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
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserInfoVo> getUserInfoVoList(Integer querySelect) {
        List<User> users = this.findAll();
        List<UserInfoVo> res = new ArrayList<>();
        for (User user : users) {
            int id = user.getId();
            String userAlias = user.getUserAlias();
            String role = user.getRole();
            int sex = user.getSex();
            String phone = user.getPhone();
            String wechat = user.getWechat();
            String qq = user.getQq();
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreateTime());
            UserInfoVo infoVo = new UserInfoVo();
            infoVo.setId(id);
            infoVo.setUserAlias(userAlias);
            infoVo.setSex(sex);
            infoVo.setRole(role);
            infoVo.setPhone(phone);
            infoVo.setQq(qq);
            infoVo.setWechat(wechat);
            infoVo.setCreateTime(createTime);
            res.add(infoVo);
        }
        return res;
    }

    @Override
    public Result addUser(UserInfoVo userInfoVo) {
        User user = this.findBy("userName", userInfoVo.getUserName());
        if (user != null) {
            return ResultGenerator.genFailResult("用户名已存在！");
        }
        user = new User();
        user.setUserName(userInfoVo.getUserName());
        user.setRole(userInfoVo.getRole());
        user.setPassword(userInfoVo.getPassword());
        user.setUserAlias(userInfoVo.getUserAlias());
        user.setPhone(userInfoVo.getPhone());
        user.setSex(userInfoVo.getSex());
        user.setWechat(userInfoVo.getWechat());
        user.setQq(userInfoVo.getQq());
        this.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public int queryIdByName(String userName) {
        User user = this.findBy("userName", userName);
        if (user == null)
            return -1;
        return user.getId();
    }

    @Override
    public int queryIdByAlias(String userName) {
        User user = this.findBy("userAlias", userName);
        if (user == null)
            return -1;
        return user.getId();
    }
}
