package newssystem.apps;

import newssystem.adapter.DatenbankAdapter;
import newssystem.adapter.RegisterAdapter;
import newssystem.layer.AbstractionLayer;
import newssystem.adapter.AddNewsAdapter;
import newssystem.model.*;
import newssystem.port.AddNewsPort;
import newssystem.port.DatenbankPort;
import newssystem.port.RegisterPort;
import newssystem.websocket.ChatServer;

import java.net.InetSocketAddress;

public class WebSocketServerDemo {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8887;

//        DatenbankPort datenbankPort = new DatenbankMockup();
        DatenbankPort datenbankPort = new DatenbankAdapter();
        datenbankPort.insertNews(new News("BlaBlaBla0", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla1", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla2", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla3", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla4", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla5", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla6", "Sport"));
        datenbankPort.insertNews(new News("BlaBlaBla7", "Sport"));
        Newssystem newsSystem = new Newssystem(datenbankPort);
//        Receiver receiverA = new ReceiverImpl();
//        Receiver receiverB = new ReceiverImpl();

        datenbankPort.deleteNews(new News("BlaBlaBla0", "Sport"));

        newsSystem.addCategory("Sport");
        newsSystem.addCategory("Politik");
        newsSystem.addCategory("Wirtschaft");

        AbstractionLayer abstractionLayer = new AbstractionLayer(newsSystem);
        RegisterPort registerPort = abstractionLayer;
        AddNewsPort addNewsPort = abstractionLayer;

        NewsParsingInterface newsParsingInterface = new NewsPipeParser();
        AddNewsAdapter addNewsAdapter = new AddNewsAdapter(addNewsPort, newsParsingInterface);
        RegisterParsingInterface registerParsingInterface = new RegisterPipeParser();
        RegisterAdapter registerAdapter = new RegisterAdapter(registerPort, registerParsingInterface);

        ChatServer chatServer = new ChatServer(addNewsAdapter, registerAdapter, new InetSocketAddress(host, port));
        chatServer.start();

//        registerPort.register(receiverA, "Sport");
//        registerPort.register(receiverB, "Sport");
//        registerPort.register(receiverB, "Politik");

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
