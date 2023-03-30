package game;
import java.util.Scanner;

public class Game {


	
	
	public static void main(String[] args) {
		int number_of_players;
		String name; 
		
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
		

		
	}
	
	

}