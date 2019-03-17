package com.nimo.mq;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息生产者
 */
@Service
public class MessageProducer {

    @Resource(name="amqpTemplate")  
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) throws IOException {  
        amqpTemplate.convertAndSend("queueTestKey", message);
    }  
}