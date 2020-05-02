package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Variante 2
public class PrintWriterStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File("HelloWorld.txt");
			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);
			writer.println("Hello World");
			writer.close();
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			File file = new File("HelloWorld.txt");
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			System.out.println(line);
			scanner.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
