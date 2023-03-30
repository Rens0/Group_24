package game;
public class Player {

	private String name;
	private int ID; 
	private static int ID_Number=0; 
	private int points=0; 
	
	public Player (String name) {
		
		this.name=name;
		this.ID=ID_Number();  
		
	}
	
	private int ID_Number () {
		
		ID_Number++;
		ID=ID_Number;
		return ID; 
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int points) {
		
		 this.points+=points; 
	}
	
	public void print() {
		
		System.out.println("name: "+name);
		System.out.println(name+"'s ID is: "+ID);
		System.out.println("points: "+points);
	
	}


	
}