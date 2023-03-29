

public class Player {

	private String name;
	private int ID; 
	
	public Player (String name, int Number) {
		this.name=name;
		this.ID=Number;  
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	public void print() {
		System.out.println("name: "+name);
		System.out.println(name+"'s ID is: "+ID);
	}
	
	

}
