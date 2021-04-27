package com.company.project.service.impl;

import com.company.project.dao.DeviceLendMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceLend;
import com.company.project.model.DeviceScrap;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceLendService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceScrapInfoVo;
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
public class DeviceLendServiceImpl extends AbstractService<DeviceLend> implements DeviceLendService {
    @Resource
    private DeviceLendMapper deviceLendMapper;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;


    @Override
    public List<DeviceLendInfoVo> getLendInfoVoList(Integer querySelected) {
        List<DeviceLendInfoVo> res = new ArrayList<>();
        List<DeviceBasicInfo> basicInfos = deviceBasicInfoService.findAll();
        for (DeviceBasicInfo basicInfo : basicInfos) {
            int deviceId = basicInfo.getId();
            String deviceName = basicInfo.getDeviceName();
            int isLended = basicInfo.getIsLended();
            String lendUser = "";
            String lendTime = "";
            String detail = "";
            if (isLended == 1) {
//                DeviceLend deviceLend = this.findBy("deviceId", deviceId);
                DeviceLend deviceLend = deviceLendMapper.selectByDeviceId(deviceId);
                Preconditions.checkNotNull(deviceLend, "给定的设备ID[" + deviceId + "]不存在相应的设备");
                User user = userService.findById(deviceLend.getLendUserId());
                Preconditions.checkNotNull(user, "给定的用户ID[" + deviceLend.getLendUserId() + "]不存在相应的用户");
                lendUser = user.getUserName();
                lendTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceLend.getLendTime());
                detail = deviceLend.getDetail();
            }
            DeviceLendInfoVo lendInfoVo = new DeviceLendInfoVo();
            lendInfoVo.setDeviceId(deviceId);
            lendInfoVo.setDeviceName(deviceName);
            lendInfoVo.setLendTime(lendTime);
            lendInfoVo.setLendUser(lendUser);
            lendInfoVo.setDetail(detail);
            lendInfoVo.setIsLended(isLended);
            if (querySelected == 0) {
                res.add(lendInfoVo);
            } else if (querySelected == 1) {
                if (isLended == 1) {
                    res.add(lendInfoVo);
                }
            } else {
                if (isLended == 0) {
                    res.add(lendInfoVo);
                }
            }
        }
        return res;
    }

    @Override
    public Boolean checkUserIdAndDeviceId(Integer userId, Integer deviceId) {
        User user = userService.findById(userId);
        if (user == null)
            return false;
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo == null)
            return false;
        return true;
    }

    @Override
    public Boolean checkDeviceAvailable(Integer deviceId) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo.getIsLended() == 1)
            return false;
        return true;
    }

    @Override
    public DeviceLend findByUserIdAndDeviceId(Integer userId, Integer deviceId) {
        return deviceLendMapper.selectByUserIdAndDeviceId(userId, deviceId);
    }

    @Override
    public Boolean updateDeviceInfoLend(int deviceId, int status) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo == null)
            return false;
        deviceBasicInfo.setIsLended(status);
        deviceBasicInfoService.update(deviceBasicInfo);
        return true;
    }
}
