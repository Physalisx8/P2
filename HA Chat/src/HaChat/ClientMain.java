package HaChat;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	private boolean isRunning = true;

	public void createClient() {

		try {
			// Client braucht IP und Port
			Socket socket = new Socket("127.0.0.1", 3445);

			// writer & Reader
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());

			System.out.println("Please Tell me more");
		
			//shift + m + alt -> hat diesen den Thread in eine Methode verwandelt
			writeMessage(printWriter);
			

			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//BAM WILD-METHOD APPEARED
	private void writeMessage(PrintWriter printWriter) {
		// mini Thread der die Nachrichten aus der Tast liest und ins Netzwerk ballert
		new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner keyboard = new Scanner(System.in);
				while (isRunning) {
					
					// wir lesen ne Nachricht über die Tastatur ein und schreiben sie als Text weg
					String text = keyboard.next();
					if (text.equalsIgnoreCase("quit")) {
						isRunning = false;
					} else {
						printWriter.println(text);
						printWriter.flush();

					}
				} keyboard.close();
			}
		
		}).start();
	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}
/*
 * NextLine liest zum nächsten Zeilenende (Enter) Next liest bis zum nächsten
 * WhiteSpace
 * 
 * zunächst Server dann Client laden
 */
