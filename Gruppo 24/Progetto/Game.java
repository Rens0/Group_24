import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int number=0;
		String name; 
		boolean verifica=true;
		
		System.out.println("Welcome to the game,\nnumber max of player: 4");
		
		do { 
			
			System.out.println("Insert your name: "); 
			
			
			Player [] p=new Player[4];
			Scanner scannerplayer = new Scanner (System.in); 
			name=scannerplayer.nextLine(); 
			p[number]=new Player(name,number);
			p[number].print();
			number++;
		
			
		
		if (number>=2) {
			
			if(number==4)
			{
				break;
			}
			
		}

		
		}while (verifica); 
		

		  
	
			
		
		
	}
	

}
