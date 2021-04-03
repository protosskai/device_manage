package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.DeviceScrapMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceScrap;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceScrapService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
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
public class DeviceScrapServiceImpl extends AbstractService<DeviceScrap> implements DeviceScrapService {
    @Resource
    private DeviceScrapMapper deviceScrapMapper;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;

    @Override
    public List<DeviceScrapInfoVo> getScrapInfoVoList(int querySelected) {
        List<DeviceScrapInfoVo> res = new ArrayList<>();
        List<DeviceBasicInfo> basicInfos = deviceBasicInfoService.findAll();
        for (DeviceBasicInfo basicInfo : basicInfos) {
            int deviceId = basicInfo.getId();
            String deviceName = basicInfo.getDeviceName();
            int isScraped = basicInfo.getIsScraped();
            String scrapUser = "";
            String scrapTime = "";
            String detail = "";
            if (isScraped == 1) {
                DeviceScrap deviceScrap = this.findBy("deviceId", deviceId);
                Preconditions.checkNotNull(deviceScrap, "给定的设备ID[" + deviceId + "]不存在相应的设备");
                User user = userService.findById(deviceScrap.getScrapUserId());
                Preconditions.checkNotNull(user, "给定的用户ID[" + deviceScrap.getScrapUserId() + "]不存在相应的用户");
                scrapUser = user.getUserName();
                scrapTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deviceScrap.getScrapTime());
                detail = deviceScrap.getDetail();
            }
            DeviceScrapInfoVo scrapInfoVo = new DeviceScrapInfoVo();
            scrapInfoVo.setDeviceId(deviceId);
            scrapInfoVo.setDeviceName(deviceName);
            scrapInfoVo.setScrapTime(scrapTime);
            scrapInfoVo.setScrapUser(scrapUser);
            scrapInfoVo.setDetail(detail);
            scrapInfoVo.setIsScraped(isScraped);
            if (querySelected == 0) {
                res.add(scrapInfoVo);
            } else if (querySelected == 1) {
                if (isScraped == 1) {
                    res.add(scrapInfoVo);
                }
            } else {
                if (isScraped == 0) {
                    res.add(scrapInfoVo);
                }
            }
        }
        return res;
    }

    @Override
    public Result startScrapDevice(Integer userId, Integer deviceId) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo == null)
            return ResultGenerator.genFailResult("设备不存在！");
        if (deviceBasicInfo.getIsScraped() == 1)
            return ResultGenerator.genFailResult("当前设备已报废");
        User user = userService.findById(userId);
        if (user == null)
            return ResultGenerator.genFailResult("用户不存在！");
        deviceBasicInfo.setIsScraped(1);
        deviceBasicInfoService.update(deviceBasicInfo);
        DeviceScrap deviceScrap = new DeviceScrap();
        deviceScrap.setDeviceId(deviceId);
        deviceScrap.setScrapUserId(userId);
        this.save(deviceScrap);
        return ResultGenerator.genSuccessResult();
    }
}
