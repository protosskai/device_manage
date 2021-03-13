package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_reserve")
public class DeviceReserve {
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
     * 预约用户ID
     */
    @Column(name = "reserve_user_id")
    private Integer reserveUserId;

    /**
     * 预定时间
     */
    @Column(name = "reserve_time")
    private Date reserveTime;

    /**
     * 预计归还时间
     */
    @Column(name = "expect_return_time")
    private Date expectReturnTime;

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
     * 预定详情
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
     * 获取预约用户ID
     *
     * @return reserve_user_id - 预约用户ID
     */
    public Integer getReserveUserId() {
        return reserveUserId;
    }

    /**
     * 设置预约用户ID
     *
     * @param reserveUserId 预约用户ID
     */
    public void setReserveUserId(Integer reserveUserId) {
        this.reserveUserId = reserveUserId;
    }

    /**
     * 获取预定时间
     *
     * @return reserve_time - 预定时间
     */
    public Date getReserveTime() {
        return reserveTime;
    }

    /**
     * 设置预定时间
     *
     * @param reserveTime 预定时间
     */
    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    /**
     * 获取预计归还时间
     *
     * @return expect_return_time - 预计归还时间
     */
    public Date getExpectReturnTime() {
        return expectReturnTime;
    }

    /**
     * 设置预计归还时间
     *
     * @param expectReturnTime 预计归还时间
     */
    public void setExpectReturnTime(Date expectReturnTime) {
        this.expectReturnTime = expectReturnTime;
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
     * 获取预定详情
     *
     * @return detail - 预定详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置预定详情
     *
     * @param detail 预定详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}