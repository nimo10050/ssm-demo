package com.nimo.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 消息接收者
 */
public class MessageConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("consumer receive message------->: "+ new String(message.getBody()));
        
    }

}