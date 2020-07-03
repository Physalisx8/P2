package datenklau.org;

import java.io.PrintWriter;
import java.net.ServerSocket;

import java.util.ArrayList;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * datenklau.org ist in der Aufgabe Socket 3 - NewsTickerServer
 * 
 * Übersetzung: 
 * Eulerei - ConnectionThread
 * stawpitRon - ReaderThread
 * FlotteSchreibefeder - WriterThread
 * SleepyDragonClient - Client
 * 
 * 
 * 
 *					######SERVER######
 * 
 * 
 * */

public class DumbleBurnServer {

	//zunächst BlockingQueue<String>, ArrayListen<String> für die Clients feat. ConnectionThread und eines Writers erstellen
	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
	ArrayList<Eulerei> cT = new ArrayList<>();
	ArrayList<PrintWriter> writer = new ArrayList<>();

	//Server aufsetzen
	public void createServer() {
		//maximale Clientanzahl festsetzen
		int clients = 10;
		try {
			//ServerSocket mit Port (nichts unter 1600)  und client Anzahl definieren
			ServerSocket serversocket = new ServerSocket(3445, clients);
			
			//iteriert durch die Anzahl der clients, für jeden Client wird ein eigener ConnectionThread erstellt und gestartet.
			for (int i = 0; i < clients; i++) {
				cT.add(new Eulerei(queue, serversocket, writer));
				cT.get(i).start();
				System.out.println("ct started " + i);
			}

			//WriterThread wird instanziert und gestartet
			FlotteSchreibefeder wt = new FlotteSchreibefeder(queue, writer);
			wt.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//Server wird erstellt
		DumbleBurnServer server = new DumbleBurnServer();
		server.createServer();

	}

}
