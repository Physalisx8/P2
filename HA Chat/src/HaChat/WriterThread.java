package HaChat;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
	private boolean isRunning=true;
	ArrayList<PrintWriter> writer = new ArrayList<>();

	public WriterThread(BlockingQueue<String> queue, ArrayList<PrintWriter> writer) {
		super();
		this.queue = queue;
		this.writer = writer;
	}

	
	//BQ soll den Kram aus dem Writer übernehmen und an die Clients senden
	//solange wie was in der ArrayListe ist halt.
	@Override
	public void run() {
		while (isRunning) {
			try {
				System.out.println("Warte auf Nachricht");
				String message = queue.take();
				System.out.println("Nachricht "+ message + "Writercount"+ writer.size());
				for (PrintWriter i : writer) {
					i.println(message);
					i.flush();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	public void stopWT(){
		isRunning = false;
	}
}
