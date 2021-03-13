package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_scrap")
public class DeviceScrap {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设备ID
     */
    @Column(name = "device_id")
    private Integer deviceId;

    /**
     * 执行报废操作的用户ID
     */
    @Column(name = "scrap_user_id")
    private Integer scrapUserId;

    /**
     * 报废的时间
     */
    @Column(name = "scrap_time")
    private Date scrapTime;

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
     * 报废的理由
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
     * 获取设备ID
     *
     * @return device_id - 设备ID
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备ID
     *
     * @param deviceId 设备ID
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取执行报废操作的用户ID
     *
     * @return scrap_user_id - 执行报废操作的用户ID
     */
    public Integer getScrapUserId() {
        return scrapUserId;
    }

    /**
     * 设置执行报废操作的用户ID
     *
     * @param scrapUserId 执行报废操作的用户ID
     */
    public void setScrapUserId(Integer scrapUserId) {
        this.scrapUserId = scrapUserId;
    }

    /**
     * 获取报废的时间
     *
     * @return scrap_time - 报废的时间
     */
    public Date getScrapTime() {
        return scrapTime;
    }

    /**
     * 设置报废的时间
     *
     * @param scrapTime 报废的时间
     */
    public void setScrapTime(Date scrapTime) {
        this.scrapTime = scrapTime;
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
     * 获取报废的理由
     *
     * @return detail - 报废的理由
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置报废的理由
     *
     * @param detail 报废的理由
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}