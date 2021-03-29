package com.company.project.service.impl;

import com.company.project.dao.SysTokenMapper;
import com.company.project.model.SysToken;
import com.company.project.model.User;
import com.company.project.service.SysTokenService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.utils.TokenGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by CodeGenerator on 2021/03/18.
 */
@Service
@Transactional
public class SysTokenServiceImpl extends AbstractService<SysToken> implements SysTokenService {
    @Resource
    private SysTokenMapper sysTokenMapper;
    @Resource
    private UserService userService;

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>();
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        SysToken tokenEntity = this.findBy("userId", userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            this.update(tokenEntity);
        }
        result.put("token", token);
        result.put("expire", EXPIRE);
        return result;
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return this.findBy("token", accessToken);

    }

    @Override
    public User findByUserId(Integer userId) {
        return userService.findById(userId);
    }
}
