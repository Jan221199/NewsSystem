package newssystem.model;

import newssystem.port.DatenbankPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Newssystem {
    private Map<String, ArrayList<Receiver>> receivers; //key: Category; value: ArrayList<Receiver>
    private CopyOnWriteArrayList<News> allNews; //Error because of accessing List in different Thread -> not perfect
    private DatenbankPort datenbankPort;

    public Newssystem(DatenbankPort datenbankPort){
        this.receivers = new HashMap<>();
        this.allNews = new CopyOnWriteArrayList<>();
        this.datenbankPort = datenbankPort;
    }

    public void addCategory(String category){
        if(receivers.containsKey(category) == false) {
            receivers.put(category, new ArrayList<Receiver>());
        }
    }

    public void removeCategory(String category){
        if(receivers.containsKey(category)) {
            receivers.remove(category);
        }
    }

    public void register(Receiver receiver, String category){
        //checks if requested category for registration is available
        if(receivers.containsKey(category)){
            receivers.get(category).add(receiver);
            //sends last 5 News to new Receiver
            List<News> lastNews = datenbankPort.lastMessages(category, 5);
            for(News news : lastNews){
                receiver.update(news);
            }
        } else {
            System.out.println("Keine gültige Kategorie");
        }
    }

    public void unregister(Receiver receiver, String category){
        if(receivers.containsKey(category)){
            receivers.get(category).remove(receiver);
        }else {
            System.out.println("Keine gültige Kategorie");
       }
    }

    //sends a released News to all registered receivers and saves the news in database
    public void sendNews(News news){
        String category = news.getCategory();
        for(Receiver receiver : receivers.get(category)){
            receiver.update(news);
        }
        datenbankPort.insertNews(news);
        removeNews(news);
    }

    public void removeNews(News news){
        allNews.remove(news);
        datenbankPort.deleteNews(news);
    }

    //adds new News in List for the 'Chef' to release the news.
    public void newNews(News news){
        if(receivers.containsKey(news.getCategory())) {
            allNews.add(news);
        }else {
            System.out.println("Keine gültige Kategorie!");
        }
    }


    public List<News> getAllNews() {
        return allNews;
    }

    //prints all outstanding news
    public void listAllNews(){
        int i = 1;
        System.out.println("-----");
        System.out.println("Alle zur Freigabe ausstehenden News:\n");
        for(News news : allNews){
            System.out.println(i + ": " + "Kategorie: " + news.getCategory() + " | " + "Nachricht: " + news.getHeadline());
            i++;
        }
        System.out.println("-----");
    }
}
