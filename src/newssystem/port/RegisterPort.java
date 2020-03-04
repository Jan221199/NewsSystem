package newssystem.port;

import newssystem.model.Receiver;

public interface RegisterPort {
    public void register(Receiver receiver, String category);
    public void unregister(Receiver receiver, String category);
}
