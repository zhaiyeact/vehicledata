package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataDetailWebQueryVO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO}的转换器
 * @author zhaiye
 * on 2019/02/24
 */
public class VehicleDetailParameterDTOConverter {

    /**
     * 默认分隔符
     */
    private static final String SPLITTER = ",";

    /**
     * 获取被替换对象
     *
     * @param query
     * @return
     */
    public static VehicleDetailParameterDTO convertAFromDetailWebQuery(VehicleDataDetailWebQueryVO query) {
        VehicleDetailParameterDTO targetA = new VehicleDetailParameterDTO();
        targetA.setVehicleType(query.getVehicleTypeA());
        targetA.setCost(new BigDecimal(query.getCostA()));
        targetA.setWeight(new BigDecimal(query.getWeightA()));
        targetA.setLoad(new BigDecimal(query.getLoadA()));
        targetA.setLifeSpan(Integer.parseInt(query.getLifeSpanA()));
        targetA.setFactoryRepairYears(convertFromStr(query.getFactoryRepairYearsA()));
        targetA.setFactoryRepairCostList(convertFromStr(query.getFactoryRepairCostsA()));
        targetA.setSectionRepairInterval(new BigDecimal(query.getSectionRepairIntervalA()));
        targetA.setSectionRepairCostList(convertFromStr(query.getSectionRepairCostsA()));
        targetA.setCheckBackupRate(new BigDecimal(query.getCheckBackupRateA()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
        targetA.setBadCaseRate(new BigDecimal(query.getBadCaseRateA()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
        return targetA;
    }

    /**
     * 获取替换对象
     *
     * @param query
     * @return
     */
    public static VehicleDetailParameterDTO convertBFromDetailWebQuery(VehicleDataDetailWebQueryVO query) {
        VehicleDetailParameterDTO targetB = new VehicleDetailParameterDTO();
        targetB.setVehicleType(query.getVehicleTypeB());
        targetB.setCost(new BigDecimal(query.getCostB()));
        targetB.setWeight(new BigDecimal(query.getWeightB()));
        targetB.setLoad(new BigDecimal(query.getLoadB()));
        targetB.setLifeSpan(Integer.parseInt(query.getLifeSpanB()));
        targetB.setFactoryRepairYears(convertFromStr(query.getFactoryRepairYearsB()));
        targetB.setFactoryRepairCostList(convertFromStr(query.getFactoryRepairCostsB()));
        targetB.setSectionRepairInterval(new BigDecimal(query.getSectionRepairIntervalB()));
        targetB.setSectionRepairCostList(convertFromStr(query.getSectionRepairCostsB()));
        targetB.setCheckBackupRate(new BigDecimal(query.getCheckBackupRateB()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
        targetB.setBadCaseRate(new BigDecimal(query.getBadCaseRateB()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
        return targetB;
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
