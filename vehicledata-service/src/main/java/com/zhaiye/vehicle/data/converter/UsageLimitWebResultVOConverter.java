package com.zhaiye.vehicle.data.converter;

import com.zhaiye.vehicle.data.common.vo.UsageLimitVO;
import com.zhaiye.vehicle.data.common.vo.UsageLimitWebResultVO;
import com.zhaiye.vehicle.data.common.vo.UsageResultVO;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link UsageLimitWebResultVO}转换器
 * @author zhaiye
 * on 2019/02/24
 */
public class UsageLimitWebResultVOConverter {

    /**
     * 将{@link UsageLimitVO}转换成{@link UsageLimitWebResultVO}列表
     *
     * @param usageLimitVO
     * @return
     */
    public static List<UsageLimitWebResultVO> convertFromUsageLimitVO(UsageLimitVO usageLimitVO){
        List<UsageLimitWebResultVO> list = new ArrayList<>();
        for(UsageResultVO usageResultVO:usageLimitVO.getUsageResultVOList()){
            UsageLimitWebResultVO resultVO = new UsageLimitWebResultVO();
            resultVO.setAvgCost(Double.parseDouble(usageResultVO.getAvgCost().setScale(2,RoundingMode.HALF_UP).toString()));
            resultVO.setAvgFixCost(Double.parseDouble(usageResultVO.getAvgFixCost().setScale(2,RoundingMode.HALF_UP).toString()));
            resultVO.setAvgPurchaseCost(Double.parseDouble(usageResultVO.getAvgPurchaseCost().setScale(2,RoundingMode.HALF_UP).toString()));
            resultVO.setYear(usageResultVO.getYear().setScale(1,RoundingMode.HALF_UP).toString());
            list.add(resultVO);
        }
        return list;
    }
}
