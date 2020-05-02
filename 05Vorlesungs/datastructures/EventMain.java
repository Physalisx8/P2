package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class EventMain {

	public static void main(String[] args) {

		ArrayList<Event> events = new ArrayList<>();
		events.add(new Event("Wacken OA", "Wacken", "02.08.2019"));
		events.add(new Event("Wacken OA", "Wacken", "02.08.2019"));
		events.add(new Event("Wanderlust", "Berlin", "07.08.2019"));
		events.add(new Event("Tough Mudder", "Hannover", "09.09.2019"));
		events.add(new Event("lunatic", "Lüneburg", "09.08.2019"));

		Collections.sort(events);

		for (Event even : events) {
			System.out.println(even.getEventname() + " , " + even.getLocation() + " , " + even.getStart());
		}

	}
}
