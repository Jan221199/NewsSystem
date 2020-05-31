package newssystem.model;

public class RegisterPipeParser implements RegisterParsingInterface{
    @Override
    //separates String in String[] by a Pipe |
    public String[] parse(String message) {
        final String[] messageArray = message.split("\\|");
        return messageArray;
    }
}
