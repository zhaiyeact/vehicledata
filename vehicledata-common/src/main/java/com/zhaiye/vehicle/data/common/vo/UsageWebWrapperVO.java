package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 最佳使用年限输出结果包装类
 *
 * @author zhaiye
 * on 2019/03/02
 */
public class UsageWebWrapperVO implements Serializable {

    private static final long serialVersionUID = -1003638636916146902L;

    private String limitYear;

    private List<UsageLimitWebResultVO> resultList;

    public String getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(String limitYear) {
        this.limitYear = limitYear;
    }

    public List<UsageLimitWebResultVO> getResultList() {
        return resultList;
    }

    public void setResultList(List<UsageLimitWebResultVO> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsageWebWrapperVO{");
        sb.append("limitYear='").append(limitYear).append('\'');
        sb.append(", resultList=").append(resultList);
        sb.append('}');
        return sb.toString();
    }
}
