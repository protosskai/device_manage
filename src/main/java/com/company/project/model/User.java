package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "user_alias")
    private String userAlias;

    /**
     * 用户身份
     */
    private String role;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像ID
     */
    private String pic;

    /**
     * 用户是否删除。0-未删除， 1-已删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 用户是否被禁用。0-未禁用， 1-已禁用
     */
    @Column(name = "is_banned")
    private Integer isBanned;

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
     * 手机号
     */
    private String phone;

    /**
     * qq号
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 性别。0-男， 1-女
     */
    private Integer sex;

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
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户昵称
     *
     * @return user_alias - 用户昵称
     */
    public String getUserAlias() {
        return userAlias;
    }

    /**
     * 设置用户昵称
     *
     * @param userAlias 用户昵称
     */
    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    /**
     * 获取用户身份
     *
     * @return role - 用户身份
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置用户身份
     *
     * @param role 用户身份
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户头像ID
     *
     * @return pic - 用户头像ID
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置用户头像ID
     *
     * @param pic 用户头像ID
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取用户是否删除。0-未删除， 1-已删除
     *
     * @return is_deleted - 用户是否删除。0-未删除， 1-已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置用户是否删除。0-未删除， 1-已删除
     *
     * @param isDeleted 用户是否删除。0-未删除， 1-已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取用户是否被禁用。0-未禁用， 1-已禁用
     *
     * @return is_banned - 用户是否被禁用。0-未禁用， 1-已禁用
     */
    public Integer getIsBanned() {
        return isBanned;
    }

    /**
     * 设置用户是否被禁用。0-未禁用， 1-已禁用
     *
     * @param isBanned 用户是否被禁用。0-未禁用， 1-已禁用
     */
    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
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
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取qq号
     *
     * @return qq - qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号
     *
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取微信号
     *
     * @return wechat - 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取性别。0-男， 1-女
     *
     * @return sex - 性别。0-男， 1-女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别。0-男， 1-女
     *
     * @param sex 性别。0-男， 1-女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}