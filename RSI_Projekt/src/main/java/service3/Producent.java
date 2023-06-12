package service3;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Producent {

    static class RPCClient implements AutoCloseable{
        static Connection connection;
        static Channel channel;
        RPCClient()
        {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            String msg;
            try {
                connection = factory.newConnection();
                channel = connection.createChannel();
                channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
                for(int i = 0; i < HOW_MANY_MESSAGES; i++) {
                    Thread.sleep(1000);
                    msg = "Message " + i;
                    channel.basicPublish("", RPC_QUEUE_NAME, null, msg.getBytes("UTF-8"));
                }
                channel.close();
                connection.close();
            } catch (IOException | InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }

        String call(String msg) throws IOException, ExecutionException, InterruptedException {
            String correlationID = UUID.randomUUID().toString();
            String replyQName = channel.queueDeclare().getQueue();

            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(correlationID)
                    .replyTo(replyQName)
                    .build();

            channel.basicPublish("", RPC_QUEUE_NAME, props, msg.getBytes("UTF-8"));
            CompletableFuture<String> response = new CompletableFuture<>();
            String tag = channel.basicConsume(replyQName, true, (consumerTag, returnMsg) -> {
                if (returnMsg.getProperties().getCorrelationId().equals(correlationID)) response.complete(new String(returnMsg.getBody(), "UTF-8"));

            }, consumerTag -> {});
            String result= response.get();
            channel.basicCancel(tag);

            return result;
        }

        public void close() throws Exception {
            channel.close();
            connection.close();
        }
    }
    static String RPC_QUEUE_NAME = "Kolejka3";
    static int HOW_MANY_MESSAGES = 10;
    public static void main(String[] args) {
       try{
           RPCClient client = new RPCClient();
           client.call("ELOOOO");
       }
       catch (IOException | InterruptedException | ExecutionException e) {
           throw new RuntimeException(e);
       }

    }
}