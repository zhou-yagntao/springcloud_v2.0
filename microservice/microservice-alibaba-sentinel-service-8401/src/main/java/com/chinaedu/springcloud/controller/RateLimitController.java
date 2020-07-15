package com.chinaedu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.myhandler.CustomerBlockHandler;
import com.chinaedu.springcloud.results.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: RateLimitController
 * @Author: Justin
 * @Description:
 * @Date: 18:00 2020/7/8
 * @Version: 1.0
 */
@Controller
@RequestMapping("/rateLimit")
public class RateLimitController {

    @RequestMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleExecption")
    public CommonResult byResource(){
        return  new CommonResult(200,"按照资源名限流成功");
    }

    @RequestMapping("/byurl")
    @SentinelResource(value = "byUri")
    public CommonResult byUrl(){
        return  new CommonResult(200,"按照资源名限流成功");
    }


    public CommonResult handleExecption(BlockException blockException){
        return  new CommonResult(444,blockException.getClass().getCanonicalName()+"服务不可用");
    }

    @RequestMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
                      blockHandlerClass = CustomerBlockHandler.class,
                      blockHandler = "handlerException2")
    public CommonResult CustomerBlockHandler(){
      return  new CommonResult(200,"按照用户自定义");
    }
}
