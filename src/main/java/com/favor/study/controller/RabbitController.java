package com.favor.study.controller;

import com.favor.study.service.MessageProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Qian
 * @version 1.0
 * @date 2024/3/28 11:25
 * @description 测试rabbit消息队列
 */
@RequestMapping("/rabbit")
@Controller
public class RabbitController {
    @Resource
    private MessageProducerService messageProducerService;

    /**
     * 调用消息生产者，消费者会自动监听队列消息，从而自动触发getMessage，打印出接收的消息
     * @param message 发送指定消息
     */
    @RequestMapping("/send")
    public void send(String message){
        messageProducerService.sendMessage(message);
    }

}
