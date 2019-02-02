package com.zhaiye.vehicle.data;

import com.zhaiye.vehicle.data.service.DataImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaiye
 * on 2019/02/02
 */
@Component
public class TestData {

    @Autowired
    private DataImportService dataImportService;

    public void test() {
        dataImportService.readParam(null);
    }
}
