import java.util.Scanner;

public class TimerMain {
	public static void main(String[] args) {
		
		TimerThread timer = new TimerThread();
		
		timer.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		
		timer.stopTimer();
	}

}
