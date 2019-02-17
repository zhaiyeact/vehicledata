package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 使用年限计算结果展示数据
 * @author zhaiye
 * on 2019/02/17
 */
public class UsageLimitVO implements Serializable {

    private static final long serialVersionUID = -7675204504129412115L;

    /**
     * 最佳使用年限
     */
    private BigDecimal limitYear;

    /**
     * 车厢数
     */
    private Integer couches;

    /**
     * 成本计算结果列表
     */
    private List<UsageResultVO> usageResultVOList;

    public BigDecimal getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(BigDecimal limitYear) {
        this.limitYear = limitYear;
    }

    public List<UsageResultVO> getUsageResultVOList() {
        return usageResultVOList;
    }

    public void setUsageResultVOList(List<UsageResultVO> usageResultVOList) {
        this.usageResultVOList = usageResultVOList;
    }

    public Integer getCouches() {
        return couches;
    }

    public void setCouches(Integer couches) {
        this.couches = couches;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsageLimitVO{");
        sb.append("limitYear=").append(limitYear);
        sb.append(", couches=").append(couches);
        sb.append(", usageResultVOList=").append(usageResultVOList);
        sb.append('}');
        return sb.toString();
    }
}
