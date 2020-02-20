package BehavorialPattern.Observer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

public class ChatClient extends WebSocketClient {

    public ChatClient(URI uri){
        super(uri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("onOpen:: " + serverHandshake);
    }

    @Override
    public void onMessage(String message) {
        System.out.println("onMessage:: " + message);
        //this.send("onMessage::" + message);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("onClose:: Tschüss Server");
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("onError:: " + exception.toString());
    }

//    public static void main(String[] args) throws URISyntaxException {
//        String host = "ws://localhost:8887";
//
//        ChatClient chatClient = new ChatClient(new URI(host));
//        chatClient.connect();
//    }
}
