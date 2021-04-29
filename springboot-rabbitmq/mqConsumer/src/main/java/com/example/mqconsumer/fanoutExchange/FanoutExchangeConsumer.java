package com.example.mqconsumer.fanoutExchange;

import com.example.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutExchangeConsumer {
    @RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_A))
    @RabbitHandler
    public void processA(Map<String, Object> map) {
        System.out.println("队列[" + RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_A + "]收到消息：" + map.toString());
    }

    @RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
    @RabbitHandler
    public void processB(Map<String, Object> map) {
        System.out.println("队列[" + RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B + "]收到消息：" + map.toString());
    }
}
