package client;

import java.io.PrintWriter;
import java.net.Socket;

public class ModelManager implements Model
{
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

}
