package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_lend")
public class DeviceLend {
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
     * 借出人
     */
    @Column(name = "lend_user_id")
    private Integer lendUserId;

    /**
     * 借出时间
     */
    @Column(name = "lend_time")
    private Date lendTime;

    /**
     * 预计归还时间
     */
    @Column(name = "expect_return_time")
    private Date expectReturnTime;

    /**
     * 实际归还时间
     */
    @Column(name = "return_time")
    private Date returnTime;

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

    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 借出详情
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
     * 获取借出人
     *
     * @return lend_user_id - 借出人
     */
    public Integer getLendUserId() {
        return lendUserId;
    }

    /**
     * 设置借出人
     *
     * @param lendUserId 借出人
     */
    public void setLendUserId(Integer lendUserId) {
        this.lendUserId = lendUserId;
    }

    /**
     * 获取借出时间
     *
     * @return lend_time - 借出时间
     */
    public Date getLendTime() {
        return lendTime;
    }

    /**
     * 设置借出时间
     *
     * @param lendTime 借出时间
     */
    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
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
     * 获取实际归还时间
     *
     * @return return_time - 实际归还时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 设置实际归还时间
     *
     * @param returnTime 实际归还时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
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
     * @return is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取借出详情
     *
     * @return detail - 借出详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置借出详情
     *
     * @param detail 借出详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}