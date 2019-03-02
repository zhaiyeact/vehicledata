package com.zhaiye.vehicle.data.service.impl;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.vo.FixCostVO;
import com.zhaiye.vehicle.data.common.vo.ReplacementResultVO;
import com.zhaiye.vehicle.data.common.vo.ReplacementVO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;
import com.zhaiye.vehicle.data.service.ReplacementService;
import com.zhaiye.vehicle.data.service.UsageLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaiye
 * on 2019/02/23
 */
@Service
public class ReplacementServiceImpl implements ReplacementService {

    @Autowired
    private UsageLimitService usageLimitService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReplacementServiceImpl.class);

    /**
     * 计算车型替换结果数据
     *
     * @param vehicleA   被替换车辆
     * @param vehicleB   替换车辆
     * @param extraParam 额外数据
     * @return
     */
    @Override
    public ReplacementVO calculateReplacement(VehicleDetailParameterDTO vehicleA, VehicleDetailParameterDTO vehicleB, ExtraParameterDTO extraParam) {
        try {
            ReplacementVO replacementA = calculateReplacementCommonParam(vehicleA, extraParam);
            List<ReplacementResultVO> replacementAResultList = calculateVehicleAResultList(replacementA, vehicleA);
            replacementA.setReplacementAResultList(replacementAResultList);
            ReplacementVO replacementB = calculateReplacementCommonParam(vehicleB, extraParam);
            List<ReplacementResultVO> replacementBResultList = calculateVehicleBResultList(replacementB, vehicleB);
            replacementA.setReplacementBResultList(replacementBResultList);
            List<BigDecimal> differenceList = calculateDifference(replacementA);
            replacementA.setDiffValueList(differenceList);
            replacementA.setVehicleTypeA(vehicleA.getVehicleType());
            replacementA.setVehicleTypeB(vehicleB.getVehicleType());
            replacementA.setBestYear(findBestYear(replacementBResultList,differenceList));
            return replacementA;
        }
        catch (Exception e){
            LOGGER.error("calculateReplacement异常,vehicleA:{},vehicleB:{}",vehicleA,vehicleB,e);
            return null;
        }
    }

    /**
     * 计算最佳替换年限
     *
     * @param replacementBResultList 替换车型数据列表
     * @param diffValueList 效益差值列表
     * @return
     */
    private BigDecimal findBestYear(List<ReplacementResultVO> replacementBResultList,List<BigDecimal> diffValueList){
       BigDecimal maxDiff = diffValueList.get(0);
       Integer index = 0;
       for(int i=0;i<diffValueList.size();i++){
           if(maxDiff.compareTo(diffValueList.get(i)) < 0){
               index = i;
               maxDiff = diffValueList.get(i);
           }
       }
       return replacementBResultList.get(index).getYear();
    }

    /**
     * 计算替换车辆和被替换车辆每年的效益差值
     *
     * @param replacementVO
     * @return
     */
    private List<BigDecimal> calculateDifference(ReplacementVO replacementVO){
        List<ReplacementResultVO> replacementResultAList = replacementVO.getReplacementAResultList();
        List<ReplacementResultVO> replacementResultBList = replacementVO.getReplacementBResultList();
        List<BigDecimal> resultList = new ArrayList<>();
        for(int i=0;i<replacementResultAList.size();i++){
            ReplacementResultVO resultA = replacementResultAList.get(i);
            ReplacementResultVO resultB = replacementResultBList.get(i);
            BigDecimal result = resultB.getReplacementTotalIncome()
                    .subtract(resultA.getRemainIncome())
                    .subtract(resultA.getRemainDeprecationCost());
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 计算通用参数
     *
     * @param vehicleParam
     * @param extraParam
     * @return
     */
    private ReplacementVO calculateReplacementCommonParam(VehicleDetailParameterDTO vehicleParam,ExtraParameterDTO extraParam) {
        ReplacementVO replacementVO = new ReplacementVO();
        //周转次数=一年天数*（1-检备率）/周转时间
        BigDecimal runCount =new BigDecimal("1.00").subtract(vehicleParam.getCheckBackupRate())
                .multiply(new BigDecimal(extraParam.getWorkDaysInYear()))
                .divide(extraParam.getWorkTimeDuration(),10,BigDecimal.ROUND_HALF_UP);
        //编组辆数（辆）=向下取整[牵引质量/（自重+载重）]
        BigDecimal couches = extraParam.getTractiveWeight()
                .divide(vehicleParam.getWeight().add(vehicleParam.getLoad()),0,RoundingMode.DOWN);
        //整列载重能力（吨）=载重*编组辆数
        BigDecimal totalLoad = vehicleParam.getLoad().multiply(couches);
        //整列车辆公里（吨公里）=整列载重能力*平均运距
        BigDecimal totalWorkDistance = totalLoad.multiply(extraParam.getAvgWorkDistance());
        //整列运输收入（万元）=（整列载重能力*货物4号运价基价1+整列车辆公里*货物4号运价基价2）*周转次数/10000
        BigDecimal totalRevenue = totalLoad.multiply(extraParam.getBasicPriceOne())
                .add(totalWorkDistance.multiply(extraParam.getBasicPriceTwo()))
                .multiply(runCount).divide(new BigDecimal("10000"));
        UsageLimitVO usageLimitVO = usageLimitService.calculateUsageLimit(vehicleParam,extraParam);
        //折旧率=（1-残值率）/最佳使用年限
        BigDecimal deprecationRate = new BigDecimal("1.00").subtract(vehicleParam.getBadCaseRate())
                .divide(usageLimitVO.getLimitYear(),10,BigDecimal.ROUND_HALF_UP);
        //整列购置成本（万元）=购置成本*编组辆数
        BigDecimal totalPurchaseCost = vehicleParam.getCost().multiply(couches);
        Integer limitYearFixCostIndex = usageLimitVO.getLimitYear().divide(new BigDecimal("0.5")).intValue()-1;
        replacementVO.setRunCount(runCount);
        replacementVO.setTotalLoad(totalLoad);
        replacementVO.setTotalWorkDistance(totalWorkDistance);
        replacementVO.setTotalRevenue(totalRevenue);
        replacementVO.setDeprecationRate(deprecationRate);
        replacementVO.setLimitYear(usageLimitVO.getLimitYear());
        replacementVO.setCouches(couches);
        replacementVO.setTotalPurchaseCost(totalPurchaseCost);
        replacementVO.setTotalFixCost(usageLimitVO.getUsageResultVOList().get(limitYearFixCostIndex).getTotalFixCost());
        return replacementVO;
    }

    /**
     * 计算被替换车辆每年输出结果列表
     *
     * @param replacementVO
     * @param vehicleA
     * @return
     */
    private List<ReplacementResultVO> calculateVehicleAResultList(ReplacementVO replacementVO,VehicleDetailParameterDTO vehicleA) {
        List<ReplacementResultVO> resultList = new ArrayList<>();
        for(BigDecimal year=new BigDecimal("0.5");
            year.compareTo(replacementVO.getLimitYear())<=0;
            year = year.add(new BigDecimal("0.5"))){
            //第N年折旧费（万元）=整列购置成本*折旧率*0.5
            BigDecimal deprecationCost = replacementVO.getTotalPurchaseCost()
                    .multiply(replacementVO.getDeprecationRate())
                    .multiply(new BigDecimal("0.5"));
            //第N年运输收入（万元）=整列运输收入*0.5
            BigDecimal revenue = replacementVO.getTotalRevenue().multiply(new BigDecimal("0.5"));
            //剩余折旧费（万元）=整列购置成本*折旧率*（最佳使用年限-X）
            BigDecimal remainDeprecationCost = replacementVO.getTotalPurchaseCost()
                    .multiply(replacementVO.getDeprecationRate())
                    .multiply(replacementVO.getLimitYear().subtract(year));
            //剩余维修费
            BigDecimal remainFixCost = calculateRemainFixCost(year,replacementVO,vehicleA);
            //剩余运输收入（万元）=整列运输收入*（最佳使用年限-X）
            BigDecimal remainRevenue = replacementVO.getTotalRevenue().multiply(replacementVO.getLimitYear().subtract(year));
            //剩余收益（万元）=剩余运输收入-剩余折旧费-剩余维修费
            BigDecimal remainIncome = remainRevenue.subtract(remainDeprecationCost).subtract(remainFixCost);
            ReplacementResultVO resultVO = new ReplacementResultVO();
            resultVO.setDeprecationCost(deprecationCost);
            resultVO.setRevenue(revenue);
            resultVO.setRemainDeprecationCost(remainDeprecationCost);
            resultVO.setRemainFixCost(remainFixCost);
            resultVO.setRemainRevenue(remainRevenue);
            resultVO.setRemainIncome(remainIncome);
            resultVO.setYear(year);
            resultList.add(resultVO);
        }
        return resultList;
    }

    /**
     * 计算替换车辆每年输出结果列表
     *
     * @param replacementVO
     * @param vehicleB
     * @return
     */
    private List<ReplacementResultVO> calculateVehicleBResultList(ReplacementVO replacementVO,VehicleDetailParameterDTO vehicleB) {
        List<ReplacementResultVO> resultList = new ArrayList<>();
        //总折旧费（万元）=整列购置成本*折旧率*最佳使用年限
        BigDecimal totalDeprecationCost = replacementVO.getTotalPurchaseCost()
                .multiply(replacementVO.getDeprecationRate())
                .multiply(replacementVO.getLimitYear());
        //总运输收入（万元）=整列运输收入*最佳使用年限
        BigDecimal totalRevenue = replacementVO.getTotalRevenue().multiply(replacementVO.getLimitYear());
        BigDecimal totalFixCost = replacementVO.getTotalFixCost();
        //年均收益（万元）=（总运输收入-总折旧费-总维修费）/最佳使用年限
        BigDecimal avgIncome =totalRevenue.subtract(totalDeprecationCost).subtract(totalFixCost)
                .divide(replacementVO.getLimitYear(),2,BigDecimal.ROUND_HALF_UP);
        for(BigDecimal year=new BigDecimal("0.5");
            year.compareTo(replacementVO.getLimitYear())<=0;
            year = year.add(new BigDecimal("0.5"))){
            ReplacementResultVO resultVO = new ReplacementResultVO();
            //替换车型的总收益（万元）=年均收益*（被替换车型的最佳使用年限-X）
            BigDecimal replacementTotalIncome = avgIncome.multiply(replacementVO.getLimitYear().subtract(year));
            resultVO.setReplacementTotalIncome(replacementTotalIncome);
            resultVO.setYear(year);
            resultList.add(resultVO);
        }
        return resultList;
    }

    /**
     * 计算在第year年被替换时，剩余的维修费用
     *
     * @param year
     * @param replacementVO
     * @param vehicleParam
     * @return
     */
    private BigDecimal calculateRemainFixCost(BigDecimal year,
                                              ReplacementVO replacementVO,VehicleDetailParameterDTO vehicleParam) {
        BigDecimal remainFixCost = new BigDecimal("0");
        for(BigDecimal x=new BigDecimal(year.toString()).add(new BigDecimal("0.5"));
                x.compareTo(replacementVO.getLimitYear()) <=0;
                x = x.add(new BigDecimal("0.5"))
                ){
            FixCostVO fixCostVO = usageLimitService.calculateFixCostByYear(x,vehicleParam,replacementVO.getCouches());
            remainFixCost = remainFixCost.add(fixCostVO.getFixCost());
        }
        return remainFixCost;
    }
}
