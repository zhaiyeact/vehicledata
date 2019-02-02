package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.VehicleUsageLimitParamVO;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 将各类对象转换为 {@link VehicleParameterDTO}
 *
 * created by zhaiye
 * on 2019/01/31
 */
public class VehicleParameterDTOConverter {

    /**
     * 将{@link VehicleUsageLimitParamVO}转换成{@link VehicleParameterDTO}
     *
     * @param vo
     * @return
     */
    public static VehicleParameterDTO convertFromVO(VehicleUsageLimitParamVO vo) {
        Assert.notNull(vo,"VehicleUsageLimitParamVO不能为空");
        VehicleParameterDTO target = new VehicleParameterDTO();
        target.setVehicleType(vo.getVehicleType());
        target.setWeight(new BigDecimal(vo.getWeight()));
        target.setLoad(new BigDecimal(vo.getLoad()));
        target.setCost(new BigDecimal(vo.getCost()));
        target.setLifeSpan(vo.getLifeSpan());
        target.setFactoryRepairCostList(getFactoryCostListFromVO(vo));
        target.setSectionRepairCostList(getSectionCostListFromVO(vo));
        return target;
    }

    /**
     * 通过vo获取厂修开销列表
     *
     * @param vo
     * @return
     */
    private static List<BigDecimal> getFactoryCostListFromVO(VehicleUsageLimitParamVO vo) {
        List<BigDecimal> list = new ArrayList<>(3);
        list.add(new BigDecimal(vo.getFactoryRepair1()));
        list.add(new BigDecimal(vo.getFactoryRepair2()));
        list.add(new BigDecimal(vo.getFactoryRepair3()));
        return list;
    }

    /**
     * 通过vo获取段修开销列表
     *
     * @param vo
     * @return
     */
    private static List<BigDecimal> getSectionCostListFromVO(VehicleUsageLimitParamVO vo) {
        List<BigDecimal> list = new ArrayList<>(9);
        list.add(new BigDecimal(vo.getSectionRepair1()));
        list.add(new BigDecimal(vo.getSectionRepair2()));
        list.add(new BigDecimal(vo.getSectionRepair3()));
        list.add(new BigDecimal(vo.getSectionRepair4()));
        list.add(new BigDecimal(vo.getSectionRepair5()));
        list.add(new BigDecimal(vo.getSectionRepair6()));
        list.add(new BigDecimal(vo.getSectionRepair7()));
        list.add(new BigDecimal(vo.getSectionRepair8()));
        list.add(new BigDecimal(vo.getSectionRepair9()));
        return list;
    }
}
