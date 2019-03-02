package com.zhaiye.vehicle.data.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 替换车型功能web层返回对象包装类
 * @author zhaiye
 * on 2019/03/02
 */
public class ReplacementWebWrapperVO implements Serializable {

    private static final long serialVersionUID = 3237137328603906179L;

    /**
     * 替换数据列表
     */
    private List<ReplacementWebResultVO> resultList;

    /**
     * 最佳替换年限
     */
    private String bestYear;

    public List<ReplacementWebResultVO> getResultList() {
        return resultList;
    }

    public void setResultList(List<ReplacementWebResultVO> resultList) {
        this.resultList = resultList;
    }

    public String getBestYear() {
        return bestYear;
    }

    public void setBestYear(String bestYear) {
        this.bestYear = bestYear;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacementWebWrapperVO{");
        sb.append("resultList=").append(resultList);
        sb.append(", bestYear='").append(bestYear).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
