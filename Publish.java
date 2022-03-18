import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publish {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String appId = argv.length < 1 ? "p0," : argv[0]+",";
            String message = "";
            for(int i=0; i<10000; i++) {
                message = appId + String.valueOf(i);
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
                Thread.sleep(500);
            }
            System.out.println("Done");
        }
    }

}
