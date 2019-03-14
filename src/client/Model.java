package client;

import utility.observer.subject.LocalSubject;

public interface Model extends LocalSubject<String, String>
{
    void sendMessage(String username, String text);
    void setReceivedMessage(String receivedMessage);
}
