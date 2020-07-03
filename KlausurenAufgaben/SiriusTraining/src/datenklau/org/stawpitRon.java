package datenklau.org;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/*
 * 
 * 				########## ReaderThread #########
 * 
 * 
 * sorgt dafür, dass Nachrichten eingelesen werden und der queue übergeben werden.
 * Der WT flusht sie dann in die Außenwelt.
 * 
 * wird in der Euerlei erstellt und gestartet.
 * 
 * 
 *
 * 
 * */
public class stawpitRon extends Thread {

	private BlockingQueue<String> queue;
	private boolean isRunning = true;
	private Scanner scanner;

	// RT Constructor
	public stawpitRon(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				// liest die Message ein und übergibt sie dem Queue.
				String message = scanner.nextLine();
				System.out.println(message);
				queue.put(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
	}
}
