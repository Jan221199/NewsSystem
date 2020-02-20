package BehavorialPattern.Observer;

public class ReceiverImpl implements Receiver {
    public ReceiverImpl(){

    }

    @Override
    public void update(News news) {
        System.out.println(news.getHeadline() + " Kategorie: " + news.getCategory());
    }
}
