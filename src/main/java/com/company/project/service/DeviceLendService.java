package com.company.project.service;

import com.company.project.model.DeviceLend;
import com.company.project.core.Service;
import com.company.project.vo.DeviceLendInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/04/27.
 */
public interface DeviceLendService extends Service<DeviceLend> {

    List<DeviceLendInfoVo> getLendInfoVoList(Integer querySelect);

    Boolean checkUserIdAndDeviceId(Integer userId, Integer deviceId);

    Boolean checkDeviceAvailable(Integer deviceId);

    DeviceLend findByUserIdAndDeviceId(Integer userId, Integer deviceId);

    Boolean updateDeviceInfoLend(int deviceId, int status);

}
