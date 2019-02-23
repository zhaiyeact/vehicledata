package com.zhaiye.vehicle.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zhaiye.vehicle.data.base.TestBase;
import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;
import com.zhaiye.vehicle.data.service.UsageLimitService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UsageLimitServiceImplTest extends TestBase {

    @Autowired
    private UsageLimitService usageLimitService;

    @Test
    public void calculateUsageLimit() {
        UsageLimitVO usageLimitVO = usageLimitService.calculateUsageLimit(buildVehicleParameters(),buildExtraParameter());
        Assert.assertTrue(usageLimitVO != null);
        System.out.println(JSON.toJSONString(usageLimitVO));
    }

    private VehicleParameterDTO buildVehicleParameters() {
        VehicleParameterDTO param = new VehicleParameterDTO();
        param.setVehicleType("C64");
        param.setWeight(new BigDecimal("22.5"));
        param.setLoad(new BigDecimal("61"));
        param.setLifeSpan(25);
        param.setCost(new BigDecimal("31.5"));
        param.setFactoryRepairYears(Lists.newArrayList(new BigDecimal("9"),new BigDecimal("18")));
        param.setFactoryRepairCostList(Lists.newArrayList(new BigDecimal("5.54"),new BigDecimal("5.83")));
        param.setSectionRepairInterval(new BigDecimal("1.5"));
        param.setSectionRepairCostList(Lists.newArrayList(new BigDecimal("1.87"),new BigDecimal("2.08"),
                new BigDecimal("2.28"),new BigDecimal("2.49")));
        return param;
    }

    private ExtraParameterDTO buildExtraParameter(){
        ExtraParameterDTO param = new ExtraParameterDTO();
        param.setTractiveWeight(new BigDecimal("10000"));
        return param;
    }

}