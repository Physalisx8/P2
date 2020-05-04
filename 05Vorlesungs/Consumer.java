import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread { 
		
		private BlockingQueue<PanGalacticThunderGurgler> queue;

		public Consumer(BlockingQueue<PanGalacticThunderGurgler> queue) {
			super();
			this.queue = queue;
		}

		@Override
		public void run() {

			while(true) {
				try {
					PanGalacticThunderGurgler drink = queue.take();
					System.out.println(queue.size());
					System.out.println(drink.getOwner() + "\n" + drink.getHowto());
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}
	}


