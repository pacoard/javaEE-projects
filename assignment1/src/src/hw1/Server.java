package src.hw1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        try ( 
            ServerSocket serverSocket = new ServerSocket(4444);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        
            String inputLine;
            String outputLine;
            
            // Initiate conversation with client
            System.out.println("Client connected");
            out.println("The request from client is:" +in.readLine());

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 8080");
            System.out.println(e.getMessage());
        }
    }
}

