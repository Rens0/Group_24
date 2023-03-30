package game;
import java.util.Scanner;

public class Game {

	private static int colonne=6;
	private static int righe=5;
	
	
	public static void main(String[] args) {
		int number_of_players;
		String name; 
		int c=1;
		do { 
		System.out.println("Insert number of players: "); 
		Scanner scanner = new Scanner (System.in); 
		number_of_players = scanner.nextInt();
		
		if (number_of_players<2 || number_of_players>4) {
			System.out.println("Please insert from 2 to 4 players "); 
		}
		}while (number_of_players<2 || number_of_players>4); 
		
		Player [] p=new Player[number_of_players];
		
			for (int i=0; i<number_of_players; i++) {
				System.out.println("Insert player name: " + (i+1)); 
				Scanner in = new Scanner (System.in); 
				name=in.nextLine(); 
				p[i]=new Player(name);
			}
		  	
		p[0].print();
		p[1].print();
		
		for(int b=0;b<righe;b++)
		 {
			 for(int j=0;j<colonne;j++)
			 {
				 System.out.print("*");
			 }
			 System.out.print("\n");
		 }
		
	}
	
	

}