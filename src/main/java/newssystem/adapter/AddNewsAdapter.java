package newssystem.adapter;

import newssystem.port.AddNewsPort;
import newssystem.model.NewsParsingInterface;


public class AddNewsAdapter {

    private AddNewsPort addNewsPort;
    private NewsParsingInterface newsParsingInterface;


    public AddNewsAdapter(AddNewsPort addNewsPort, NewsParsingInterface newsParsingInterface) {
        this.addNewsPort = addNewsPort;
        this.newsParsingInterface = newsParsingInterface;
            }

    public void newNews(String message){
        addNewsPort.newNews(newsParsingInterface.parse(message));
    }
}
