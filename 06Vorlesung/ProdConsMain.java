import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdConsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<PanGalacticThunderGurgler> queue = new LinkedBlockingQueue<PanGalacticThunderGurgler>();
		Consumer consumer = new Consumer(queue);
		Producer produver = new Producer(queue);
		
		consumer.start();
		produver.start();
		
	}

}
