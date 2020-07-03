import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * 
 * 
 *  ################ Client #############
 *  Socket Aufgabe 1+2
 *  
 * 
 * 
 * */
public class ServerusDamage {
	public boolean isRunning = true;

	public void createClient() {

		try {
			// greift auf LocalHost und den angegeben Server Port zu
			Socket socket = new Socket("127.0.0.1", 3445);

			// writer & Reader Datenstrom
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());

			// Scanner für die Usereingabe
			System.out.println("Tell me your name");
			Scanner keyboard = new Scanner(System.in);

			// shift + m + alt -> hat diesen den Thread in eine Methode verwandelt
			// siehe unten
			writeMessage(printWriter, keyboard);

			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			// close everything!
			keyboard.close();
			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void writeMessage(PrintWriter printWriter, Scanner keyboard) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (isRunning) {
					// wir lesen ne Nachricht über die Tastatur ein und schreiben sie als Text weg
					String text = keyboard.next();
					System.out.println(text + "Writer Thread");
					if (text.equalsIgnoreCase("quit")) {
						isRunning = false;
					} else {
						//// der Text aus der Usereingabe wird dem printWriter übergeben und ins
						//// Netzwerk geflusht
						printWriter.println(text);
						printWriter.flush();

					}
				}
			}

		}).start();

	}

	public static void main(String[] args) {
		ServerusDamage client = new ServerusDamage();
		client.createClient();
	}
}
