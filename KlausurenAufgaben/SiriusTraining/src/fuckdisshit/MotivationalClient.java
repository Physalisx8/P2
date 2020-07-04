package fuckdisshit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class MotivationalClient{
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        try {
	        	//Socket erstellen und Verbindung aufbauen
	            System.out.println("Client started...");
	            Socket soc = new Socket("127.0.0.1", 6080);
	            
	            //BufferedReader (Gegenstück BufferedWriter), der die Usereingabe übernimmt
	            BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
	            System.out.println("Client: Enter your text:");
	            
	            //Usereingabe in ner Variable gespeichert
	            String input = user_input.readLine();
	            
	            //Servertransaction, das true am Ende flusht die Eingabe
	            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
	            out.println(input);
	           
	            soc.close();
	            
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }

}
