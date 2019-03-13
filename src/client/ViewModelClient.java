package client;

import javafx.beans.property.*;

public class ViewModelClient
{
    private Model model;

    private StringProperty username;
    private StringProperty text;
    private StringProperty error;

    public ViewModelClient(Model model)
    {
        this.model = model;
        this.username = new SimpleStringProperty();
        this.error = new SimpleStringProperty();
        this.text = new SimpleStringProperty();
    }

    public StringProperty usernameProperty() {return username;}
    public StringProperty textProperty() {return text;}
    public StringProperty errorProperty() {return error;}

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

}
