package com.company.project.service;

import com.company.project.core.Result;
import com.company.project.model.DeviceMaintain;
import com.company.project.core.Service;
import com.company.project.vo.DeviceMaintainInfoVo;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceMaintainService extends Service<DeviceMaintain> {
    public DeviceMaintainInfoVo getDeviceMaintainVo(DeviceMaintain deviceMaintain);

    public List<DeviceMaintainInfoVo> getMaintainList(Integer querySelect);

    public Result startMaintainDevice(Integer userId, Integer deviceId, Date startDate, Date endDate);

    public Result stopMaintainDevice(Integer userId, Integer deviceId);
}
