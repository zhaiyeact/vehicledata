package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 最佳使用年限，每年展示成本计算结果对象
 * @author zhaiye
 * on 2019/02/17
 */
public class UsageResultVO implements Serializable {

    private static final long serialVersionUID = -1767915530590985680L;

    /**
     * 年份
     */
    private BigDecimal year;

    /**
     * 第N年平均购置成本
     */
    private BigDecimal avgPurchaseCost;

    /**
     * 第N年累计维修成本
     */
    private BigDecimal totalFixCost;

    /**
     * 第N年平均维修成本
     */
    private BigDecimal avgFixCost;

    /**
     * 第N年平均成本合计
     */
    private BigDecimal avgCost;

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public BigDecimal getAvgPurchaseCost() {
        return avgPurchaseCost;
    }

    public void setAvgPurchaseCost(BigDecimal avgPurchaseCost) {
        this.avgPurchaseCost = avgPurchaseCost;
    }

    public BigDecimal getTotalFixCost() {
        return totalFixCost;
    }

    public void setTotalFixCost(BigDecimal totalFixCost) {
        this.totalFixCost = totalFixCost;
    }

    public BigDecimal getAvgFixCost() {
        return avgFixCost;
    }

    public void setAvgFixCost(BigDecimal avgFixCost) {
        this.avgFixCost = avgFixCost;
    }

    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(BigDecimal avgCost) {
        this.avgCost = avgCost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsageResultVO{");
        sb.append("year=").append(year);
        sb.append(", avgPurchaseCost=").append(avgPurchaseCost);
        sb.append(", totalFixCost=").append(totalFixCost);
        sb.append(", avgFixCost=").append(avgFixCost);
        sb.append(", avgCost=").append(avgCost);
        sb.append('}');
        return sb.toString();
    }
}
