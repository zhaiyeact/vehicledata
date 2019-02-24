package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataDetailWebQueryVO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataWebQueryVO;

import java.math.BigDecimal;

/**
 * {@link com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO}转换器
 * @author zhaiye
 * on 2019/02/24
 */
public class ExtraParameterDTOConverter {

    /**
     * 将{@link VehicleDataWebQueryVO}转换成{@link ExtraParameterDTO}
     *
     * @param query
     * @return
     */
    public static ExtraParameterDTO convertFromVehicleDataQuery(VehicleDataWebQueryVO query) {
        ExtraParameterDTO target= new ExtraParameterDTO();
        target.setTractiveWeight(new BigDecimal(query.getTractiveWeight()));
        return target;
    }

    /**
     * 将{@link VehicleDataDetailWebQueryVO}转换成{@link ExtraParameterDTO}
     *
     * @param query
     * @return
     */
    public static ExtraParameterDTO convertFromVehicleDataDetailQuery(VehicleDataDetailWebQueryVO query) {
        ExtraParameterDTO target = new ExtraParameterDTO();
        target.setTractiveWeight(new BigDecimal(query.getTractiveWeight()));
        target.setWorkDaysInYear(query.getWorkDaysInYear());
        target.setWorkTimeDuration(new BigDecimal(query.getWorkTimeDuration()));
        target.setAvgWorkDistance(new BigDecimal(query.getAvgWorkDistance()));
        target.setBasicPriceOne(new BigDecimal(query.getBasicPriceOne()));
        target.setBasicPriceTwo(new BigDecimal(query.getBasicPriceTwo()));
        return target;
    }
}
