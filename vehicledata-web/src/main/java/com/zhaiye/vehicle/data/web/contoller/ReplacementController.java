package com.zhaiye.vehicle.data.web.contoller;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.vo.ReplacementVO;
import com.zhaiye.vehicle.data.common.vo.ReplacementWebWrapperVO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataDetailWebQueryVO;
import com.zhaiye.vehicle.data.converter.ExtraParameterDTOConverter;
import com.zhaiye.vehicle.data.converter.ReplacementWebResultVOConverter;
import com.zhaiye.vehicle.data.converter.VehicleDetailParameterDTOConverter;
import com.zhaiye.vehicle.data.service.ReplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhaiye
 * on 2019/02/24
 */
@RestController
public class ReplacementController {

    @Autowired
    private ReplacementService replacementService;

    @RequestMapping(value = "/Replacement/calculate",method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ReplacementWebWrapperVO calculateReplacement(@RequestBody VehicleDataDetailWebQueryVO query) {
        ReplacementWebWrapperVO result = new ReplacementWebWrapperVO();
        VehicleDetailParameterDTO vehicleA = VehicleDetailParameterDTOConverter.convertAFromDetailWebQuery(query);
        VehicleDetailParameterDTO vehicleB = VehicleDetailParameterDTOConverter.convertBFromDetailWebQuery(query);
        ExtraParameterDTO extraParam = ExtraParameterDTOConverter.convertFromVehicleDataDetailQuery(query);
        ReplacementVO replacementVO = replacementService.calculateReplacement(vehicleA,vehicleB,extraParam);
        result.setResultList(ReplacementWebResultVOConverter.convertFromReplacementVO(replacementVO));
        result.setBestYear(replacementVO.getBestYear().setScale(1,BigDecimal.ROUND_HALF_UP).toString());
        return result;
    }

}
