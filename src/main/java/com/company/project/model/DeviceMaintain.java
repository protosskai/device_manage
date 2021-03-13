package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_maintain")
public class DeviceMaintain {
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
     * 维护人用户ID
     */
    @Column(name = "maintain_user_id")
    private Integer maintainUserId;

    /**
     * 开始维护时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 预计完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

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
     * 当前维护状态。
     */
    private String status;

    /**
     * 是否删除。0-未删除，1-已删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

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
     * 获取维护人用户ID
     *
     * @return maintain_user_id - 维护人用户ID
     */
    public Integer getMaintainUserId() {
        return maintainUserId;
    }

    /**
     * 设置维护人用户ID
     *
     * @param maintainUserId 维护人用户ID
     */
    public void setMaintainUserId(Integer maintainUserId) {
        this.maintainUserId = maintainUserId;
    }

    /**
     * 获取开始维护时间
     *
     * @return start_time - 开始维护时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始维护时间
     *
     * @param startTime 开始维护时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取预计完成时间
     *
     * @return finish_time - 预计完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置预计完成时间
     *
     * @param finishTime 预计完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
     * 获取当前维护状态。
     *
     * @return status - 当前维护状态。
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置当前维护状态。
     *
     * @param status 当前维护状态。
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取是否删除。0-未删除，1-已删除
     *
     * @return is_deleted - 是否删除。0-未删除，1-已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除。0-未删除，1-已删除
     *
     * @param isDeleted 是否删除。0-未删除，1-已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}