package newssystem.adapter;

import newssystem.model.Receiver;
import newssystem.model.ReceiverImpl;
import newssystem.model.RegisterParsingInterface;
import newssystem.port.RegisterPort;

public class RegisterAdapter{
    private RegisterPort registerPort;
    private RegisterParsingInterface registerParsingInterface;

    public RegisterAdapter(RegisterPort registerPort, RegisterParsingInterface registerParsingInterface) {
        this.registerPort = registerPort;
        this.registerParsingInterface = registerParsingInterface;
    }

    public void register(String message) {
        registerPort.register(new ReceiverImpl() = registerParsingInterface.parse(message)[0], registerParsingInterface.parse(message)[1]);
    }

    public void unregister(Receiver receiver, String category) {
        registerPort.unregister(receiver, category);
    }
}
}

