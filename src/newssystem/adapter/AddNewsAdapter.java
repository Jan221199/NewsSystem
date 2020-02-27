package newssystem.adapter;

import newssystem.port.AddNewsPort;
import newssystem.model.ParsingInterface;

public class AddNewsAdapter {

    private AddNewsPort addNewsPort;
    private ParsingInterface parsingInterface;

    public AddNewsAdapter(AddNewsPort addNewsPort, ParsingInterface parsingInterface) {
        this.addNewsPort = addNewsPort;
        this.parsingInterface = parsingInterface;
    }

    public void newNews(String message){
        addNewsPort.newNews(parsingInterface.parse(message));
    }
}
