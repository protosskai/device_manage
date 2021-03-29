package com.company.project.vo;

public class DeviceLendInfoVo {
    private int deviceId;
    private String deviceName;
    private int isLended;
    private String lendUser;
    private String lendTime;
    private String detail;

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

    public int getIsLended() {
        return isLended;
    }

    public void setIsLended(int isLended) {
        this.isLended = isLended;
    }

    public String getLendUser() {
        return lendUser;
    }

    public void setLendUser(String lendUser) {
        this.lendUser = lendUser;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
