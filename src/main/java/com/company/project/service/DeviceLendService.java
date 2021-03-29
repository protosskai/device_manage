package com.company.project.service;

import com.company.project.model.DeviceLend;
import com.company.project.core.Service;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceScrapInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceLendService extends Service<DeviceLend> {


    List<DeviceLendInfoVo> getLendInfoVoList(Integer querySelect);

    Boolean checkUserIdAndDeviceId(Integer userId, Integer deviceId);

    Boolean checkDeviceAvailable(Integer deviceId);

    DeviceLend findByUserIdAndDeviceId(Integer userId, Integer deviceId);

    Boolean updateDeviceInfoLend(int deviceId, int status);


}
