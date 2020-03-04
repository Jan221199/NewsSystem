package newssystem.model;

public class ChefMockup implements Runnable {

    protected Newssystem newsSystem;

    public ChefMockup(Newssystem newsSystem){
        this.newsSystem = newsSystem;
    }


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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
