package com.chinaedu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chinaedu.springcloud.results.CommonResult;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.myhandler
 * @ClassName: CustomerBlockHandler
 * @Author: Justin
 * @Description:
 * @Date: 18:27 2020/7/8
 * @Version: 1.0
 */
public class CustomerBlockHandler {

   public  static CommonResult handlerException(BlockException blockException){
       return  new CommonResult(444,"用户自定义，global-----1");
   }

    public  static CommonResult handlerException2(BlockException blockException){
        return  new CommonResult(444,"用户自定义，global-----2");
    }
}
