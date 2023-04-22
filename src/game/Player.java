package game;
public class Player {

	private String name;
	public int ID;
	private static int ID_Number=0; 
	private int points=0; 
	
	public Player (String name) {
		
		this.name=name;
		this.ID=ID_Number;
		ID_Number++;
	}

	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int points) {
		
		 this.points+=points; 
	}

	@Override
	public String toString() {
		return this.name+" "+this.ID+" "+this.points;
	}
}