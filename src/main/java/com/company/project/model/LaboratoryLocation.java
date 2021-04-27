package com.company.project.model;

import javax.persistence.*;

@Table(name = "laboratory_location")
public class LaboratoryLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 实验室ID
     */
    @Column(name = "lab_id")
    private Integer labId;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取实验室ID
     *
     * @return lab_id - 实验室ID
     */
    public Integer getLabId() {
        return labId;
    }

    /**
     * 设置实验室ID
     *
     * @param labId 实验室ID
     */
    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}