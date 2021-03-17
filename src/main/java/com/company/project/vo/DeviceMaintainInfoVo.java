package com.company.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DeviceMaintainInfoVo {
    private int deviceId;
    private String deviceName;
    private String maintainOwner;
    private int isMaintain;

    public int getIsMaintain() {
        return isMaintain;
    }

    public void setIsMaintain(int isMaintain) {
        this.isMaintain = isMaintain;
    }

    private String startTime;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

    private String finishedTime;
    private String status;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public String getMaintainOwner() {
        return maintainOwner;
    }

    public void setMaintainOwner(String maintainOwner) {
        this.maintainOwner = maintainOwner;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
