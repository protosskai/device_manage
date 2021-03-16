package com.company.project.service.impl;

import com.company.project.dao.DeviceBasicInfoMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
@Service
@Transactional
public class DeviceBasicInfoServiceImpl extends AbstractService<DeviceBasicInfo> implements DeviceBasicInfoService {
    @Resource
    private DeviceBasicInfoMapper deviceBasicInfoMapper;
    @Resource
    private UserService userService;

    @Override
    public DeviceBasicInfo addDevice(DeviceInfoVo deviceInfoVo) {
        DeviceBasicInfo deviceBasicInfo = new DeviceBasicInfo();
        deviceBasicInfo.setDeviceName(deviceInfoVo.getDeviceName());
        deviceBasicInfo.setIsMaintain(deviceInfoVo.getIsMaintain());
        deviceBasicInfo.setIsScraped(deviceInfoVo.getIsScraped());
        deviceBasicInfo.setDetail(deviceInfoVo.getDetail());
        User user = userService.findBy("userName", deviceInfoVo.getPrincipalUser());
        if (user != null) {
            deviceBasicInfo.setPrincipalUserId(user.getId());
        }
        String uuid = UUID.randomUUID().toString();
        deviceBasicInfo.setUuid(uuid);
        this.save(deviceBasicInfo);
        return deviceBasicInfo;
    }
}