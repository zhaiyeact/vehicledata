package com.zhaiye.vehicle.data.common.vo;

import com.zhaiye.vehicle.data.common.constant.FixType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhaiye
 * on 2019/02/17
 */
public class FixCostVO implements Serializable {

    private static final long serialVersionUID = 6626911960842794243L;

    /**
     * 第n次修理
     */
    private Integer fixTimes;

    /**
     * 修理类型
     */
    private FixType fixType;

    /**
     * 修理年份
     */
    private BigDecimal year;

    /**
     * 该年修理成本
     */
    private BigDecimal fixCost;

    public Integer getFixTimes() {
        return fixTimes;
    }

    public void setFixTimes(Integer fixTimes) {
        this.fixTimes = fixTimes;
    }

    public FixType getFixType() {
        return fixType;
    }

    public void setFixType(FixType fixType) {
        this.fixType = fixType;
    }

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public BigDecimal getFixCost() {
        return fixCost;
    }

    public void setFixCost(BigDecimal fixCost) {
        this.fixCost = fixCost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FixCostVO{");
        sb.append("fixTimes=").append(fixTimes);
        sb.append(", fixType=").append(fixType);
        sb.append(", year=").append(year);
        sb.append(", fixCost=").append(fixCost);
        sb.append('}');
        return sb.toString();
    }
}
