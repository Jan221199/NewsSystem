package newssystem.apps;

import newssystem.model.Receiver;
import newssystem.model.ReceiverImpl;
import newssystem.websocket.ChatClient;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketClientDemo {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        String host = "ws://localhost:8887";

        //connecting Client to Server
        ChatClient chatClient = new ChatClient(new URI(host));
        chatClient.connect();
        Thread.sleep(1000);

        //Client beim Newssystem registrieren
        chatClient.send("R|Sport");

        //neue Nachricht erstellen
        chatClient.send("N|Die Kansas City Chiefs haben den SuperBowl gewonnen!|Sport");
        chatClient.send("N|XYZ ist neuer Bundeskanzler|Politik");
    }
}
