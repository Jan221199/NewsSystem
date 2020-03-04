package newssystem.apps;

import newssystem.model.Receiver;
import newssystem.model.ReceiverImpl;
import newssystem.websocket.ChatClient;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketClientDemo {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        String host = "ws://localhost:8887";

        ChatClient chatClient = new ChatClient(new URI(host));
        chatClient.connect();
        Thread.sleep(1000);

        Receiver receiverA = new ReceiverImpl();
        Receiver receiverB = new ReceiverImpl();
        chatClient.send("receiverA|Sport");
        chatClient.send("receiverB|Sport");
        chatClient.send("receiverB|Politik");

        chatClient.send("Die Kansas City Chiefs haben den SuperBowl gewonnen!|Sport");
        chatClient.send("XYZ ist neuer Bundeskanzler|Politik");
    }
}
