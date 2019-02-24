package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;

/**web层入参vo
 *
 * @author zhaiye
 * on 2019/02/24
 */
public class VehicleDataWebQueryVO implements Serializable {

    private static final long serialVersionUID = 8071669088854476858L;

    /**
     * 车型
     */
    private String vehicleType;

    /**
     * 自重(吨)
     */
    private String weight;

    /**
     * 载重(吨)
     */
    private String load;

    /**
     * 技术寿命(年)
     */
    private String lifeSpan;

    /**
     * 购置成本
     */
    private String cost;

    /**
     * 厂修年份
     */
    private String factoryRepairYears;

    /**
     * 段修间隔
     */
    private String sectionRepairInterval;

    /**
     * 厂修成本列表。逗号隔开
     */
    private String factoryRepairCosts;

    /**
     * 段修成本列表。逗号隔开
     */
    private String sectionRepairCosts;

    /**
     * 牵引质量(吨)
     */
    private String tractiveWeight;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getFactoryRepairYears() {
        return factoryRepairYears;
    }

    public void setFactoryRepairYears(String factoryRepairYears) {
        this.factoryRepairYears = factoryRepairYears;
    }

    public String getSectionRepairInterval() {
        return sectionRepairInterval;
    }

    public void setSectionRepairInterval(String sectionRepairInterval) {
        this.sectionRepairInterval = sectionRepairInterval;
    }

    public String getFactoryRepairCosts() {
        return factoryRepairCosts;
    }

    public void setFactoryRepairCosts(String factoryRepairCosts) {
        this.factoryRepairCosts = factoryRepairCosts;
    }

    public String getSectionRepairCosts() {
        return sectionRepairCosts;
    }

    public void setSectionRepairCosts(String sectionRepairCosts) {
        this.sectionRepairCosts = sectionRepairCosts;
    }

    public String getTractiveWeight() {
        return tractiveWeight;
    }

    public void setTractiveWeight(String tractiveWeight) {
        this.tractiveWeight = tractiveWeight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VehicleDataWebQueryVO{");
        sb.append("vehicleType='").append(vehicleType).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", load='").append(load).append('\'');
        sb.append(", lifeSpan='").append(lifeSpan).append('\'');
        sb.append(", cost='").append(cost).append('\'');
        sb.append(", factoryRepairYears='").append(factoryRepairYears).append('\'');
        sb.append(", sectionRepairInterval='").append(sectionRepairInterval).append('\'');
        sb.append(", factoryRepairCosts='").append(factoryRepairCosts).append('\'');
        sb.append(", sectionRepairCosts='").append(sectionRepairCosts).append('\'');
        sb.append(", tractiveWeight='").append(tractiveWeight).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
