package newssystem.model;

public class PipeProtocolParser implements ParsingInterface {
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
