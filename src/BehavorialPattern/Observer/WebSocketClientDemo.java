package BehavorialPattern.Observer;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketClientDemo {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        String host = "ws://localhost:8887";

        ChatClient chatClient = new ChatClient(new URI(host));
        chatClient.connect();
        Thread.sleep(1000);
        chatClient.send("Die Kansas City Chiefs haben den SuperBowl gewonnen!|Sport");
    }
}
