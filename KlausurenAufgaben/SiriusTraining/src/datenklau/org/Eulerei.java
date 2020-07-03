package datenklau.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/*			##########ConnectionThread########
 * 
 *  
 *  Erstellt und startet für jede(!) mögliche Verbindungsanfrage eines Clients einen Thread, der die Verbindung von einem Client annimmt. 
 *  Die Anzahl der möglichen Verbindungen wird im Konstruktor des ServerSockets festgelegt. 
 *  Dieser Thread muss auf das ServerSocket zugreifen. 
 *  Nach dem sich ein Client mit dem Server verbunden hat, soll mit Hilfe des Sockets einen Writer erstellt und zu der Liste hinzugefügt werden. 
 *  Diese Liste aus PrintWritern ist dieselbe Liste, auf die auch der WriterThread zugreift. 
 *  Dieser Thread soll den ReaderThread erstellen und zu einer Liste hinzufügen und starten
 *  
 *  Sie ist im Grunde das Brain in der ThreadKombination und sorgt für gute Kommunikation
 *  
*/

public class Eulerei extends Thread {

	// Serversocket, writer und Queue, die der WriterThread benötigt.
	private BlockingQueue<String> queue;
	private ServerSocket serversocket;
	ArrayList<PrintWriter> writer = new ArrayList<>();

	// Constructor für den ConnectionThread
	public Eulerei(BlockingQueue<String> queue, ServerSocket serversocket, ArrayList<PrintWriter> writer) {
		super();
		this.queue = queue;
		this.serversocket = serversocket;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {

			// Akzeptiert die Verbindung zwischen Server und Client
			// und gibt Verbindungsdaten zurück
			System.out.println("waiting for client connection");
			Socket socket = serversocket.accept();
			System.out.println(socket.getLocalAddress());

			// Scanner und ReaderThread werden erstellt und gestartet. Socket Datenstrom
			Scanner scanner = new Scanner(socket.getInputStream());
			stawpitRon rt = new stawpitRon(scanner, queue);
			rt.start();
			System.out.println("rt check");

			//PrintWriter wird erstellt und der ArrayList hinzugefügt - Socket Datenstrom
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			writer.add(printWriter);
			System.out.println("wt check");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
