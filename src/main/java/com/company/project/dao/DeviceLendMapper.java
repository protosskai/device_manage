package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DeviceLend;
import org.apache.ibatis.annotations.Param;

public interface DeviceLendMapper extends Mapper<DeviceLend> {

    public DeviceLend selectByUserIdAndDeviceId(@Param("userId") int userId, @Param("deviceId") int deviceId);
}