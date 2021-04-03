package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainMapper extends Mapper<DeviceMaintain> {

    public List<DeviceMaintain> selectByDeviceIdAndUserId(@Param("deviceId") Integer deviceId, @Param("userId") Integer userId);

    public DeviceMaintain selectByDeviceId(@Param("deviceId") Integer deviceId);
}