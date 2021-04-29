package com.example.mqconsumer.directExchange;

import com.example.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//监听的队列的名字
@RabbitListener(queues = {RabbitMQConfig.RABBITMQ_DEMO_TOPIC})
public class RabbitMQConsumer {
    @RabbitHandler
    public void process(Map map) {
        System.out.println("队列[" + RabbitMQConfig.RABBITMQ_DEMO_TOPIC + "]收到消息：" + map.toString());
    }
}
