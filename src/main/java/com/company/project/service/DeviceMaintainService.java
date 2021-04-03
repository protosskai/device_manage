package com.company.project.service;

import com.company.project.core.Result;
import com.company.project.model.DeviceMaintain;
import com.company.project.core.Service;
import com.company.project.vo.DeviceMaintainInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceMaintainService extends Service<DeviceMaintain> {
    public DeviceMaintainInfoVo getDeviceMaintainVo(DeviceMaintain deviceMaintain);

    public List<DeviceMaintainInfoVo> getMaintainList(Integer querySelect);

    public Result startMaintainDevice(Integer userId, Integer deviceId);

    public Result stopMaintainDevice(Integer userId, Integer deviceId);
}
