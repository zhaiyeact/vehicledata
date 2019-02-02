package com.zhaiye.vehicle.data.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 车辆相关参数
 * created by zhaiye
 * on 2019/01/31
 */
public class VehicleParameterDTO implements Serializable {

    private static final long serialVersionUID = -4767149246897858716L;

    /**
     * 车型
     */
    private String vehicleType;

    /**
     * 自重(吨)
     */
    private BigDecimal weight;

    /**
     * 载重(吨)
     */
    private BigDecimal load;

    /**
     * 技术寿命(年)
     */
    private Integer lifeSpan;

    /**
     * 购置成本
     */
    private BigDecimal cost;

    /**
     * 厂修成本列表。每个元素代表一年
     */
    private List<BigDecimal> factoryRepairCostList;

    /**
     * 段修成本列表。每个元素代表一年
     */
    private List<BigDecimal> sectionRepairCostList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getLoad() {
        return load;
    }

    public void setLoad(BigDecimal load) {
        this.load = load;
    }

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<BigDecimal> getFactoryRepairCostList() {
        return factoryRepairCostList;
    }

    public void setFactoryRepairCostList(List<BigDecimal> factoryRepairCostList) {
        this.factoryRepairCostList = factoryRepairCostList;
    }

    public List<BigDecimal> getSectionRepairCostList() {
        return sectionRepairCostList;
    }

    public void setSectionRepairCostList(List<BigDecimal> sectionRepairCostList) {
        this.sectionRepairCostList = sectionRepairCostList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VehicleParameterDTO{");
        sb.append("vehicleType='").append(vehicleType).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", load=").append(load);
        sb.append(", lifeSpan=").append(lifeSpan);
        sb.append(", cost=").append(cost);
        sb.append(", factoryRepairCostList=").append(factoryRepairCostList);
        sb.append(", sectionRepairCostList=").append(sectionRepairCostList);
        sb.append('}');
        return sb.toString();
    }
}
