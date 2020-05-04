
public class MinionRunner implements Runnable {
//Runnable implementiert man beispielsweise, wenn man noch von ner anderen Klasse erben will
	// via extends Ufo bzspw
	// runnable kommt mit der Methode run, die muss überschrieben werden
	@Override
	public void run() {

		for (int i = 100; i > 0; i--) {
			System.out.println("Minions sind cooler!");
		}

	}

}

/**
Fallen im Umgang mit Threads
-> i++ - das sind 3 Operationen, wenn mehrere Threads auf dasselbe i zugreifen gibt's n problem
um das Problem zu umgehen, kann man die Variable "Lock"en, damit die Variable nicht von mehrere Threads 
parallel aufrufen können
-> synchronized -> KLAUSURRELEVANT!
Kann in Kombi mit Methoden aber auch mit dem Ressourcen Objekt verwendet werden.

Consumer-Producer Problem
Thread produziert eine Ressource aber ein anderer konsumiert diese
Wenn der Consumer alle Ressourcen verbraucht hat, legt er sich solagne schlafen bis neue produziert wird
Wenn ein Producer nichts mehr produzieren kann, legt sich auch dieser schlafen, bis wieder Platz für neue Ressourcen ist
 */
 