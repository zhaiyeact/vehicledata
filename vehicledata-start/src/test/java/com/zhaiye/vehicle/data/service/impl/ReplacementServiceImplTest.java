package com.zhaiye.vehicle.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zhaiye.vehicle.data.base.TestBase;
import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.ReplacementVO;
import com.zhaiye.vehicle.data.service.ReplacementService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ReplacementServiceImplTest extends TestBase {

    @Autowired
    private ReplacementService replacementService;

    @Test
    public void calculateReplacement() {
        ReplacementVO result = replacementService.calculateReplacement(buildVehicleParamA(),buildVehicleParamB(),buildExtraParameter());
        Assert.assertTrue(result != null);
        System.out.println(JSON.toJSONString(result));
    }

    private VehicleDetailParameterDTO buildVehicleParamA() {
        VehicleDetailParameterDTO param = new VehicleDetailParameterDTO();
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
        param.setCheckBackupRate(new BigDecimal("0.05"));
        param.setBadCaseRate(new BigDecimal("0.04"));
        return param;
    }

    private VehicleDetailParameterDTO buildVehicleParamB() {
        VehicleDetailParameterDTO param = new VehicleDetailParameterDTO();
        param.setVehicleType("C80E");
        param.setWeight(new BigDecimal("26.5"));
        param.setLoad(new BigDecimal("80"));
        param.setLifeSpan(25);
        param.setCost(new BigDecimal("49.5"));
        param.setFactoryRepairYears(Lists.newArrayList(new BigDecimal("10"),new BigDecimal("18")));
        param.setFactoryRepairCostList(Lists.newArrayList(new BigDecimal("8.54"),new BigDecimal("8.83")));
        param.setSectionRepairInterval(new BigDecimal("2"));
        param.setSectionRepairCostList(Lists.newArrayList(new BigDecimal("1.87"),new BigDecimal("2.08"),
                new BigDecimal("2.28"),new BigDecimal("2.49")));
        param.setCheckBackupRate(new BigDecimal("0.05"));
        param.setBadCaseRate(new BigDecimal("0.04"));
        return param;
    }

    private ExtraParameterDTO buildExtraParameter(){
        ExtraParameterDTO param = new ExtraParameterDTO();
        param.setTractiveWeight(new BigDecimal("10000"));
        param.setAvgWorkDistance(new BigDecimal("802"));
        param.setWorkTimeDuration(new BigDecimal("4.87"));
        param.setWorkDaysInYear(365);
        param.setBasicPriceOne(new BigDecimal("16.3"));
        param.setBasicPriceTwo(new BigDecimal("0.098"));
        return param;
    }
}