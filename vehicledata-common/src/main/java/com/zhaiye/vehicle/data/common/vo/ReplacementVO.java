package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 计算替换服务的结果
 * @author zhaiye
 * on 2019/02/17
 */
public class ReplacementVO implements Serializable {

    private static final long serialVersionUID = -7710034456760246793L;

    /**
     * 周转次数
     */
    private BigDecimal runCount;

    /**
     * 整列载重能力(吨)
     */
    private BigDecimal totalLoad;

    /**
     * 整列车辆公里(吨公里)
     */
    private BigDecimal totalWorkDistance;

    /**
     * 整列运输收入
     */
    private BigDecimal totalRevenue;

    /**
     * 折旧率
     */
    private BigDecimal deprecationRate;

    /**
     * 最佳使用年限
     */
    private BigDecimal limitYear;

    /**
     * 编组辆数
     */
    private BigDecimal couches;

    /**
     * 整列购置成本
     */
    private BigDecimal totalPurchaseCost;

    /**
     * 最佳使用年限内总维修成本
     */
    private BigDecimal totalFixCost;

    /**
     * 在第X年被替换时的各类收益计算结果列表
     */
    private List<ReplacementResultVO> replacementAResultList;

    /**
     * 在第X年替换时，替换车辆的收益计算结果列表
     */
    private List<ReplacementResultVO> replacementBResultList;

    public BigDecimal getRunCount() {
        return runCount;
    }

    public void setRunCount(BigDecimal runCount) {
        this.runCount = runCount;
    }

    public BigDecimal getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(BigDecimal totalLoad) {
        this.totalLoad = totalLoad;
    }

    public BigDecimal getTotalWorkDistance() {
        return totalWorkDistance;
    }

    public void setTotalWorkDistance(BigDecimal totalWorkDistance) {
        this.totalWorkDistance = totalWorkDistance;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getDeprecationRate() {
        return deprecationRate;
    }

    public void setDeprecationRate(BigDecimal deprecationRate) {
        this.deprecationRate = deprecationRate;
    }

    public List<ReplacementResultVO> getReplacementAResultList() {
        return replacementAResultList;
    }

    public void setReplacementAResultList(List<ReplacementResultVO> replacementAResultList) {
        this.replacementAResultList = replacementAResultList;
    }

    public List<ReplacementResultVO> getReplacementBResultList() {
        return replacementBResultList;
    }

    public void setReplacementBResultList(List<ReplacementResultVO> replacementBResultList) {
        this.replacementBResultList = replacementBResultList;
    }

    public BigDecimal getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(BigDecimal limitYear) {
        this.limitYear = limitYear;
    }

    public BigDecimal getCouches() {
        return couches;
    }

    public void setCouches(BigDecimal couches) {
        this.couches = couches;
    }

    public BigDecimal getTotalPurchaseCost() {
        return totalPurchaseCost;
    }

    public void setTotalPurchaseCost(BigDecimal totalPurchaseCost) {
        this.totalPurchaseCost = totalPurchaseCost;
    }

    public BigDecimal getTotalFixCost() {
        return totalFixCost;
    }

    public void setTotalFixCost(BigDecimal totalFixCost) {
        this.totalFixCost = totalFixCost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacementVO{");
        sb.append("runCount=").append(runCount);
        sb.append(", totalLoad=").append(totalLoad);
        sb.append(", totalWorkDistance=").append(totalWorkDistance);
        sb.append(", totalRevenue=").append(totalRevenue);
        sb.append(", deprecationRate=").append(deprecationRate);
        sb.append(", limitYear=").append(limitYear);
        sb.append(", couches=").append(couches);
        sb.append(", totalPurchaseCost=").append(totalPurchaseCost);
        sb.append(", totalFixCost=").append(totalFixCost);
        sb.append(", replacementAResultList=").append(replacementAResultList);
        sb.append(", replacementBResultList=").append(replacementBResultList);
        sb.append('}');
        return sb.toString();
    }
}
