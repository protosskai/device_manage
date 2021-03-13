package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "laboratory_info")
public class LaboratoryInfo {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 实验室名称
     */
    @Column(name = "lab_name")
    private String labName;

    /**
     * 实验室负责人的用户ID
     */
    @Column(name = "principal_user_id")
    private Integer principalUserId;

    /**
     * 实验室所属区域
     */
    private String region;

    /**
     * 是否删除。0-未删除，1-已删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

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
     * 实验室详情
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
     * 获取实验室名称
     *
     * @return lab_name - 实验室名称
     */
    public String getLabName() {
        return labName;
    }

    /**
     * 设置实验室名称
     *
     * @param labName 实验室名称
     */
    public void setLabName(String labName) {
        this.labName = labName;
    }

    /**
     * 获取实验室负责人的用户ID
     *
     * @return principal_user_id - 实验室负责人的用户ID
     */
    public Integer getPrincipalUserId() {
        return principalUserId;
    }

    /**
     * 设置实验室负责人的用户ID
     *
     * @param principalUserId 实验室负责人的用户ID
     */
    public void setPrincipalUserId(Integer principalUserId) {
        this.principalUserId = principalUserId;
    }

    /**
     * 获取实验室所属区域
     *
     * @return region - 实验室所属区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置实验室所属区域
     *
     * @param region 实验室所属区域
     */
    public void setRegion(String region) {
        this.region = region;
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
     * 获取实验室详情
     *
     * @return detail - 实验室详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置实验室详情
     *
     * @param detail 实验室详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}