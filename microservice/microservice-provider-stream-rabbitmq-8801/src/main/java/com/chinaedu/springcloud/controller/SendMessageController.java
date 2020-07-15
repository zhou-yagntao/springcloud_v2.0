package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: SendMessageController
 * @Author: Justin
 * @Description:
 * @Date: 16:17 2020/7/7
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sendmessage")
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @RequestMapping("/send")
    @ResponseBody
    public String sendMessage(){
     return  this.iMessageProvider.send();
    }
}
