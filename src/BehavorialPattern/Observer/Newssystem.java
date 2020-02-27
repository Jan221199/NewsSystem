package BehavorialPattern.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Newssystem {
    private HashMap<String, ArrayList<Receiver>> receivers;
    private CopyOnWriteArrayList<News> allNews;

    public Newssystem(){
        this.receivers = new HashMap<>();
        this.allNews = new CopyOnWriteArrayList<>();
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
        if(receivers.containsKey(category)){
            receivers.get(category).add(receiver);
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

    public void sendNews(News news){
        String category = news.getCategory();
        for(Receiver receiver : receivers.get(category)){
            receiver.update(news);
        }
        removeNews(news);
    }

    public void removeNews(News news){
        allNews.remove(news);
    }

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
