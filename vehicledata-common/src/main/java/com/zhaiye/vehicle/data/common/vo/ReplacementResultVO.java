package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 每年的替换计算结果展示对象
 * @author zhaiye
 * on 2019/02/17
 */
public class ReplacementResultVO implements Serializable {

    private static final long serialVersionUID = -1710860309268124121L;

    /**
     * 年份
     */
    private BigDecimal year;

    /**
     * 折旧费
     */
    private BigDecimal deprecationCost;

    /**
     * 总维修费
     */
    private BigDecimal totalFixCost;

    /**
     * 运输收入
     */
    private BigDecimal revenue;

    /**
     * 剩余折旧费
     */
    private BigDecimal remainDeprecationCost;

    /**
     * 剩余维修费
     */
    private BigDecimal remainFixCost;

    /**
     * 剩余运输收入
     */
    private BigDecimal remainRevenue;

    /**
     * 剩余收益
     */
    private BigDecimal remainIncome;

    /**
     * 替换车型的总收益(万元)
     */
    private BigDecimal replacementTotalIncome;

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public BigDecimal getDeprecationCost() {
        return deprecationCost;
    }

    public void setDeprecationCost(BigDecimal deprecationCost) {
        this.deprecationCost = deprecationCost;
    }

    public BigDecimal getTotalFixCost() {
        return totalFixCost;
    }

    public void setTotalFixCost(BigDecimal totalFixCost) {
        this.totalFixCost = totalFixCost;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRemainDeprecationCost() {
        return remainDeprecationCost;
    }

    public void setRemainDeprecationCost(BigDecimal remainDeprecationCost) {
        this.remainDeprecationCost = remainDeprecationCost;
    }

    public BigDecimal getRemainFixCost() {
        return remainFixCost;
    }

    public void setRemainFixCost(BigDecimal remainFixCost) {
        this.remainFixCost = remainFixCost;
    }

    public BigDecimal getRemainRevenue() {
        return remainRevenue;
    }

    public void setRemainRevenue(BigDecimal remainRevenue) {
        this.remainRevenue = remainRevenue;
    }

    public BigDecimal getRemainIncome() {
        return remainIncome;
    }

    public void setRemainIncome(BigDecimal remainIncome) {
        this.remainIncome = remainIncome;
    }

    public BigDecimal getReplacementTotalIncome() {
        return replacementTotalIncome;
    }

    public void setReplacementTotalIncome(BigDecimal replacementTotalIncome) {
        this.replacementTotalIncome = replacementTotalIncome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacementResultVO{");
        sb.append("year=").append(year);
        sb.append(", deprecationCost=").append(deprecationCost);
        sb.append(", totalFixCost=").append(totalFixCost);
        sb.append(", revenue=").append(revenue);
        sb.append(", remainDeprecationCost=").append(remainDeprecationCost);
        sb.append(", remainFixCost=").append(remainFixCost);
        sb.append(", remainRevenue=").append(remainRevenue);
        sb.append(", remainIncome=").append(remainIncome);
        sb.append(", replacementTotalIncome=").append(replacementTotalIncome);
        sb.append('}');
        return sb.toString();
    }
}
