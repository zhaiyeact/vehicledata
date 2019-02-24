package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;

/**
 * web层展示用vo
 * @author zhaiye
 * on 2019/02/24
 */
public class UsageLimitWebResultVO implements Serializable {

    private static final long serialVersionUID = -48594821570113756L;

    /**
     * 年份
     */
    private String year;

    /**
     * 平均购置成本
     */
    private Double avgPurchaseCost;

    /**
     * 平均维修成本
     */
    private Double avgFixCost;

    /**
     * 平均成本合计
     */
    private Double avgCost;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getAvgPurchaseCost() {
        return avgPurchaseCost;
    }

    public void setAvgPurchaseCost(Double avgPurchaseCost) {
        this.avgPurchaseCost = avgPurchaseCost;
    }

    public Double getAvgFixCost() {
        return avgFixCost;
    }

    public void setAvgFixCost(Double avgFixCost) {
        this.avgFixCost = avgFixCost;
    }

    public Double getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(Double avgCost) {
        this.avgCost = avgCost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsageLimitWebResultVO{");
        sb.append("year='").append(year).append('\'');
        sb.append(", avgPurchaseCost='").append(avgPurchaseCost).append('\'');
        sb.append(", avgFixCost='").append(avgFixCost).append('\'');
        sb.append(", avgCost='").append(avgCost).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
