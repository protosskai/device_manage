package com.company.project.service.impl;

import com.company.project.dao.DeviceMaintainMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceMaintain;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceMaintainService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceMaintainInfoVo;
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
public class DeviceMaintainServiceImpl extends AbstractService<DeviceMaintain> implements DeviceMaintainService {
    @Resource
    private DeviceMaintainMapper deviceMaintainMapper;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;
    @Resource
    private DeviceMaintainService deviceMaintainService;

    @Override
    public DeviceMaintainInfoVo getDeviceMaintainVo(DeviceMaintain maintain) {
        DeviceMaintainInfoVo infoVo = new DeviceMaintainInfoVo();
        infoVo.setDeviceId(maintain.getDeviceId());
        DeviceBasicInfo basicInfo = deviceBasicInfoService.findById(maintain.getDeviceId());
        Preconditions.checkNotNull(basicInfo, "给定的设备ID[" + maintain.getDeviceId().toString() + "]不存在相应的设备");
        infoVo.setDeviceName(basicInfo.getDeviceName());
        User maintainUser = userService.findById(maintain.getMaintainUserId());
        Preconditions.checkNotNull(maintainUser, "给定的用户ID[" + maintain.getMaintainUserId().toString() + "]不存在相应的用户");
        infoVo.setMaintainOwner(maintainUser.getUserName());
        infoVo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(maintain.getStartTime()));
        infoVo.setFinishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(maintain.getFinishTime()));
        infoVo.setStatus(maintain.getStatus());
        return infoVo;
    }

    @Override
    public List<DeviceMaintainInfoVo> getMaintainList(Integer querySelect) {
        List<DeviceBasicInfo> basicInfos = deviceBasicInfoService.findAll();
        List<DeviceMaintainInfoVo> res = new ArrayList<>();
        for (DeviceBasicInfo basicInfo : basicInfos) {
            int deviceId = basicInfo.getId();
            String deviceName = basicInfo.getDeviceName();
            int isMaintain = basicInfo.getIsMaintain();
            String maintainOwner = "";
            String startTime = "";
            String finishedTime = "";
            String status = "";
            if (isMaintain == 1) {
                DeviceMaintain deviceMaintain = deviceMaintainService.findBy("deviceId", deviceId);
                Preconditions.checkNotNull(deviceMaintain, "给定的设备ID[" + deviceId + "]不存在相应的设备");
                User user = userService.findById(deviceMaintain.getMaintainUserId());
                Preconditions.checkNotNull(user, "给定的用户ID[" + deviceMaintain.getMaintainUserId() + "]不存在相应的用户");
                maintainOwner = user.getUserName();
                startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceMaintain.getStartTime());
                finishedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceMaintain.getFinishTime());
                status = deviceMaintain.getStatus();
            }
            DeviceMaintainInfoVo maintainInfoVo = new DeviceMaintainInfoVo();
            maintainInfoVo.setDeviceId(deviceId);
            maintainInfoVo.setDeviceName(deviceName);
            maintainInfoVo.setMaintainOwner(maintainOwner);
            maintainInfoVo.setStartTime(startTime);
            maintainInfoVo.setFinishedTime(finishedTime);
            maintainInfoVo.setStatus(status);
            if (querySelect == 0) {
                res.add(maintainInfoVo);
            } else if (querySelect == 1) {
                if (isMaintain == 1) {
                    res.add(maintainInfoVo);
                }
            } else {
                if (isMaintain == 0) {
                    res.add(maintainInfoVo);
                }
            }

        }
        return res;
    }
}
