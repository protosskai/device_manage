package com.company.project.vo;

public class DeviceReverseInfoVo {
    private int deviceId;
    private String deviceName;
    private int isReverse;
    private String reserveUser;
    private String reserveTime;
    private String expectReturnTime;
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

    public int getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(int isReverse) {
        this.isReverse = isReverse;
    }

    public String getReserveUser() {
        return reserveUser;
    }

    public void setReserveUser(String reserveUser) {
        this.reserveUser = reserveUser;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getExpectReturnTime() {
        return expectReturnTime;
    }

    public void setExpectReturnTime(String expectReturnTime) {
        this.expectReturnTime = expectReturnTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
