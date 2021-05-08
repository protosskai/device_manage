package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.DeviceReserveMapper;
import com.company.project.model.*;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceReserveService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserRoleService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceReverseInfoVo;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceReserveServiceImpl extends AbstractService<DeviceReserve> implements DeviceReserveService {
    @Resource
    private DeviceReserveMapper deviceReserveMapper;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public List<DeviceReverseInfoVo> getReverseInfoVoList(Integer querySelected) {
        List<DeviceReverseInfoVo> res = new ArrayList<>();
        List<DeviceBasicInfo> basicInfos = deviceBasicInfoService.findAll();
        for (DeviceBasicInfo basicInfo : basicInfos) {
            int deviceId = basicInfo.getId();
            String deviceName = basicInfo.getDeviceName();
            int isReverse = basicInfo.getIsReverse();
            String reserveUser = "";
            String reserveTime = "";
            String expectReturnTime = "";
            String detail = "";
            if (isReverse == 1) {
                DeviceReserve deviceReserve = this.findBy("deviceId", deviceId);
                Preconditions.checkNotNull(deviceReserve, "给定的设备ID[" + deviceId + "]不存在相应的设备");
                User user = userService.findById(deviceReserve.getReserveUserId());
                Preconditions.checkNotNull(user, "给定的用户ID[" + deviceReserve.getReserveUserId() + "]不存在相应的用户");
                reserveUser = user.getUserName();
                reserveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceReserve.getReserveTime());
                expectReturnTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceReserve.getExpectReturnTime());
                detail = deviceReserve.getDetail();
            }
            DeviceReverseInfoVo reverseInfoVo = new DeviceReverseInfoVo();
            reverseInfoVo.setDeviceId(deviceId);
            reverseInfoVo.setDeviceName(deviceName);
            reverseInfoVo.setReserveTime(reserveTime);
            reverseInfoVo.setReserveUser(reserveUser);
            reverseInfoVo.setExpectReturnTime(expectReturnTime);
            reverseInfoVo.setDetail(detail);
            reverseInfoVo.setIsReverse(isReverse);
            if (querySelected == 0) {
                res.add(reverseInfoVo);
            } else if (querySelected == 1) {
                if (isReverse == 1) {
                    res.add(reverseInfoVo);
                }
            } else {
                if (isReverse == 0) {
                    res.add(reverseInfoVo);
                }
            }
        }
        return res;
    }

    @Override
    public Result startReverseDevice(Integer userId, Integer deviceId, Date date) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo == null)
            return ResultGenerator.genFailResult("设备不存在！");
        if (deviceBasicInfo.getIsReverse() == 1)
            return ResultGenerator.genFailResult("当前设备正处于预约状态");
        User user = userService.findById(userId);
        if (user == null)
            return ResultGenerator.genFailResult("用户不存在！");
        deviceBasicInfo.setIsReverse(1);
        deviceBasicInfoService.update(deviceBasicInfo);
        DeviceReserve deviceReserve = new DeviceReserve();
        deviceReserve.setDeviceId(deviceId);
        deviceReserve.setReserveUserId(userId);
        deviceReserve.setDetail("");
        if (date != null) {
            deviceReserve.setReserveTime(date);
        }
        this.save(deviceReserve);
        return ResultGenerator.genSuccessResult();
    }


    @Override
    public Result stopReverseDevice(Integer userId, Integer deviceId) {
        UserRole userRole = userRoleService.findBy("userId", userId);
        if (userRole.getRoleId() == 1) {
            DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
            if (deviceBasicInfo == null)
                return ResultGenerator.genFailResult("设备不存在！");
            if (deviceBasicInfo.getIsReverse() == 0)
                return ResultGenerator.genFailResult("当前设备尚未被预约");
            deviceBasicInfo.setIsReverse(0);
            deviceBasicInfoService.update(deviceBasicInfo);
            deviceReserveMapper.deleteByDeviceId(deviceId);
            return ResultGenerator.genSuccessResult();
        } else {
            DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
            if (deviceBasicInfo == null)
                return ResultGenerator.genFailResult("设备不存在！");
            if (deviceBasicInfo.getIsReverse() == 0)
                return ResultGenerator.genFailResult("当前设备尚未被预约");
            User user = userService.findById(userId);
            if (user == null)
                return ResultGenerator.genFailResult("用户不存在！");
            deviceBasicInfo.setIsReverse(0);
            deviceBasicInfoService.update(deviceBasicInfo);
            deviceReserveMapper.deleteByDeviceId(deviceId);
            return ResultGenerator.genSuccessResult();
        }
    }
}
