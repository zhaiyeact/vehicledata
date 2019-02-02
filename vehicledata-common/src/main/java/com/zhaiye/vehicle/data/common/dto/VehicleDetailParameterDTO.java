package com.zhaiye.vehicle.data.common.dto;

import java.math.BigDecimal;

/**
 * 车型详细参数
 * created by zhaiye
 * on 2019/01/31
 */
public class VehicleDetailParameterDTO extends VehicleParameterDTO {

    private static final long serialVersionUID = 8710612064768893427L;

    /**
     * 检备率（%）
     */
    private BigDecimal checkBackupRate;

    /**
     * 残值率（%）
     */
    private BigDecimal badCaseRate;

    public BigDecimal getCheckBackupRate() {
        return checkBackupRate;
    }

    public void setCheckBackupRate(BigDecimal checkBackupRate) {
        this.checkBackupRate = checkBackupRate;
    }

    public BigDecimal getBadCaseRate() {
        return badCaseRate;
    }

    public void setBadCaseRate(BigDecimal badCaseRate) {
        this.badCaseRate = badCaseRate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VehicleDetailParameterDTO{");
        sb.append("checkBackupRate=").append(checkBackupRate);
        sb.append(", badCaseRate=").append(badCaseRate);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
