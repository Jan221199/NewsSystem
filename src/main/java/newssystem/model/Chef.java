package newssystem.model;

import utilities.Console;

import java.util.ArrayList;
import java.util.List;

//the 'Chef' releases the incoming news
public class Chef {
    protected List<News> allNews; //list with all outstanding News
    protected Newssystem newsSystem;

    public Chef(Newssystem newsSystem){
        this.allNews = new ArrayList<>();
        this.newsSystem = newsSystem;
    }

    //'Chef' can choose action
    public void manageNews(){
        Console.startDialogueSection();
        for(boolean goOn = true; goOn;){ //until 'Chef' exits
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
        newsSystem.listAllNews(); //first display all outstanding news for overview
        //Selection of News which should be published
        int newsCounter = Console.readInt("Geben Sie Numerrierung der Nachricht an, die Sie veröffentlichen wollen");

        //publishing selected news
        List<News> allNews = newsSystem.getAllNews();
        newsSystem.sendNews(allNews.get(newsCounter - 1));
    }

    public void deleteNews(){
        newsSystem.listAllNews(); //first display all outstanding news for overview
        int newsCounter = Console.readInt("Geben Sie Numerrierung der Nachricht an, die Sie löschen wollen");

        List<News> allNews = newsSystem.getAllNews();
    }
}
