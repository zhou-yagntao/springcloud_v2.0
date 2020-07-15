package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: springcloud.controller
 * @ClassName: PaymentController
 * @Author: Justin
 * @Description:
 * @Date: 19:58 2020/7/8
 * @Version: 1.0
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String serverport;


    @RequestMapping("/payment/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos register,serverport:"+serverport+"id:"+id;
    }

}
