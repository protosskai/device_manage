package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_basic_info")
public class DeviceBasicInfo {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设备名称
     */
    @Column(name = "device_name")
    private String deviceName;

    /**
     * UUID.生成二维码的凭据
     */
    private String uuid;

    /**
     * 是否废弃。0-未废弃，1-已废弃
     */
    @Column(name = "is_scraped")
    private Integer isScraped;

    /**
     * 负责人用户ID
     */
    @Column(name = "principal_user_id")
    private Integer principalUserId;

    /**
     * 是否正在维护。0-未维护，1-正在维护
     */
    @Column(name = "is_maintain")
    private Integer isMaintain;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否借出
     */
    @Column(name = "is_lended")
    private Integer isLended;

    /**
     * 是否被预定
     */
    @Column(name = "is_reverse")
    private Integer isReverse;

    /**
     * 设备详情介绍
     */
    private String detail;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取设备名称
     *
     * @return device_name - 设备名称
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置设备名称
     *
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取UUID.生成二维码的凭据
     *
     * @return uuid - UUID.生成二维码的凭据
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置UUID.生成二维码的凭据
     *
     * @param uuid UUID.生成二维码的凭据
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取是否废弃。0-未废弃，1-已废弃
     *
     * @return is_scraped - 是否废弃。0-未废弃，1-已废弃
     */
    public Integer getIsScraped() {
        return isScraped;
    }

    /**
     * 设置是否废弃。0-未废弃，1-已废弃
     *
     * @param isScraped 是否废弃。0-未废弃，1-已废弃
     */
    public void setIsScraped(Integer isScraped) {
        this.isScraped = isScraped;
    }

    /**
     * 获取负责人用户ID
     *
     * @return principal_user_id - 负责人用户ID
     */
    public Integer getPrincipalUserId() {
        return principalUserId;
    }

    /**
     * 设置负责人用户ID
     *
     * @param principalUserId 负责人用户ID
     */
    public void setPrincipalUserId(Integer principalUserId) {
        this.principalUserId = principalUserId;
    }

    /**
     * 获取是否正在维护。0-未维护，1-正在维护
     *
     * @return is_maintain - 是否正在维护。0-未维护，1-正在维护
     */
    public Integer getIsMaintain() {
        return isMaintain;
    }

    /**
     * 设置是否正在维护。0-未维护，1-正在维护
     *
     * @param isMaintain 是否正在维护。0-未维护，1-正在维护
     */
    public void setIsMaintain(Integer isMaintain) {
        this.isMaintain = isMaintain;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后更新时间
     *
     * @return update_time - 最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否借出
     *
     * @return is_lended - 是否借出
     */
    public Integer getIsLended() {
        return isLended;
    }

    /**
     * 设置是否借出
     *
     * @param isLended 是否借出
     */
    public void setIsLended(Integer isLended) {
        this.isLended = isLended;
    }

    /**
     * 获取是否被预定
     *
     * @return is_reverse - 是否被预定
     */
    public Integer getIsReverse() {
        return isReverse;
    }

    /**
     * 设置是否被预定
     *
     * @param isReverse 是否被预定
     */
    public void setIsReverse(Integer isReverse) {
        this.isReverse = isReverse;
    }

    /**
     * 获取设备详情介绍
     *
     * @return detail - 设备详情介绍
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置设备详情介绍
     *
     * @param detail 设备详情介绍
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}