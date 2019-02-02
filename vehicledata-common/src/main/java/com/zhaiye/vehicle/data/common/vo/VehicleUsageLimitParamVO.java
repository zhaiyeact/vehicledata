package com.zhaiye.vehicle.data.common.vo;

import com.sargeraswang.util.ExcelUtil.ExcelCell;

import java.io.Serializable;

/**
 * 车辆最佳使用年限计算VO
 * created by zhaiye
 * on 2019/01/31
 */
public class VehicleUsageLimitParamVO implements Serializable {

    private static final long serialVersionUID = 4944999218662276339L;

    /**
     * 车型
     */
    @ExcelCell(index = 0)
    private String vehicleType;

    /**
     * 自重(吨)
     */
    @ExcelCell(index = 1)
    private String weight;

    /**
     * 载重(吨)
     */
    @ExcelCell(index = 2)
    private String load;

    /**
     * 技术寿命(年)
     */
    @ExcelCell(index = 3)
    private Integer lifeSpan;

    /**
     * 购置成本
     */
    @ExcelCell(index = 4)
    private String cost;

    /**
     * 第一次厂修成本(万元)
     */
    @ExcelCell(index = 5)
    private String factoryRepair1;

    @ExcelCell(index = 6)
    private String factoryRepair2;

    @ExcelCell(index = 7)
    private String factoryRepair3;

    /**
     * 第一次段修成本(万元)
     */
    @ExcelCell(index = 8)
    private String sectionRepair1;

    @ExcelCell(index = 9)
    private String sectionRepair2;

    @ExcelCell(index = 10)
    private String sectionRepair3;

    @ExcelCell(index = 11)
    private String sectionRepair4;

    @ExcelCell(index = 12)
    private String sectionRepair5;

    @ExcelCell(index = 13)
    private String sectionRepair6;

    @ExcelCell(index = 14)
    private String sectionRepair7;

    @ExcelCell(index = 15)
    private String sectionRepair8;

    @ExcelCell(index = 16)
    private String sectionRepair9;

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

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getFactoryRepair1() {
        return factoryRepair1;
    }

    public void setFactoryRepair1(String factoryRepair1) {
        this.factoryRepair1 = factoryRepair1;
    }

    public String getFactoryRepair2() {
        return factoryRepair2;
    }

    public void setFactoryRepair2(String factoryRepair2) {
        this.factoryRepair2 = factoryRepair2;
    }

    public String getFactoryRepair3() {
        return factoryRepair3;
    }

    public void setFactoryRepair3(String factoryRepair3) {
        this.factoryRepair3 = factoryRepair3;
    }

    public String getSectionRepair1() {
        return sectionRepair1;
    }

    public void setSectionRepair1(String sectionRepair1) {
        this.sectionRepair1 = sectionRepair1;
    }

    public String getSectionRepair2() {
        return sectionRepair2;
    }

    public void setSectionRepair2(String sectionRepair2) {
        this.sectionRepair2 = sectionRepair2;
    }

    public String getSectionRepair3() {
        return sectionRepair3;
    }

    public void setSectionRepair3(String sectionRepair3) {
        this.sectionRepair3 = sectionRepair3;
    }

    public String getSectionRepair4() {
        return sectionRepair4;
    }

    public void setSectionRepair4(String sectionRepair4) {
        this.sectionRepair4 = sectionRepair4;
    }

    public String getSectionRepair5() {
        return sectionRepair5;
    }

    public void setSectionRepair5(String sectionRepair5) {
        this.sectionRepair5 = sectionRepair5;
    }

    public String getSectionRepair6() {
        return sectionRepair6;
    }

    public void setSectionRepair6(String sectionRepair6) {
        this.sectionRepair6 = sectionRepair6;
    }

    public String getSectionRepair7() {
        return sectionRepair7;
    }

    public void setSectionRepair7(String sectionRepair7) {
        this.sectionRepair7 = sectionRepair7;
    }

    public String getSectionRepair8() {
        return sectionRepair8;
    }

    public void setSectionRepair8(String sectionRepair8) {
        this.sectionRepair8 = sectionRepair8;
    }

    public String getSectionRepair9() {
        return sectionRepair9;
    }

    public void setSectionRepair9(String sectionRepair9) {
        this.sectionRepair9 = sectionRepair9;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VehicleUsageLimitParamVO{");
        sb.append("vehicleType='").append(vehicleType).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", load='").append(load).append('\'');
        sb.append(", lifeSpan=").append(lifeSpan);
        sb.append(", cost='").append(cost).append('\'');
        sb.append(", factoryRepair1='").append(factoryRepair1).append('\'');
        sb.append(", factoryRepair2='").append(factoryRepair2).append('\'');
        sb.append(", factoryRepair3='").append(factoryRepair3).append('\'');
        sb.append(", sectionRepair1='").append(sectionRepair1).append('\'');
        sb.append(", sectionRepair2='").append(sectionRepair2).append('\'');
        sb.append(", sectionRepair3='").append(sectionRepair3).append('\'');
        sb.append(", sectionRepair4='").append(sectionRepair4).append('\'');
        sb.append(", sectionRepair5='").append(sectionRepair5).append('\'');
        sb.append(", sectionRepair6='").append(sectionRepair6).append('\'');
        sb.append(", sectionRepair7='").append(sectionRepair7).append('\'');
        sb.append(", sectionRepair8='").append(sectionRepair8).append('\'');
        sb.append(", sectionRepair9='").append(sectionRepair9).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
