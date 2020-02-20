package BehavorialPattern.Observer;

import utilities.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class Chef {
    private ArrayList<News> allNews;
    private Newssystem newsSystem;

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

        ArrayList<News> allNews = newsSystem.getAllNews();

        newsSystem.sendNews(allNews.get(newsCounter - 1));
        newsSystem.removeNews(allNews.get(newsCounter - 1));
    }

    public void deleteNews(){
        newsSystem.listAllNews(); //zuerst alle ausstehenden News ausgeben
        int newsCounter = Console.readInt("Geben Sie Numerrierung der Nachricht an, die Sie löschen wollen");

        ArrayList<News> allNews = newsSystem.getAllNews();
        newsSystem.removeNews(allNews.get(newsCounter - 1));
    }
}
