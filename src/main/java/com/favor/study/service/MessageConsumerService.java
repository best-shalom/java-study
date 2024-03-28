package com.favor.study.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Qian
 * @version 1.0
 * @date 2024/3/27 17:17
 * @description 消息队列的消费者方法
 */

@Component
public class MessageConsumerService {

    /**
     * 监听指定消息队列
     * （消费者会建立长连接监听消息队列，一旦有消息到达就接收消息）
     */
    @RabbitListener(queues = "testQueue")
    public void handleMessage(Object message) {
        System.out.println("监听消息: " + message);
    }
}
