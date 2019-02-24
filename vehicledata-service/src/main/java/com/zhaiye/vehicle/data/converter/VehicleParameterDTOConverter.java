package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataWebQueryVO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link VehicleParameterDTO}转换器
 * @author zhaiye
 * on 2019/02/24
 */
public class VehicleParameterDTOConverter {

    /**
     * 默认分隔符
     */
    private static final String SPLITTER = ",";

    /**
     * 将{@link VehicleDataWebQueryVO}转换成{@link VehicleParameterDTO}
     *
     * @param query
     * @return
     */
    public static VehicleParameterDTO convertFromVehicleDataQueryVO(VehicleDataWebQueryVO query) {
        VehicleParameterDTO target = new VehicleParameterDTO();
        target.setVehicleType(query.getVehicleType());
        target.setWeight(new BigDecimal(query.getWeight()));
        target.setLoad(new BigDecimal(query.getLoad()));
        target.setCost(new BigDecimal(query.getCost()));
        target.setLifeSpan(Integer.parseInt(query.getLifeSpan()));
        target.setSectionRepairInterval(new BigDecimal(query.getSectionRepairInterval()));
        target.setSectionRepairCostList(convertFromStr(query.getSectionRepairCosts()));
        target.setFactoryRepairYears(convertFromStr(query.getFactoryRepairYears()));
        target.setFactoryRepairCostList(convertFromStr(query.getFactoryRepairCosts()));
        return target;
    }

    /**
     * 将用,分割的String字符串转换成{@link BigDecimal}列表
     *
     * @param orgStr 源字符串，用,隔开
     * @return 列表
     */
    private static List<BigDecimal> convertFromStr(String orgStr) {
        String[] array = orgStr.split(SPLITTER);
        return Arrays.stream(array)
                .map(str->new BigDecimal(str))
                .collect(Collectors.toList());
    }
}
