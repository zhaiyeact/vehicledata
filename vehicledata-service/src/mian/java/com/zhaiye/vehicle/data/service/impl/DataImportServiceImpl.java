package com.zhaiye.vehicle.data.service.impl;

import com.sargeraswang.util.ExcelUtil.ExcelLogs;
import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import com.zhaiye.vehicle.data.common.dto.ExtraParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleDetailParameterDTO;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.common.vo.VehicleUsageLimitParamVO;
import com.zhaiye.vehicle.data.converter.VehicleParameterDTOConverter;
import com.zhaiye.vehicle.data.service.DataImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认实现
 *
 * @author  zhaiye
 * on 2019/01/31
 */
@Service
public class DataImportServiceImpl implements DataImportService {

    private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    private static final Logger LOGGER = LoggerFactory.getLogger(DataImportServiceImpl.class);

    /**
     * 从输入流中，将excel数据转换成{@link VehicleParameterDTO}对象,提供同车型计算最佳使用年限
     *
     * @param inputStream
     * @return
     */
    @Override
    public List<VehicleParameterDTO> readParam(InputStream inputStream) {
        try {
            ExcelLogs logs = new ExcelLogs();
            Collection<VehicleUsageLimitParamVO> paramCollection =
                    ExcelUtil.importExcel(VehicleUsageLimitParamVO.class, inputStream, DATE_FORMAT, logs, 17);
            if(CollectionUtils.isEmpty(paramCollection)){
                return new ArrayList<>();
            }
            List<VehicleParameterDTO> result = paramCollection.stream()
                    .map(vo->VehicleParameterDTOConverter.convertFromVO(vo))
                    .collect(Collectors.toList());
            return result;
        }
        catch (Exception e){
            LOGGER.error("DataImportService.readParam exception ",e);
            return new ArrayList<>();
        }
    }

    /**
     * 从输入流中，将excel数据转换成{@link VehicleDetailParameterDTO}。以供不同车型计算最佳替换年限
     *
     * @param inputStream
     * @return
     */
    @Override
    public List<VehicleDetailParameterDTO> readDetailParam(InputStream inputStream) {
        return null;
    }

    /**
     * 从输入流中，将excel数据转换成{@link ExtraParameterDTO}
     *
     * @param inputStream
     * @return
     */
    @Override
    public ExtraParameterDTO readExtraParam(InputStream inputStream) {
        return null;
    }
}
