package newssystem.model;

public class RegisterPipeParser implements RegisterParsingInterface{
    @Override
    public String[] parse(String message) {
        final String[] messageArray = message.split("\\|");
        return messageArray; //[receiver, catogory]
    }
}
