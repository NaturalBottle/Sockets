package Training;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> chatLog = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ServerSocket serverSocket = new ServerSocket(1212);
        Socket socket = serverSocket.accept();

        PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while(true)
        {
            String message = scanner.nextLine();
            serverWriter.println(message);
            chatLog.add("Server: "+message);
            String clientMessage = serverReader.readLine();
            System.out.println("Client: " + clientMessage);
            chatLog.add("Client:"+clientMessage);
            if(clientMessage.equalsIgnoreCase("abort"))
            {
                try
                {
                    PrintWriter writer = new PrintWriter("log.txt");
                    for(String string:chatLog)
                        writer.println(string);
                    writer.close();
                }
                catch (Exception e)
                {
                    System.out.println("OOF");
                }
                break;
            }
        }
        //serverReader.close();
        //serverWriter.close();
    }
}
