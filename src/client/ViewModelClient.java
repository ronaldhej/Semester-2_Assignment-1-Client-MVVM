package client;

import javafx.beans.property.*;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.LocalListener;

public class ViewModelClient implements LocalListener<String, String>
{
    private Model model;

    private StringProperty username;
    private StringProperty text;
    private StringProperty error;
    private StringProperty chatField;

    public ViewModelClient(Model model)
    {
        this.model = model;
        this.username = new SimpleStringProperty();
        this.error = new SimpleStringProperty();
        this.text = new SimpleStringProperty();
        this.chatField = new SimpleStringProperty();
    }

    public StringProperty usernameProperty() {return username;}
    public StringProperty textProperty() {return text;}
    public StringProperty errorProperty() {return error;}
    public StringProperty chatFieldProperty() {return chatField;}

    // additional logic for sending messages might go here

    public void sendMessage()
    {
        try
        {
            System.out.println("Attempt to send message");
            model.sendMessage(username.get(), text.get());
            text.set("");

        }
        catch (Exception e)
        {
            error.set(e.getMessage());
        }
    }

    @Override
    public void propertyChange(ObserverEvent<String, String> event)
    {
        System.out.println("I know it changed!");
        chatField.set(event.getValue2());
    }
}
