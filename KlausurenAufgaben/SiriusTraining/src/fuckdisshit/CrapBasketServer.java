package fuckdisshit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 			##### SERVER #####
 * Schreibe eine einfache FileServer Anwendung, dabei schreibt der Client
 * dem Server Nachrichten und alle Nachrichten werden von dem Server in einer 
 * Datei abgespeichert.
 * 
 * 
 * */

public class CrapBasketServer {

	public static void main(String[] args) {
		// außerhalb der try catch deklariert, damit er
		BufferedWriter buff_writer = null;

		try {
			// dieser Server wird erstellt und akzeptiert eine Verbindung
			System.out.println("Server: Waiting for client ...");
			ServerSocket ss = new ServerSocket(6080);
			Socket soc = ss.accept();
			System.out.println("Server: Connection established ...");

			// BufferedReader als input des Clients, dieser Streamer bezieht sich auf den
			// socket.inputStream
			BufferedReader input_client = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			// die Eingabe des Users wird in eine Variable gespeichert
			String mes_client = input_client.readLine();
			System.out.println("Server received: " + mes_client);

			// File erstellen mit der abfrage, ob ein File schon existiert, wenn nicht
			// erstellt er einen
			File save_file = new File(
					"C:\\Users\\Francie\\eclipse-workspace\\SiriusTraining\\src\\fuckdisshit\\SocketStuff.txt");
			if (!save_file.exists()) {
				save_file.createNewFile();
			}

			// FileWriter um in die Datei schreiben zu können, wir upgraden den auf einen
			// bufferedWriter
			FileWriter file_writer = new FileWriter(save_file);
			buff_writer = new BufferedWriter(file_writer);

			// buff_writer schreibt den Kram in die File
			buff_writer.write(mes_client);
			System.out.println("File written Successfully");

			// ss close
			ss.close();

		} catch (Exception e) {
			System.out.println("Server funktioniert nicht!");
			e.printStackTrace();

		} finally {
			// finally wird immer ausgeführt, auch wenn das erste fehlschlägt
			try {
				// wenn etwas im Buffered Writer steht, soll er geschlossen werden.
				if (buff_writer != null)
					buff_writer.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}

}
