package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.results.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: AccountService
 * @Author: Justin
 * @Description:
 * @Date: 13:59 2020/7/9
 * @Version: 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId ,@RequestParam("money") BigDecimal money);
}