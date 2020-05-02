package FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FuleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("05Vorlesungs\\FileIO\\name.txt");
		if (file.exists()) {
			System.out.println("die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Das Programm lebt noch");
		}
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			// BufferedWriter schreibt perfomanter
			bufferedWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();
//			}
//			//true schreibt es jedes mal - false überschreibt die Datei
//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			Scanner scanner = new Scanner(file);
//			
//		} catch(FileNotFoundException el) {
//			el.printStackTrace();			
//		}

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String test = bufferedReader.readLine();
			System.out.println(test);

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
