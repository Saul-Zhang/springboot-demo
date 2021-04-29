package com.example.mqprovider.service;

import java.util.Map;

public interface RabbitMQService {
    String sendMsg(String msg) throws Exception;

    String sendMsgByTopicExchange(String msg, String routingKey) throws Exception;

    String sendMsgByFanoutExchange(String msg) throws Exception;

    String sendMsgByHeadersExchange(String msg, Map<String, Object> map) throws Exception;
}
