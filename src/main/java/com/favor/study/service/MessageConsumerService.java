package com.favor.study.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Qian
 * @version 1.0
 * @date 2024/3/27 17:17
 * @description 消息队列的消费者方法
 */

@Component
public class MessageConsumerService {
    @Resource
    RabbitTemplate rabbitTemplate;

    /**
     * 监听指定消息队列
     * （消费者会建立长连接监听消息队列，一旦有消息到达就接收消息）
     */
    @RabbitListener(queues = "testQueue")
    public void handleMessage(Object message) {
        System.out.println("监听消息: " + message);
    }
}
