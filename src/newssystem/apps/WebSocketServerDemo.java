package newssystem.apps;

import newssystem.layer.AbstractionLayer;
import newssystem.adapter.AddNewsAdapter;
import newssystem.model.*;
import newssystem.port.AddNewsPort;
import newssystem.port.RegisterPort;
import newssystem.websocket.ChatServer;

import java.net.InetSocketAddress;

public class WebSocketServerDemo {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8887;




        Newssystem newsSystem = new Newssystem();
        Receiver receiverA = new ReceiverImpl();
        Receiver receiverB = new ReceiverImpl();

        newsSystem.addCategory("Sport");
        newsSystem.addCategory("Politik");
        newsSystem.addCategory("Wirtschaft");

        AbstractionLayer abstractionLayer = new AbstractionLayer(newsSystem);
        RegisterPort registerPort = abstractionLayer;
        AddNewsPort addNewsPort = abstractionLayer;

        ParsingInterface parsingInterface = new PipeProtocolParser();
        AddNewsAdapter addNewsAdapter = new AddNewsAdapter(addNewsPort, parsingInterface);

        ChatServer chatServer = new ChatServer(addNewsAdapter, new InetSocketAddress(host, port));
        chatServer.start();

        registerPort.register(receiverA, "Sport");
        registerPort.register(receiverB, "Sport");
        registerPort.register(receiverB, "Politik");

        //addNewsPort.newNews(new News("Nachricht: Der FC ... hat gewonnen", "Sport"));
        //addNewsPort.newNews(new News("Nachricht: XYZ ist neuer Bundeskanzler", "Politik"));

//        Chef chef = new Chef(newsSystem);
//        chef.manageNews();
        ChefMockup chefMockup = new ChefMockup(newsSystem);
        Thread thread = new Thread(chefMockup);
        thread.start();

        //registerPort.unregister(receiverB, "Sport");
        //addNewsPort.newNews(new News("Nachricht: Der FC ... hat gewonnen", "Sport"));
        //addNewsPort.newNews(new News("Nachricht: XYZ ist neuer Bundeskanzler", "Politik"));

//        chef.manageNews();


    }

}
