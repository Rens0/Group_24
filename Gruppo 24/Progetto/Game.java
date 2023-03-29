import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int id=0;
		String name; 
		boolean verifica=true;
		int scelta=0;
		int number=0;
		System.out.println("Welcome to the game,\nnumber max of player: 4");
		
		do { 
			
			System.out.println("Insert your name: "); 
			number++;
			
			Player [] p=new Player[4];
			Scanner scannerplayer = new Scanner (System.in); 
			name=scannerplayer.nextLine(); 
			p[id]=new Player(name,id);
			p[id].print();
			
		
			
		
		if (number>=2) {
			System.out.println("Premi 1 per terminare l'inserimento dei giocatori,"
					+ "\naltrimenti premi un altro numero per continuare l'inserimento"+ "");
			Scanner scannerint = new Scanner(System.in);
			scelta=scannerint.nextInt();
			if(number==3)
			{
				break;
			}else
			{
				if(scelta==1) 
				
			{
			verifica=false;
			}
			}
			
		}
		id++;
		
		}while (verifica); 
		

		  
	
			
		
		
	}
	

}
