package com.zhaiye.vehicle.data.web.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhaiye
 * on 2019/02/24
 */
@Controller
public class IndexController {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
