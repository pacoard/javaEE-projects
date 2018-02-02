package src.hw1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server extends Thread{
	private final static int serverPort   = 4444;
	protected Thread runningThread= null;
	private Socket clientSocket;
	private static ServerSocket serverSocket;
	private static int count = 0;
	
	public Server(Socket socket){
		this.clientSocket= socket;
	}
	
	public void run(){
        try{  
	            PrintWriter out =
	                new PrintWriter(clientSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(clientSocket.getInputStream()));
		        
	            String inputLine;
	            String outputLine;
	            do{
		            // Initiate conversation with client
		            String operation = in.readLine();
		            if (operation.equals("COUNT")){
		            	System.out.println("Number of clients connected: "+count);
		            	out.println("Number of clients connected: " + count);
		            }else{
		            	System.out.println("515OK -->The request from client is:" + operation);
			            //Process the operation
			            double opResult = Server.calculate(operation);
			            System.out.println("The operation result is: " + opResult);
			            out.println("The operation result is: " + opResult);
		            }
	            }while (!in.equals("exit"));
	        } catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port 4444");
	            System.out.println(e.getMessage());
	        } catch (Exception e){
	        	System.out.println("Server error:"+e.getMessage());
	        }
    }
    
    public static double calculate(String operation){
    	double result = 0;
    	int index = 0;
    	double a=0;
    	double b=0;
    	if (operation.indexOf("*") > 0){
    		index = operation.indexOf("*");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+1, operation.length()));
    		result = a*b;
        }else if(operation.indexOf("+") > 0){
    		index = operation.indexOf("+");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+1, operation.length()));
    		result = a+b;
        }else if(operation.indexOf("-") > 0){
    		index = operation.indexOf("-");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+1, operation.length()));
    		result = a-b;
        }else if (operation.indexOf("/") > 0){
    		index = operation.indexOf("/");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+1, operation.length()));
    		result = a/b;
        }else if (operation.indexOf("//") > 0){
    		index = operation.indexOf("//");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+2, operation.length()));
    		result = Math.floorDiv((int)a,(int)b);
        }else if (operation.indexOf("%") > 0){
        	index = operation.indexOf("%");
    		a = Double.parseDouble(operation.substring(0, index));
    		b = Double.parseDouble(operation.substring(index+1, operation.length()));
    		result = a%b;
        }
    	return result;
    }
    
    public static void main(String[] args) throws IOException {
    	try {
			serverSocket = new ServerSocket(serverPort);
			System.out.println("Server running on port "+ serverPort);
    	} catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 4444");
            System.out.println(e.getMessage());
        } 
    	
    	while(true){
    		try{
	            Socket clientSocket = serverSocket.accept();
	            new Server(clientSocket).start();
	            count++;
	            
	        } catch (Exception e){
	        	System.out.println("Server error:"+e.getMessage());
	        }
    	}
    }
}

