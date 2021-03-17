package com.company.project.vo;

public class DeviceScrapInfoVo {
    private int deviceId;
    private String deviceName;
    private int isScraped;
    private String scrapUser;
    private String scrapTime;
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

    public int getIsScraped() {
        return isScraped;
    }

    public void setIsScraped(int isScraped) {
        this.isScraped = isScraped;
    }

    public String getScrapUser() {
        return scrapUser;
    }

    public void setScrapUser(String scrapUser) {
        this.scrapUser = scrapUser;
    }

    public String getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(String scrapTime) {
        this.scrapTime = scrapTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
