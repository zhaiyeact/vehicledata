package com.zhaiye.vehicle.data.service.impl;

import com.zhaiye.vehicle.data.base.TestBase;
import com.zhaiye.vehicle.data.common.dto.VehicleParameterDTO;
import com.zhaiye.vehicle.data.service.DataImportService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class DataImportServiceImplTest extends TestBase {

    @Autowired
    private DataImportService dataImportService;

    @Test
    public void readParam() {
        try {
            File file = ResourceUtils.getFile("classpath:data/testVehicleUsageData.xlsx");
            InputStream inputStream = new FileInputStream(file);
            List<VehicleParameterDTO> list = dataImportService.readParam(inputStream);
            Assert.assertTrue(!CollectionUtils.isEmpty(list));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void readDetailParam() {
    }

    @Test
    public void readExtraParam() {
    }
}