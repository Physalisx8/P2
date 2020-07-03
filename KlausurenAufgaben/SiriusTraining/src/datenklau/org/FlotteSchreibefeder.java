package datenklau.org;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/*
 *  ########## WriterThread #########
 * 
 * man kann den WT auch in den Server schreiben, der Übersichthalber wohnt er jetzt im eigenen Thread
 * mit dem Vorteil, dass man die runMethod überschreiben kann.
 * 
 * Der WriterThread hat den Job Nachrichten zu erkennen und auszugeben.
 * Arbeitet eng mit dem ReaderThread zusammen. Die WriterThread entnimmt die Nachrichten aus dem Queue um sie auszugeben,
 * während die ReaderThread sie da reintut.
 * 
 * 
 * 
 * 
 * */

//erbt von der Klasse Thread
public class FlotteSchreibefeder extends Thread {

	// BlockingQueue, die wir auch in der Connection- & ReaderThread nutzen
	// Das Printwriter Array wird im ConnectionThread befüllt
	private BlockingQueue<String> queue;
	private boolean isRunning = true;
	ArrayList<PrintWriter> writer = new ArrayList<>();

	// Constructor für den WriterThread
	public FlotteSchreibefeder(BlockingQueue<String> queue, ArrayList<PrintWriter> writer) {
		super();
		this.queue = queue;
		this.writer = writer;
	}

	/*
	 * BQ soll den Kram aus dem Writer übernehmen und an die Clients senden solange
	 * wie es nachrichten in dem Writer-Array gibt.
	 */
	@Override
	public void run() {
		while (isRunning) {
			try {
				System.out.println("Warte auf Nachricht");
				// er nimmt aus der Queue, die im ReaderThread befüllt wird, die Nachricht raus
				// und speichert sie als String
				String message = queue.take();

				// gibt die Nachricht im Server zurück mit dem WriterCount
				System.out.println("Nachricht " + message + " Writercount " + writer.size());

				/*
				 * foreach um den User wissen zu lassen, dass die Daten gesichert und angekommen
				 * sind, diese Nachricht wird per 'flush' an jeden Client geschickt, der sich
				 * mit dem Server verbunden hat und eine Nachricht geschrieben hat. wollte
				 * sichergehen, dass er wirklich die Nachricht kriegt und hab sie nochmal
				 * ausgeben lassen
				 */
				for (PrintWriter i : writer) {
					i.println("Data stored " + message);
					i.flush();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void stopWT() {
		isRunning = false;
	}
}
