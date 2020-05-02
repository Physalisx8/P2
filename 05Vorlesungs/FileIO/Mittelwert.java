//Aufgabe 5

package FileIO;

import java.util.HashSet;
import java.util.Scanner;

public class Mittelwert {

	public static void main(String[] args) {

//		Variablen Deklaration
		double minions = 0;
		String stawp = "quit";
		String input = "";
		boolean q = true;
		double result = 0;
		int counter = 0;

		HashSet<Double> set = new HashSet<Double>();
		Scanner scanner = new Scanner(System.in);

// fragwürdig, ob ein Boolean dafür so geeignet ist aber...
		while (q == true) {
			System.out.println("Bitte geben Sie einen Double ein");
//			input=scanner.nextDouble();
			input = scanner.nextLine();
			if (!(input.equals(stawp))) {
//				wir casten um -> double accepted
				minions = Double.valueOf(input);
				set.add(minions);
			} else {
				q = false;
				for (double Zahl1 : set) {
					result += Zahl1;
					counter += 1;
				}

			}

		}
		scanner.close();
		System.out.println("Mittelwert: " + result / counter);
	}
}
