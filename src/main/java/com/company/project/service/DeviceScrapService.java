package com.company.project.service;

import com.company.project.core.Result;
import com.company.project.model.DeviceScrap;
import com.company.project.core.Service;
import com.company.project.vo.DeviceScrapInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceScrapService extends Service<DeviceScrap> {
    public List<DeviceScrapInfoVo> getScrapInfoVoList(int querySelected);

    Result startScrapDevice(Integer userId, Integer deviceId);
    Result stopScrapDevice(Integer userId, Integer deviceId);
}
