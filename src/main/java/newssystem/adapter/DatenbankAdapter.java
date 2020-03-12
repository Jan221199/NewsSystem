package newssystem.adapter;

import com.mongodb.*;
import com.mongodb.client.MongoCursor;
import newssystem.model.News;
import newssystem.port.DatenbankPort;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatenbankAdapter implements DatenbankPort {

    private MongoClient mongoClient;
    private DB database;
    private DBCollection collection;

    public DatenbankAdapter() {
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        this.database = mongoClient.getDB("mydb");
        this.collection = database.getCollection("news");
    }

    @Override
    public List<News> lastMessages(String category, int lastNews) {
        List<News> lastNewsArray = new ArrayList<>();
        Iterator<DBObject> documents = collection.find(new BasicDBObject("category", category)).sort(new BasicDBObject("_id", -1)).limit(lastNews).iterator();
        List<News> newsFromCategory = new ArrayList<>();
        if(documents != null){
            while(documents.hasNext()){
                DBObject dbObject = documents.next();
                newsFromCategory.add(new News(dbObject.get("headline").toString(), dbObject.get("category").toString()));
            }
        }
        return newsFromCategory;
    }

    @Override
    public void insertNews(News news) {
        DBObject document = new BasicDBObject("headline", news.getHeadline())
        .append("category", news.getCategory());
        collection.insert(document);
    }

    @Override
    public void deleteNews(News news) {
        DBObject document = collection.find(new BasicDBObject("headline", news.getHeadline())).one();
        if(document != null){
            collection.remove(document);
        }
    }
}
