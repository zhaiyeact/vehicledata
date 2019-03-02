package com.zhaiye.vehicle.data.web.contoller;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitWebResultVO;
import com.zhaiye.vehicle.data.common.vo.UsageWebWrapperVO;
import com.zhaiye.vehicle.data.common.vo.VehicleDataWebQueryVO;
import com.zhaiye.vehicle.data.converter.ExtraParameterDTOConverter;
import com.zhaiye.vehicle.data.converter.UsageLimitWebResultVOConverter;
import com.zhaiye.vehicle.data.converter.VehicleParameterDTOConverter;
import com.zhaiye.vehicle.data.service.UsageLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhaiye
 * on 2019/02/24
 */
@RestController
public class UsageLimitController {

    @Autowired
    private UsageLimitService usageLimitService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UsageLimitController.class);

    /**
     * 根据输入数据计算最佳使用年限并输出结果
     *
     * @param query 请求入参
     * @return
     */
    @RequestMapping(value = "/UsageLimit/calculate",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsageWebWrapperVO calculateUsageLimit(@RequestBody VehicleDataWebQueryVO query){
        try {
            UsageWebWrapperVO result = new UsageWebWrapperVO();
            VehicleParameterDTO vehicleParam = VehicleParameterDTOConverter.convertFromVehicleDataQueryVO(query);
            ExtraParameterDTO extraParam = ExtraParameterDTOConverter.convertFromVehicleDataQuery(query);
            UsageLimitVO usageLimitVO = usageLimitService.calculateUsageLimit(vehicleParam,extraParam);
            result.setResultList(UsageLimitWebResultVOConverter.convertFromUsageLimitVO(usageLimitVO));
            result.setLimitYear(usageLimitVO.getLimitYear().setScale(1,BigDecimal.ROUND_HALF_UP).toString());
            return result;
        }
        catch (Exception e){
            LOGGER.error("calculateUsageLimit异常,query:{}",query,e);
            return null;
        }
    }
}
