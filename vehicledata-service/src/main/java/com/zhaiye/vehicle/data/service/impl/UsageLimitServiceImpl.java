package com.zhaiye.vehicle.data.service.impl;

import com.zhaiye.vehicle.data.common.constant.FixType;
import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.FixCostVO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;
import com.zhaiye.vehicle.data.common.vo.UsageResultVO;
import com.zhaiye.vehicle.data.service.UsageLimitService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiye
 * on 2019/02/17
 */
@Service
public class UsageLimitServiceImpl implements UsageLimitService {

    /**
     * 根据车辆参数和额外参数，计算该车型的最佳使用年限
     *
     * @param vehicleParameterDTO 车辆参数
     * @param extraParameterDTO   额外参数
     * @return
     */
    @Override
    public UsageLimitVO calculateUsageLimit(VehicleParameterDTO vehicleParameterDTO, ExtraParameterDTO extraParameterDTO) {
        UsageLimitVO result = new UsageLimitVO();
        //编组辆数（辆）=向下取整[牵引质量/（自重+载重）]
        BigDecimal couches = extraParameterDTO.getTractiveWeight()
                .divide(vehicleParameterDTO.getWeight().add(vehicleParameterDTO.getLoad()),0,RoundingMode.DOWN);
        //整列购置成本（万元）=购置成本*编组辆数
        BigDecimal totalPurchaseCost = vehicleParameterDTO.getCost().multiply(couches);
        List<UsageResultVO> usageResultVOList = new ArrayList<>();
        int i = 0;
        for(BigDecimal year = new BigDecimal("0.5");
            year.compareTo(new BigDecimal(vehicleParameterDTO.getLifeSpan()))<=0;
            year = year.add(new BigDecimal("0.5")),i++){
            //每0.5年循环计算一次
            UsageResultVO usageResultVO = new UsageResultVO();
            usageResultVO.setYear(year);
            usageResultVO.setAvgPurchaseCost(totalPurchaseCost.divide(year,2,RoundingMode.HALF_UP));
            //计算当年的维修成本
            FixCostVO fixCostVO = calculateFixCostByYear(year,vehicleParameterDTO,couches);
            if(i > 0) {
                //不是第0.5年
                UsageResultVO lastUsageResult = usageResultVOList.get(i-1);
                usageResultVO.setTotalFixCost(lastUsageResult.getTotalFixCost().add(fixCostVO.getFixCost()));
            }
            else {
                //第0.5年
                usageResultVO.setTotalFixCost(fixCostVO.getFixCost());
            }
            usageResultVO.setAvgFixCost(usageResultVO.getTotalFixCost().divide(year,2,RoundingMode.HALF_UP));
            usageResultVO.setAvgCost(usageResultVO.getAvgPurchaseCost().add(usageResultVO.getAvgFixCost()));
            usageResultVOList.add(usageResultVO);
        }
        result.setCouches(couches.intValue());
        result.setUsageResultVOList(usageResultVOList);
        result.setLimitYear(findLimitYear(usageResultVOList));
        return result;
    }

    /**
     * 找到入参列表中的最低平均使用成本
     *
     * @param usageResultVOList
     * @return
     */
    private BigDecimal findLimitYear(List<UsageResultVO> usageResultVOList) {
        BigDecimal min = usageResultVOList.get(0).getAvgCost();
        BigDecimal year = usageResultVOList.get(0).getYear();
        for(UsageResultVO resultVO:usageResultVOList){
            if(min.compareTo(resultVO.getAvgCost()) > 0){
                min = resultVO.getAvgCost();
                year = resultVO.getYear();
            }
        }
        return year;
    }

    /**
     * 计算每年的维修成本。该年可能为厂修，也可能为段修。有厂修的年份没有段修
     *
     * @param year 年份
     * @param vehicleParameterDTO 车辆参数
     * @param couches 编组辆数
     * @return 该年的维修成本
     */
    @Override
    public FixCostVO calculateFixCostByYear(BigDecimal year, VehicleParameterDTO vehicleParameterDTO, BigDecimal couches){
        FixCostVO fixCostVO = new FixCostVO();
        fixCostVO.setYear(year);
        fixCostVO.setFixType(FixType.NONE);
        fixCostVO.setFixCost(new BigDecimal(0));
        //判断该年是否有厂修
        List<BigDecimal> factoryRepairYears = vehicleParameterDTO.getFactoryRepairYears();
        Integer factoryRepairTimes = calculateFactoryFixTimes(year,factoryRepairYears);
        if(factoryRepairTimes > 0) {
            fixCostVO.setFixType(FixType.FACTORY_FIX);
            //该年厂修成本为：第n次厂修成本*编组辆数
            fixCostVO.setFixTimes(factoryRepairTimes);
            if(factoryRepairTimes >= vehicleParameterDTO.getFactoryRepairCostList().size()){
                factoryRepairTimes = vehicleParameterDTO.getFactoryRepairCostList().size();
            }
            BigDecimal fixCost =  vehicleParameterDTO.getFactoryRepairCostList()
                    .get(factoryRepairTimes-1)
                    .multiply(couches);
            fixCostVO.setFixCost(fixCost);
            return fixCostVO;
        }
        //判断该年是否为段修
        BigDecimal sectionRepairInterval = vehicleParameterDTO.getSectionRepairInterval();
        if(year.compareTo(sectionRepairInterval) >= 0) {
            //年份大于段修间隔才可能段修
            BigDecimal[] divideArray = year.divideAndRemainder(sectionRepairInterval);
            if(divideArray[1].compareTo(new BigDecimal(0)) == 0) {
                Integer fixTimes = divideArray[0].intValue();
                fixCostVO.setFixTimes(fixTimes);
                if (fixTimes >= vehicleParameterDTO.getSectionRepairCostList().size()) {
                    fixTimes = vehicleParameterDTO.getSectionRepairCostList().size();
                }
                BigDecimal fixCost = vehicleParameterDTO.getSectionRepairCostList()
                        .get(fixTimes-1)
                        .multiply(couches);
                fixCostVO.setFixType(FixType.SECTION_FIX);
                fixCostVO.setFixCost(fixCost);
                return fixCostVO;
            }
        }
        return fixCostVO;
    }

    /**
     * 判断指定年份是第几次厂修。没有厂修则返回0
     *
     * @param year
     * @param factoryRepairYears
     * @return
     */
    private Integer calculateFactoryFixTimes(BigDecimal year,List<BigDecimal> factoryRepairYears) {
        for(int i=0;i<factoryRepairYears.size();i++){
            if(year.compareTo(factoryRepairYears.get(i)) == 0){
                //该年为厂修年份
                return i+1;
            }
        }
        return 0;
    }

}
