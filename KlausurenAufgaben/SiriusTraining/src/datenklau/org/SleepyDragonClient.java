package datenklau.org;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * 
 *  ######### CLIENT #######
 * 
 * Der Client ist ein User, der auf den Server zugreifen will.  Dafür braucht er einen Socket.
 * Er braucht einen eigenen printWriter und Scanner um Nachrichten aus dem Socket lesen und ausgeben zu können.
 * 
 * Die Methode writeMessage sorgt dafür, dass die Eingaben des Users dem Netzwerk übergeben werden.
 *
 * INFO: man kann zwischen den Consolen hin und her switchen um zu sehen wer welche Nachrichten empfängt.
 * 
 * 
 */
public class SleepyDragonClient {
	public boolean isRunning = true;

	public void createClient() {

		//try-catch!
		try {
			//Das Socket stellt die Verbindung zum Server her mit dem Port und der localhost IP. 
			Socket socket = new Socket("127.0.0.1", 3445);

			// writer & Reader erstellen, damit sie Nachrichten aus dem Socket lesen und ins Socket geben können.
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());

			//Ausgabe für den Client, damit der User weiß, dass er oben ist.
			System.out.println("Start!");
			

			
			//ruft die Methode auf - siehe unten
			// shift + m + alt -> hat diesen den Thread in eine Methode verwandelt
			writeMessage(printWriter);

			//solange das Programm nicht beendet wurde, soll er die nächste Line printen
			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			//schließt alles.
			scanner.close();
			printWriter.close();
			socket.close();

		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	private void writeMessage(PrintWriter printWriter) {
		// mini Thread der die Nachrichten aus dem Keyboard liest und ins Netzwerk ballert
		new Thread(new Runnable() {

			@Override
			public void run() {
				//definiert einen neuen Scanner, der sich für die Eingaben verantwortlich fühlt
				Scanner keyboard = new Scanner(System.in);
				while (isRunning) {
					// wir lesen ne Nachricht über die Tastatur ein und schreiben sie als Text weg
					String text = keyboard.next();
					if (text.equalsIgnoreCase("quit")) {
						isRunning = false;
					} else {
						//der Text aus der Usereingabe wird dem printWriter übergeben und ins Netzwerk geflusht
						printWriter.println(text);
						printWriter.flush();

					}
				}
				//Scanner schließen, sonst Scanner traurig.
				keyboard.close();
			}

		//Methode starten, sonst Methode traurig.
		}).start();
	}

	public static void main(String[] args) {
		SleepyDragonClient client = new SleepyDragonClient();
		client.createClient();
	}

}
