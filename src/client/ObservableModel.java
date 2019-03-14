package client;

import utility.observer.subject.LocalSubject;

public interface ObservableModel extends Model, LocalSubject<String, String>
{
    @Override
    void sendMessage(String username, String text);
}
