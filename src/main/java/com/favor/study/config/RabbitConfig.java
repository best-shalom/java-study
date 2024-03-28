package com.favor.study.config;

import com.rabbitmq.client.ConnectionFactory;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Qian
 * @version 1.0
 * @date 2024/3/27 16:50
 * @description RabbitMQ服务器配置
 */

@Configuration
public class RabbitConfig {
    /**
     * 通过创建一个名为 connectionFactory 的 Bean 来配置 RabbitMQ 的连接信息。
     * 在这个 Bean 方法上使用 @Bean 注解，告诉 Spring 这是一个 Bean 的定义，Spring 会调用这个方法来创建名为 connectionFactory 的 Bean，并将其纳入到 Spring 容器中。
     * 当其他地方需要使用 RabbitMQ 连接工厂时（比如 RabbitTemplate 或者其他组件），Spring 会自动检测到容器中已有的 connectionFactory Bean，并注入到需要它的地方。
     * 这样就实现了对 RabbitMQ 连接信息的统一管理和配置。
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        String host="localhost";
        int port=5672;
        String user="guest";
        String password="guest";
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(user);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    /**
     * springboot启动时就会扫描Configuration下的bean，将其注入到spring容器，因此也会调用此方法创建队列
     */
    @Bean
    public Queue createQueue(){
        return new Queue("testQueue");
    }
}
