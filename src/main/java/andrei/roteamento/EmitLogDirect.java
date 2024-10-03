package andrei.roteamento;
//  https://www.rabbitmq.com/tutorials/tutorial-four-java

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");


            String severity = getSeverity(argv);
            String message = getMessage(argv) + " Ândrei de Medeiros Lucena";

            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Enviado'" + severity + ":" + message + "'");
        }
    }

    private static String getMessage(String[] argv) {
        return "";
    }

    private static String getSeverity(String[] argv) {
        return "";
    }
    //..
}
