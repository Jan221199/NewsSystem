package newssystem.model;

import utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class Chef {
    protected ArrayList<News> allNews;
    protected Newssystem newsSystem;

    public Chef(Newssystem newsSystem){
        this.allNews = new ArrayList<>();
        this.newsSystem = newsSystem;
    }

    public void manageNews(){
        Console.startDialogueSection();
        for(boolean goOn = true; goOn;){
            newsSystem.listAllNews(); //zuerst alle ausstehenden News ausgeben
            String choice = Console.readChoice("Eine News veröffentlichen", "Eine News löschen", "Exit");
            switch(choice){
                case "Eine News veröffentlichen":
                    publishNews();
                    break;
                case "Eine News löschen":
                    deleteNews();
                    break;
                case "Exit":
                    goOn = false;
                    break;
            }
        }
        Console.concludeDialogueSection();
    }

    public void publishNews(){
        newsSystem.listAllNews(); //zuerst alle ausstehenden News ausgeben
        int newsCounter = Console.readInt("Geben Sie Numerrierung der Nachricht an, die Sie veröffentlichen wollen");

        List<News> allNews = newsSystem.getAllNews();

        newsSystem.sendNews(allNews.get(newsCounter - 1));
    }

    public void deleteNews(){
        newsSystem.listAllNews(); //zuerst alle ausstehenden News ausgeben
        int newsCounter = Console.readInt("Geben Sie Numerrierung der Nachricht an, die Sie löschen wollen");

        List<News> allNews = newsSystem.getAllNews();
    }
}
