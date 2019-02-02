package com.zhaiye.vehicle.data.service;

import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;

import java.io.InputStream;
import java.util.List;

/**
 * 将Excel数据转化为结构化数据
 *
 * @author zhaiye
 * on 2019/01/31
 */
public interface DataImportService {

    /**
     * 从输入流中，将excel数据转换成{@link VehicleParameterDTO}对象,提供同车型计算最佳使用年限
     *
     * @param inputStream
     * @return
     */
    List<VehicleParameterDTO> readParam(InputStream inputStream);

    /**
     * 从输入流中，将excel数据转换成{@link VehicleDetailParameterDTO}。以供不同车型计算最佳替换年限
     *
     * @param inputStream
     * @return
     */
    List<VehicleDetailParameterDTO> readDetailParam(InputStream inputStream);

    /**
     * 从输入流中，将excel数据转换成{@link ExtraParameterDTO}
     * @param inputStream
     * @return
     */
    ExtraParameterDTO readExtraParam(InputStream inputStream);

}
