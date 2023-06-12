package com.example.rsi_projekt;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducentExchange {
    static String EXCHANGE_NAME = "Kolejka1";

    public void publishMessage(String exchangeKey, String msg) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            channel.basicPublish(EXCHANGE_NAME, exchangeKey, null, msg.getBytes("UTF-8"));
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
