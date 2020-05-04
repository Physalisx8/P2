
public class CalcThread extends Thread {

	// Threads laufen, alles was man machen will, kommt in die Run Methode


	//einfachster Thread, der zahlen von 0-20ausgibt. 
	@Override
	public void run() {
		super.run();

		for(int i = 0; i<20;i++) {
			System.out.println(i);
			//Threads können schlafen gelegt werden
			//try/catch muss angelegt werden, für den fall dass es unterbrochen wird
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
