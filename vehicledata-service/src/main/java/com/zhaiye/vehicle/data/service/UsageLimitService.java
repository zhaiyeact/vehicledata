package com.zhaiye.vehicle.data.service;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.FixCostVO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;

import java.math.BigDecimal;

/**
 * 计算使用年限的服务
 * created by zhaiye
 * on 2019/02/17
 */
public interface UsageLimitService {

    /**
     * 根据车辆参数和额外参数，计算该车型的最佳使用年限
     *
     * @param vehicleParameterDTO 车辆参数
     * @param extraParameterDTO 额外参数
     * @return
     */
    UsageLimitVO calculateUsageLimit(VehicleParameterDTO vehicleParameterDTO, ExtraParameterDTO extraParameterDTO);

    /**
     * 计算每年的维修成本。该年可能为厂修，也可能为段修。有厂修的年份没有段修
     *
     * @param year 年份
     * @param vehicleParameterDTO 车辆参数
     * @param couches 编组辆数
     * @return 该年的维修成本
     */
    FixCostVO calculateFixCostByYear(BigDecimal year, VehicleParameterDTO vehicleParameterDTO, BigDecimal couches);
}
