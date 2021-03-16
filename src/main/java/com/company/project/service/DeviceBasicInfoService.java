package com.company.project.service;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.core.Service;
import com.company.project.vo.DeviceInfoVo;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceBasicInfoService extends Service<DeviceBasicInfo> {
    public DeviceBasicInfo addDevice(DeviceInfoVo deviceInfoVo);
}
