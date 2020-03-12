package newssystem.adapter;

import newssystem.model.Receiver;
import newssystem.model.RegisterParsingInterface;
import newssystem.port.RegisterPort;

public class RegisterAdapter{
    private RegisterPort registerPort;
    private RegisterParsingInterface registerParsingInterface;

    public RegisterAdapter(RegisterPort registerPort, RegisterParsingInterface registerParsingInterface) {
        this.registerPort = registerPort;
        this.registerParsingInterface = registerParsingInterface;
    }

    public void register(Receiver receiver, String message) {
        String[] strings = registerParsingInterface.parse(message);
        registerPort.register(receiver, strings[0]);
    }

    public void unregister(Receiver receiver, String message) {
        String[] strings = registerParsingInterface.parse(message);
        registerPort.unregister(receiver, strings[0]);
    }
}


