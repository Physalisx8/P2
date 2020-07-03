import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * 
 * ##### SERVER ######
 * Aufgabe 1 und 2 Sockets!
 * 
 *  
 * 
 * 
 * 
 * */

public class SiriusServer {
	public boolean isRunning = true;

	public void createServer() {
		// legt die Zahl der Verbindungen fest. Auf 1 beschr‰nkt
		int clients = 1;
		try {
			// erstellt das serverSocket und akzeptiert potentielle Client anfragen
			ServerSocket serversocket = new ServerSocket(3445, clients);
			Socket socket = serversocket.accept();

			// Datenstrom socket per Scanner und Writer
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

			// Aufgabe 1
			// printWriter.println("Sever " + scanner.next());

			// Aufgabe 2 Socket//
			while (isRunning) {
				String text = scanner.next();
				System.out.println(text);
				printWriter.println(text);
				printWriter.flush();
			}

			// Aufgabe 1
			// printWriter.flush();

			// schlieﬂt alles
			socket.close();
			scanner.close();
			printWriter.close();
			serversocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SiriusServer server = new SiriusServer();
		server.createServer();

	}

}
