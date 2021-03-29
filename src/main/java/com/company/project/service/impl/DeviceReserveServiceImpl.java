package com.company.project.service.impl;

import com.company.project.dao.DeviceReserveMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceLend;
import com.company.project.model.DeviceReserve;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceReserveService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceReverseInfoVo;
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
public class DeviceReserveServiceImpl extends AbstractService<DeviceReserve> implements DeviceReserveService {
    @Resource
    private DeviceReserveMapper deviceReserveMapper;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;

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
}
