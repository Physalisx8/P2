package HaChat;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServerMainFinalFin {

	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

	ArrayList<PrintWriter> writer = new ArrayList<>();
	ArrayList<ConnectionThread> connectionThread = new ArrayList<>();

	public void createServer() {
		int clients = 15;
		try {
			// beim Port immer über 1600 liegen & -> 1 lässt nur clientAnzahl an Verbindung
			// zu
			ServerSocket serversocket = new ServerSocket(3445, clients);

			for(int i=0;i<clients;i++) {
				connectionThread.add(new ConnectionThread(queue, serversocket, writer));
				connectionThread.get(i).start();
				System.out.println("ct started" + i);
			}
			
			WriterThread wt = new WriterThread(queue, writer);
			wt.start();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void stop() {
		Scanner keyboard = new Scanner(System.in);
		String text = keyboard.next();
		if (text.equalsIgnoreCase("quit")) {
			System.out.println("Programm endet");
			}
		keyboard.close();
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hallo :)");
		ServerMainFinalFin server = new ServerMainFinalFin();
		server.createServer();
		server.stop();
		
		
	}
}
