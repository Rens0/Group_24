package game;
public class Player {

	private String name;
	private int ID; 
	private static int ID_Number=0; 
	public Player() {}
	
	public Player (String name) {
		this.name=name;
		//ID_Number++;
		this.ID=ID_Number();  
		//this.ID=ID_Number; 
	}
	
	private int ID_Number () {
		ID_Number++;
		ID=ID_Number;
		return ID; 
	}
	
	//stampa
	public void print() {
		System.out.println("name: "+name);
		System.out.println(name+"'s ID is: "+ID);
	}
	
	

}