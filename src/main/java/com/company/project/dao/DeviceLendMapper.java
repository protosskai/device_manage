package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DeviceLend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceLendMapper extends Mapper<DeviceLend> {
    public DeviceLend selectByUserIdAndDeviceId(@Param("userId") int userId, @Param("deviceId") int deviceId);

    List<DeviceLend> selectsByUserIdAndDeviceId(@Param("userId") int userId, @Param("deviceId") int deviceId);

    DeviceLend selectByDeviceId(@Param("deviceId") Integer deviceId);
}