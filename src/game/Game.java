package game;
import card.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {

	public static void main(String[] args) {
		String path;
		Gson gson = new Gson();

		Cards commonGoal;
		path = "json/common_goal.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			commonGoal = gson.fromJson(reader, Cards.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}



		Cards scoringTokens;
		path = "json/scoring_tokens.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			scoringTokens = gson.fromJson(reader, Cards.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		PersonalGoals personalGoals;
		path = "json/personal_goal.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			personalGoals = gson.fromJson(reader, PersonalGoals.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		Cards tiles;
		path = "json/tiles.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			tiles = gson.fromJson(reader, Cards.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Tabellone tabellone;
		path= "json/tabellone.json";
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Tabellone.class, new TabelloneDeserializer());
			tabellone = gsonBuilder.create().fromJson(reader, Tabellone.class);
			//System.out.println(tabellone.mappa.size());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		//tabellone.print();





		//tabellone.setPlayer(4);
		//tabellone.riempimento(tiles);
		/*
		Libreria libreria= new Libreria();
		ArrayList <Card> card = new ArrayList<>();
		card.add(new Card());
		card.add(new Card());
		libreria.inserisciTessere(card,1);
		*/

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