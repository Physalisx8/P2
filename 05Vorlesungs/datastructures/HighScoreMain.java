package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HighScoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Highscore> highscore = new ArrayList<>();
		highscore.add(new Highscore("Pika", 42));
		highscore.add(new Highscore("Deadpool", 10000));
		highscore.add(new Highscore("Wolverine", 9999));
		highscore.add(new Highscore("Vegeta",90001));
		highscore.add(new Highscore("Edmund W", 42));
		highscore.add(new Highscore("Covid",1337));
		
		Collections.sort(highscore);
		
		for(Highscore score: highscore) {
			System.out.println(String.format("%20s:\t%d",score.getName(), score.getPoints()));
		}
	}

}
