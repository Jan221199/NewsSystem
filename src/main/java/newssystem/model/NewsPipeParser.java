package newssystem.model;

//converts into a News
public class NewsPipeParser implements NewsParsingInterface {
    @Override
    public News parse(String message) {
        final String headline;
        final String category;

        String[] messageArray = message.split("\\|");
        headline = messageArray[0];
        category = messageArray[1];
        return new News(headline, category);
    }
}
