package com.chinaedu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: ConfigClientController
 * @Author: Justin
 * @Description:
 * @Date: 10:06 2020/7/7
 * @Version: 1.0
 */
@Controller
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private  String configInfo;

    @RequestMapping("/getConfigInfo")
    @ResponseBody
    public String getConfigInfo(){
        return  configInfo;
    }
}
