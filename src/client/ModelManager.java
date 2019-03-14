package client;

import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeProxy;
import utility.observer.subject.PropertyChangeAction;

import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ModelManager implements Model
{
    private String receivedMessage;
    private PropertyChangeAction<String, String> subject;

    public ModelManager(String receivedMessage)
    {
        this.receivedMessage = receivedMessage;
        this.subject = new PropertyChangeProxy<>(this);
    }

    public ModelManager() {

    }

    public void setReceivedMessage(String receivedMessage)
    {
        String oldReceivedMessage = this.receivedMessage;
        this.receivedMessage = receivedMessage;
        subject.firePropertyChange("String updated", oldReceivedMessage, receivedMessage);
    }

    @Override public void sendMessage(String username, String text)
    {
        System.out.println("Button pressed - model");

        try (Socket socket = new Socket("192.168.1.226", 4567))
        {
            System.out.println("Port opened");
            PrintWriter out = null;
            try
            {
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e)
            {

            }
            finally
            {
                out.println(username + " > " + text);
            }

        } catch (Exception e)
        {
            System.out.println("Failed to open port");

        }

    }

    @Override
    public boolean addListener(GeneralListener<String, String> listener, String... propertyNames)
    {
        return subject.addListener(listener, propertyNames);
    }

    @Override
    public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames)
    {
        return subject.removeListener(listener, propertyNames);
    }
}
