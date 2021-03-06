import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

	private BlockingQueue<String> queue;
	private boolean isRunning = true;
	private Scanner scanner;

	//blockingQue alle Nachrichten gelesen werden bis.. was auch immer fuck
	public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
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
