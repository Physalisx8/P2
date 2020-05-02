package datastructures;

import java.util.HashSet;
import java.util.Scanner;

//Aufgabe 6
public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		HashSet<Account> accounts = new HashSet<>();

		accounts.add(new Account("Naruto Uzumaki", 2137879));
		accounts.add(new Account("Sasuke Uchiha", 32178921));
		accounts.add(new Account("Sakura Haruno", 3721899));
		accounts.add(new Account("Kakashi Hatake", 3271989));
		accounts.add(new Account("Itachi Uchiha", 21379021));
		accounts.add(new Account("Jiraiya", 321798197));
		accounts.add(new Account("Senju Hashirama", 217361));
		accounts.add(new Account("Madara Uchiha", 11111));

		// Scanner
		System.out.println("Name: ");
		String name1 = scanner.nextLine();
		System.out.println("Telefonnummer: ");
		int number1 = scanner.nextInt();

		// neuen Account anlegen mit den Werten aus dem Scanner
		Account nueve = new Account(name1, number1);

		// Wenn accounts schon den Inhalt aus dem Scanner kennt, soll er n Fehler
		// ausgeben
		if (accounts.contains(nueve)) {
			System.out.println("Name/Number already exists");

			// sonst den Account anlegen
		} else {
			accounts.add(nueve);
			System.out.println("Done");
		}

	}

}
