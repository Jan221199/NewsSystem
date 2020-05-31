package newssystem.model;

import org.java_websocket.WebSocket;

//Receiver as Websocket
public class ReceiverWebSocketAdapter implements Receiver {
    private WebSocket webSocket;

    public ReceiverWebSocketAdapter(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    @Override
    public void update(News news) {
        webSocket.send(news.getHeadline());
    }
}
