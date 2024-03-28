package com.favor.study.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Qian
 * @version 1.0
 * @date 2024/3/27 17:15
 * @description Rabbit消息队列的生产者方法
 */

@Component
public class MessageProducerService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        //没有指定交换机会走默认的交换机，AMQP default,AMQP default是一个direct路由模式的交换机
        rabbitTemplate.convertAndSend("testQueue", message);
        System.out.println("发送消息: " + message);
    }
}