package com.zhaiye.vehicle.data.service;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.vo.ReplacementVO;

/**
 * 计算不同车型替换年限的服务
 * created by zhaiye
 * on 2019/02/17
 */
public interface ReplacementService {

    /**
     * 计算车型替换结果数据
     *
     * @param vehicleA 被替换车辆
     * @param vehicleB 替换车辆
     * @param extraParam 额外数据
     * @return
     */
    ReplacementVO calculateReplacement(VehicleDetailParameterDTO vehicleA, VehicleDetailParameterDTO vehicleB, ExtraParameterDTO extraParam);
}
