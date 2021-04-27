package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DeviceReserve;
import org.apache.ibatis.annotations.Param;

public interface DeviceReserveMapper extends Mapper<DeviceReserve> {

    void deleteByUserIdAndDeviceId(@Param("userId") Integer userId, @Param("deviceId") Integer deviceId);
}