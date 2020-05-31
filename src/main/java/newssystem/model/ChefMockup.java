package newssystem.model;

//ChefMockup to publish every News instantly (only for testing)
public class ChefMockup implements Runnable {

    protected Newssystem newsSystem;

    public ChefMockup(Newssystem newsSystem){
        this.newsSystem = newsSystem;
    }

    //new Thread which does permanently release every incoming News instantly
    @Override
    public void run() {
        while (true){
            if(newsSystem.getAllNews().isEmpty() == false){
                for(News news : newsSystem.getAllNews()){
                    System.out.println("ChefMockup:: " + news.toString());
                    newsSystem.sendNews(news);
                }
            }
            try {
                //...but only every 1000ms
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
