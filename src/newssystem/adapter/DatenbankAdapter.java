package newssystem.adapter;

import newssystem.model.News;
import newssystem.port.DatenbankPort;

import java.util.List;

public class DatenbankAdapter implements DatenbankPort {

    @Override
    public List<News> lastMessages(String category, int lastNews) {
        return null;
    }

    @Override
    public void insertNews(News news) {

    }

    @Override
    public void deleteNews(News news) {

    }
}
