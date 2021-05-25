package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.UserLocationMapper;
import com.company.project.model.User;
import com.company.project.model.UserLocation;
import com.company.project.service.UserLocationService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.UserLocationVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/05/24.
 */
@Service
@Transactional
public class UserLocationServiceImpl extends AbstractService<UserLocation> implements UserLocationService {
    @Resource
    private UserLocationMapper userLocationMapper;
    @Resource
    private UserService userService;

    @Override
    public Result updateUserLocation(UserLocationVo userLocationVo) {
        UserLocation userLocation = this.findBy("userId", userLocationVo.getUserId());
        if (userLocation != null) {
            // 更新
            userLocation.setLatitude(userLocationVo.getLatitude());
            userLocation.setLongitude(userLocationVo.getLongitude());
            userLocation.setUpdateTime(new Date());
            this.update(userLocation);
        } else {
            // 新建
            userLocation = new UserLocation();
            userLocation.setUserId(userLocationVo.getUserId());
            userLocation.setLatitude(userLocationVo.getLatitude());
            userLocation.setLongitude(userLocationVo.getLongitude());
            userLocation.setUpdateTime(new Date());
            this.save(userLocation);
        }
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result queryCurrentUser() {
        List<UserLocation> userLocations = this.findAll();
        List<UserLocationVo> result = new LinkedList<>();
        //当前时间
        Date now = new Date();
        int EXPIRE = 60;    // 一分钟
        //过期时间
        Date startTime = new Date(now.getTime() - EXPIRE * 1000);
        Date endTime = new Date(now.getTime() + EXPIRE * 1000);
        for (UserLocation userLocation : userLocations) {
            Date updateTime = userLocation.getUpdateTime();
            if (updateTime.after(startTime) && updateTime.before(endTime)) {
                UserLocationVo userLocationVo = new UserLocationVo();
                userLocationVo.setUserId(userLocation.getUserId());
                User user = userService.findById(userLocation.getUserId());
                userLocationVo.setUserName(user.getUserName());
                userLocationVo.setLatitude(userLocation.getLatitude());
                userLocationVo.setLongitude(userLocation.getLongitude());
                result.add(userLocationVo);
            }
        }
        return ResultGenerator.genSuccessResult(result);
    }
}
