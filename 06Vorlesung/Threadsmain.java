
public class Threadsmain {

	public static void main(String[] args) {
		// Instance von CalcThread erstellen
		CalcThread calThread = new CalcThread();
		CalcThread calThread2 = new CalcThread();

		// Runnable Instanz erstellen ist kein Thread
		MinionRunner runner = new MinionRunner();
		// wir erstellen einen Thread der die Run Methode aus Minionrunner ausführt
		// damit wir die Methoden aus Thread nutzen können.. :D
		Thread minionThread = new Thread(runner);

		minionThread.start();

		calThread.start();
		calThread2.start();
//		run methode soll nicht parallel aufgerufen werden, das wird es als normales Programm aufgerufen
		// das ist nicht sinn der Sache
//		calThread.run();

		// man checkt, wann der fertig ist man kann in den Klammern auch noch Warten
		// angeben
		// join wartet bis die Threads fertig sind und die run methode durchgelaufen ist
		// blockiert nicht.. isAlive checkt ab ob die überhaupt noch laufen
		try {
			calThread.join();
			calThread2.join();
			minionThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("bin fertig");
	}
}

/*
 * Man kann mit Interrupt und ...? Threads unterbrechen
 * 
 */
