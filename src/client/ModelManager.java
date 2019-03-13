package client;

import java.io.PrintWriter;
import java.net.Socket;

public class ModelManager implements Model
{
    public void sendMessage(String username, String text)
    {
        System.out.println("Button pressed");

        try (Socket socket = new Socket("192.168.1.226", 6789))
        {
            System.out.println("Port opened message");
            PrintWriter out = null;
            try
            {
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e)
            {

            }
            finally
            {
                out.println(text);
            }

        } catch (Exception e)
        {

        }

    }

}
