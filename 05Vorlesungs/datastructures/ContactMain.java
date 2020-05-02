package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Contact> contact = new LinkedList<>();

		//
//		ArrayList<Contact> contact = new ArrayList<>();
//		
		contact.add(new Contact("Vegeta", 111111));
		contact.add(new Contact("Kakarot", 14107));
		contact.add(new Contact("Bulma", 7043));
		contact.add(new Contact("Chi-Chi", 78219));
		contact.add(new Contact("Bob Ross", 1337));
		contact.add(new Contact("Trunks", 2178));
		contact.add(new Contact("Chuck Norris", 0));
		contact.add(new Contact("Bruce Lee", 21398));
		contact.add(new Contact("Uwe Boll", 123234));
//		
		Collections.sort(contact);

		// Variante 2
		// Einlesen ins Objekt -> linked mit ObjectInputStream (Ausgabe)
		try {
			File file = new File("Contact.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contact);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Aus irgeneinem grund, muss man es vorher instanzieren, damit es nicht so
		// hackelt.
		// Auslesen
		Object obj = null;
		try {
			File file = new File("Contact.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (obj instanceof LinkedList) {
			@SuppressWarnings("unchecked")
			LinkedList<Contact> conta = (LinkedList<Contact>) obj;
			for (Contact contact1 : conta) {
				System.out.println(contact1.getName() + " : " + contact1.getHandynr());
			}

		}

	}

}
