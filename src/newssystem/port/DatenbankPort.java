package newssystem.port;

import newssystem.model.News;

import java.util.ArrayList;
import java.util.List;

public interface DatenbankPort {
    public List<News> lastMessages(String category, int lastNews);
    public void insertNews(News news);
    public void deleteNews(News news);
}
