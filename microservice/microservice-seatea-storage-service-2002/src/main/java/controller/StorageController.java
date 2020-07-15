package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StorageService;

import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: OrderController
 * @Author: Justin
 * @Description:
 * @Date: 14:21 2020/7/9
 * @Version: 1.0
 */
@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/decrease")
    @ResponseBody
    @PostMapping(value = "/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId, @RequestParam("counts") BigDecimal count){

        this.storageService.update(productId, count);
    }
}
