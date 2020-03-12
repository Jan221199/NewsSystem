package newssystem.websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

import newssystem.adapter.AddNewsAdapter;
import newssystem.adapter.RegisterAdapter;
import newssystem.model.Receiver;
import newssystem.model.ReceiverWebSocketAdapter;
import newssystem.model.RegisterParsingInterface;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class ChatServer extends WebSocketServer {

    private AddNewsAdapter addNewsAdapter;
    private RegisterAdapter registerAdapter;
    private HashMap<WebSocket , Receiver> receivers;

    public ChatServer(AddNewsAdapter addNewsAdapter,RegisterAdapter registerAdapter, InetSocketAddress address){
        super(address);
        this.addNewsAdapter = addNewsAdapter;
        this.registerAdapter = registerAdapter;
        this.receivers = new HashMap<>();
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
       String[] strings = message.split("\\|");
        if(strings[0].equals("N")){
            addNewsAdapter.newNews(String.join("|", Arrays.copyOfRange(strings, 1, strings.length))); // Rest der message übergeben
        }else if(strings[0].equals("R")){
            Receiver receiver = null;
            if(receivers.containsKey(webSocket) == false) {
                receiver = new ReceiverWebSocketAdapter(webSocket);
                receivers.put(webSocket, receiver);
            }else {
                receiver = receivers.get(webSocket);
            }
            registerAdapter.register(receiver, String.join("|", Arrays.copyOfRange(strings, 1, strings.length)));
        }else if(strings[0].equals("U")){
            if(receivers.containsKey(webSocket)) {
                Receiver receiver = receivers.get(webSocket);
                registerAdapter.unregister(receiver, String.join("|", Arrays.copyOfRange(strings, 1, strings.length)));
            }else {
                webSocket.send("Noch kein Receiver registriert!");
            }
        }
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
