package newssystem.model;

import newssystem.port.DatenbankPort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// ------------ID ist nicht implementiert --------------------

public class DatenbankMockup implements DatenbankPort {

    private HashMap<String, ArrayList<News>> daten;

    public DatenbankMockup() {
        this.daten = new HashMap<>();
    }

    @Override
    public List<News> lastMessages(String category, int lastNews) {
        List<News> lastNewsArray = new ArrayList<>();
        if(daten.containsKey(category)){
            ArrayList<News> newsFromCategory = daten.get(category);
            if(newsFromCategory.size() > lastNews) {
                lastNewsArray = newsFromCategory.subList(newsFromCategory.size() - lastNews, newsFromCategory.size());
            } else{
                lastNewsArray = newsFromCategory.subList(0, newsFromCategory.size());
            }
        }
        return lastNewsArray;
    }

    @Override
    public void insertNews(News news) {
        if(daten.get(news.getCategory()) == null){
            daten.put(news.getCategory(), new ArrayList<News>());
        }
            daten.get(news.getCategory()).add(news);
    }

    @Override
    public void deleteNews(News news) {
        if(daten.get(news.getCategory()).isEmpty() == false){
            daten.get(news.getCategory()).remove(news);
        }
    }
}
