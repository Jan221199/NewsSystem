package BehavorialPattern.Observer;

public class AbstractionLayer implements RegisterPort, AddNewsPort {
    private Newssystem newssystem;

    public AbstractionLayer(Newssystem newssystem){
        this.newssystem = newssystem;
    }

    @Override
    public void newNews(News news) {
        newssystem.newNews(news);
    }

    @Override
    public void register(Receiver receiver, String category) {
        newssystem.register(receiver, category);
    }

    @Override
    public void unregister(Receiver receiver, String category) {
        newssystem.unregister(receiver, category);
    }
}
