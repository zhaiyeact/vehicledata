package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;

/**
 * 替换车型计算结果展示
 *
 * @author zhaiye
 * on 2019/02/24
 */
public class ReplacementWebResultVO implements Serializable {

    private static final long serialVersionUID = -5884820524298831674L;

    /**
     * 年份
     */
    private String year;

    /**
     * 被替换车型剩余折旧费
     */
    private Double typeARemainDeprecationCost;

    /**
     * 被替换车型剩余维修费
     */
    private Double typeARemainFixCost;

    /**
     * 被替换车型剩余运输收入
     */
    private Double typeARemainRevenue;

    /**
     * 被替换车型剩余收益
     */
    private Double typeARemainIncome;

    /**
     * 替换车型总收益
     */
    private Double typeBIncome;

    /**
     * 效益差值
     */
    private Double differenceValue;

    public Double getTypeARemainDeprecationCost() {
        return typeARemainDeprecationCost;
    }

    public void setTypeARemainDeprecationCost(Double typeARemainDeprecationCost) {
        this.typeARemainDeprecationCost = typeARemainDeprecationCost;
    }

    public Double getTypeARemainFixCost() {
        return typeARemainFixCost;
    }

    public void setTypeARemainFixCost(Double typeARemainFixCost) {
        this.typeARemainFixCost = typeARemainFixCost;
    }

    public Double getTypeARemainRevenue() {
        return typeARemainRevenue;
    }

    public void setTypeARemainRevenue(Double typeARemainRevenue) {
        this.typeARemainRevenue = typeARemainRevenue;
    }

    public Double getTypeARemainIncome() {
        return typeARemainIncome;
    }

    public void setTypeARemainIncome(Double typeARemainIncome) {
        this.typeARemainIncome = typeARemainIncome;
    }

    public Double getTypeBIncome() {
        return typeBIncome;
    }

    public void setTypeBIncome(Double typeBIncome) {
        this.typeBIncome = typeBIncome;
    }

    public Double getDifferenceValue() {
        return differenceValue;
    }

    public void setDifferenceValue(Double differenceValue) {
        this.differenceValue = differenceValue;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacementWebResultVO{");
        sb.append("year='").append(year).append('\'');
        sb.append(", typeARemainDeprecationCost=").append(typeARemainDeprecationCost);
        sb.append(", typeARemainFixCost=").append(typeARemainFixCost);
        sb.append(", typeARemainRevenue=").append(typeARemainRevenue);
        sb.append(", typeARemainIncome=").append(typeARemainIncome);
        sb.append(", typeBIncome=").append(typeBIncome);
        sb.append(", differenceValue=").append(differenceValue);
        sb.append('}');
        return sb.toString();
    }
}
