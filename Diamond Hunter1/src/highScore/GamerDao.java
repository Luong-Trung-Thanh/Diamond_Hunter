package highScore;

import java.util.ArrayList;
import java.util.Collections;

public class GamerDao {
	public static ArrayList<Gamer> list = createListGamer();

	private static ArrayList<Gamer> createListGamer() {
		ArrayList<Gamer> list = new ArrayList<>();
		return list;
	}
	public static void add(String name, int score, String time) {
		Gamer g = new Gamer(name, score, time);
		list.add(g);
	}
	public void arrSort() {
		Collections.sort(list);
	}
} 
