package client;

import utility.observer.event.ObserverEvent;
import utility.observer.listener.LocalListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Runnable, LocalListener<String, String>
{
    protected Socket receiveSocket;
    protected BufferedReader in;
    private Model model;

    public Receiver(BufferedReader in, Model model)
    {
        this.in = in;
        this.model = model;
        model.addListener(this);
    }

    @Override
    public void run() {
        try
        {
            in = new BufferedReader(new InputStreamReader(receiveSocket.getInputStream()));
            String stringMessage = in.readLine();
            model.setReceivedMessage(stringMessage);
        } catch (IOException e)
        {

        }
    }

    @Override public void propertyChange(ObserverEvent<String, String> event)
    {
        System.out.println("I got: " + event);
    }
}
