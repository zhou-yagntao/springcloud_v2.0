package com.chinaedu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: ReceiveMessageListnerController
 * @Author: Justin
 * @Description:
 * @Date: 16:52 2020/7/7
 * @Version: 1.0
 */
@Component
@EnableBinding(Sink.class)
@RequestMapping("/receiveMessageListner")
public class ReceiveMessageListnerController {

    @Value("${server.port}")
    private String serverport;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号，----->接收的消息"+message.getPayload()+"端口号"+serverport);
    }
}
