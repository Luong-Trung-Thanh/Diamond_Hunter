package highScore;

public class Gamer implements Comparable<Gamer> {
	private String name;
	private int score;
	private String time;
	public Gamer(String name, int score, String time) {
		this.name = name;
		this.score = score;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	//sap xep theo thoi gian
	//neu thoi gian == thi  sap xep theo ten
	@Override
	 public int compareTo(Gamer o) {
	  if(this.time.compareTo(o.time)== 0){
	   return this.name.compareTo(o.name);
	  }else{
	   return this.time.compareTo(o.time);
	  }
	 }
}
