package com.company.project.vo;

public class DeviceInfoVo {
    // 设备ID
    private int id;
    // 设备名称
    private String deviceName;
    // 设备负责人
    private String principalUser;
    // 是否正在维护
    private int isMaintain;
    // 是否废弃
    private int isScraped;
    // 设备详情
    private String detail;
    private String createTime;
    private String uuid;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPrincipalUser() {
        return principalUser;
    }

    public void setPrincipalUser(String principalUser) {
        this.principalUser = principalUser;
    }

    public int getIsMaintain() {
        return isMaintain;
    }

    public void setIsMaintain(int isMaintain) {
        this.isMaintain = isMaintain;
    }

    public int getIsScraped() {
        return isScraped;
    }

    public void setIsScraped(int isScraped) {
        this.isScraped = isScraped;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
