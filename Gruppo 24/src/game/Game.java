package game;
import card.CardList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Game {

	public static void main(String[] args) {
		String path = "Gruppo 24/cards.json";
		CardList card = new CardList();
		//--- Creo file gson
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			//--- Leggo da file
			BufferedReader br = new BufferedReader(new FileReader(path));
			//--- Carico dal file json i dati
			card = gson.fromJson(br, CardList.class);
			//System.out.println(card.common_goal.list.get(0).description);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
/*




		int number_of_players;
		ArrayList<Player>players = new ArrayList<>();
		Scanner scanner = new Scanner (System.in); 
		
		do { 
			System.out.println("Insert number of players: ");
			number_of_players = scanner.nextInt();

			if (number_of_players<2 || number_of_players>4)
				System.out.println("Please insert from 2 to 4 players ");

		} while (number_of_players<2 || number_of_players>4);

		for (int i=0; i<number_of_players; i++) {
			System.out.println("Insert player" + (i+1)+" name: " );
			Scanner in = new Scanner (System.in);
			players.add(new Player(in.nextLine()));
			System.out.println(players.get(i).toString());
		}*/

	}

}