package com.zhaiye.vehicle.data.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 通用额外参数
 * created by zhaiye
 * on 2019/01/31
 */
public class ExtraParameterDTO implements Serializable {

    private static final long serialVersionUID = 2706654163498980952L;

    /**
     * 牵引质量(吨)
     */
    private BigDecimal tractiveWeight;

    /**
     * 平均运距(km)
     */
    private BigDecimal avgWorkDistance;

    /**
     * 运转时间(天)
     */
    private BigDecimal workTimeDuration;

    /**
     * 每年运行天数
     */
    private Integer workDaysInYear;

    /**
     * 货物4号运价基价1（元/吨）
     */
    private BigDecimal basicPriceOne;

    /**
     * 货物4号运价基价2（元/吨公里）
     */
    private BigDecimal basicPriceTwo;

    public BigDecimal getTractiveWeight() {
        return tractiveWeight;
    }

    public void setTractiveWeight(BigDecimal tractiveWeight) {
        this.tractiveWeight = tractiveWeight;
    }

    public BigDecimal getAvgWorkDistance() {
        return avgWorkDistance;
    }

    public void setAvgWorkDistance(BigDecimal avgWorkDistance) {
        this.avgWorkDistance = avgWorkDistance;
    }

    public BigDecimal getWorkTimeDuration() {
        return workTimeDuration;
    }

    public void setWorkTimeDuration(BigDecimal workTimeDuration) {
        this.workTimeDuration = workTimeDuration;
    }

    public Integer getWorkDaysInYear() {
        return workDaysInYear;
    }

    public void setWorkDaysInYear(Integer workDaysInYear) {
        this.workDaysInYear = workDaysInYear;
    }

    public BigDecimal getBasicPriceOne() {
        return basicPriceOne;
    }

    public void setBasicPriceOne(BigDecimal basicPriceOne) {
        this.basicPriceOne = basicPriceOne;
    }

    public BigDecimal getBasicPriceTwo() {
        return basicPriceTwo;
    }

    public void setBasicPriceTwo(BigDecimal basicPriceTwo) {
        this.basicPriceTwo = basicPriceTwo;
    }
}
