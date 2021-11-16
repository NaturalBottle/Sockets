package Training;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            Socket socket = new Socket("localhost", 1212);
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true)
            {
                System.out.println("Server: " + socketReader.readLine());

                String message = scanner.nextLine();
                socketWriter.println(message);
                if(message.equalsIgnoreCase("abort")) break;
            }
        }

    }
}
