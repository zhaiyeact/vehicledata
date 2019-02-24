package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.vo.ReplacementResultVO;
import com.zhaiye.vehicle.data.common.vo.ReplacementVO;
import com.zhaiye.vehicle.data.common.vo.ReplacementWebResultVO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link com.zhaiye.vehicle.data.common.vo.ReplacementWebResultVO}的转换器
 * @author zhaiye
 * on 2019/02/24
 */
public class ReplacementWebResultVOConverter {

    /**
     * 将{@link ReplacementVO}转换成{@link ReplacementWebResultVO}列表
     *
     * @param replacementVO
     * @return
     */
    public static List<ReplacementWebResultVO> convertFromReplacementVO(ReplacementVO replacementVO) {
        List<ReplacementWebResultVO> resultList = new ArrayList<>();
        List<ReplacementResultVO> replacementResultAList = replacementVO.getReplacementAResultList();
        List<ReplacementResultVO> replacementResultBList = replacementVO.getReplacementBResultList();
        List<BigDecimal> diffValueList = replacementVO.getDiffValueList();
        for(int i=0;i<diffValueList.size();i++){
            ReplacementWebResultVO result = new ReplacementWebResultVO();
            result.setDifferenceValue(Double.parseDouble(diffValueList.get(i).setScale(2,RoundingMode.HALF_UP).toString()));
            result.setTypeARemainDeprecationCost(Double.parseDouble(replacementResultAList.get(i).getRemainDeprecationCost().setScale(2,RoundingMode.HALF_UP).toString()));
            result.setTypeARemainFixCost(Double.parseDouble(replacementResultAList.get(i).getRemainFixCost().setScale(2,RoundingMode.HALF_UP).toString()));
            result.setTypeARemainRevenue(Double.parseDouble(replacementResultAList.get(i).getRemainRevenue().setScale(2,RoundingMode.HALF_UP).toString()));
            result.setTypeARemainIncome(Double.parseDouble(replacementResultAList.get(i).getRemainIncome().setScale(2,RoundingMode.HALF_UP).toString()));
            result.setTypeBIncome(Double.parseDouble(replacementResultBList.get(i).getReplacementTotalIncome().setScale(2,RoundingMode.HALF_UP).toString()));
            result.setDifferenceValue(Double.parseDouble(diffValueList.get(i).setScale(2,RoundingMode.HALF_UP).toString()));
            result.setYear(replacementResultAList.get(i).getYear().setScale(2,BigDecimal.ROUND_HALF_UP).toString());
            resultList.add(result);
        }
        return resultList;
    }
}
