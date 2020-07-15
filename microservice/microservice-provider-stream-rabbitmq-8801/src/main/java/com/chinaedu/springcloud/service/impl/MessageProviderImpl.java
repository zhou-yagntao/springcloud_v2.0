package com.chinaedu.springcloud.service.impl;

import com.chinaedu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service.impl
 * @ClassName: MessageProviderImpl
 * @Author: Justin
 * @Description:
 * @Date: 16:10 2020/7/7
 * @Version: 1.0
 */
@EnableBinding(Source.class)  //定义消息发送管道
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel messageChannel;  //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
