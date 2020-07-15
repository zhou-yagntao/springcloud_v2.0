package com.chinaedu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.netty.util.Timeout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: FlowLimitController
 * @Author: Justin
 * @Description:
 * @Date: 14:50 2020/7/8
 * @Version: 1.0
 */
@Controller
@RequestMapping("/flowLimit")
public class FlowLimitController {

    @RequestMapping("/testA")
    @ResponseBody
    public String testA(){
        return  "---------testA";
    }

    @RequestMapping("/testB")
    @ResponseBody
    public String testB(){
        return  "---------testB";
    }

    @RequestMapping("/testD")
    @ResponseBody
    public String testD(){
        /*try {
        //模仿本业务完成所用时间
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //模仿异常比例测试
        int a = 10/0;
        System.out.println(a);

        return  "---------testD";
    }

    @RequestMapping("/testE")
    @ResponseBody
    public String testE(){
        //模仿异常数测试
        int a = 10/0;
        System.out.println(a);
        return  "---------testE";
    }

    @RequestMapping("/testHotKey")
    @ResponseBody
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
      return  "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return  "-------deal_testHotKey,o(╥﹏╥)o";
    }
}
