package BehavorialPattern.Observer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class ChatServer extends WebSocketServer {

    private AddNewsAdapter addNewsAdapter;

    public  ChatServer(AddNewsAdapter addNewsAdapter, InetSocketAddress address){
        super(address);
        this.addNewsAdapter = addNewsAdapter;
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        webSocket.send("onOpen:: Hallo"); //This method sends a message to the new client
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        webSocket.send("onClose:: Tschüss Client");
    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {
        //webSocket.send("onMessage:: " + message);
        addNewsAdapter.newNews(message);
        System.out.println("onMessageServer:: " + message);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteBuffer message) {
        webSocket.send("onMessage:: (byte) " + message);
    }

    @Override
    public void onError(WebSocket webSocket, Exception exception) {
        webSocket.send("onError:: " + exception);
    }

    @Override
    public void onStart() {

    }

//    public static void main(String[] args) {
//        String host = "localhost";
//        int port = 8887;
//        ChatServer chatServer = new ChatServer(new InetSocketAddress(host, port));
//        chatServer.run();
//    }
}
