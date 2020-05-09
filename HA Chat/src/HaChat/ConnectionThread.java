package HaChat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/*ConnectionThread: Erstellt und startet f�r jede m�gliche Verbindungsanfrage eines Clients
einen Thread, der die Verbindung von einem Client annimmt. Die Anzahl der m�glichen
Verbindungen wird im Konstruktor des ServerSockets festgelegt. Dieser Thread muss auf das
ServerSocket zugreifen. Nach dem sich ein Client mit dem Server verbunden hat, soll mit
Hilfe des Sockets einen Writer erstellt und zu der Liste hinzugef�gt werden. Diese Liste aus
PrintWritern ist dieselbe Liste, auf die auch der WriterThread zugreift. Dieser Thread soll den
ReaderThread erstellen und zu einer Liste hinzuf�gen und starten
*/

public class ConnectionThread extends Thread {

	private BlockingQueue<String> queue;
	private ServerSocket serversocket;
	ArrayList<PrintWriter> writer = new ArrayList<>();

	
	public ConnectionThread(BlockingQueue<String> queue, ServerSocket serversocket, ArrayList<PrintWriter> writer) {
		super();
		this.queue = queue;
		this.serversocket = serversocket;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			//Akzeptiert die Verbindung und gibt Verbindungsdaten zur�ck
			System.out.println("waiting for client connection");
			Socket socket = serversocket.accept();
			System.out.println(socket.getLocalAddress());
			
			Scanner scanner = new Scanner(socket.getInputStream());
			ReaderThread rt = new ReaderThread(scanner,queue);
			rt.start();
			System.out.println("rt check");
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			writer.add(printWriter);
			System.out.println("wt check");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
