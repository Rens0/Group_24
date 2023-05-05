package game;
import LivingRoom.Tabellone;
import LivingRoom.TabelloneDeserializer;
import card.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Game {

	public static void main(String[] args) {
		String path;
		Gson gson = new Gson();

		CardContainer commonGoal;
		path = "json/common_goal.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			commonGoal = gson.fromJson(reader, CardContainer.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		CardContainer scoringToken;
		path= "json/scoring_tokens.json";
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			scoringToken = gson.fromJson(reader, CardContainer.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		CardContainer tile;
		path = "json/tiles.json";
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			tile = gson.fromJson(reader, CardContainer.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}





		PersonalGoals personalGoal;
		path = "json/personal_goal.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			personalGoal = gson.fromJson(reader, PersonalGoals.class);
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

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//System.out.println(tabellone.mappa.get(0).size());
		tabellone.setPlayer(4);
		tabellone.riempimentoTabellone(tile);
		tabellone.print();


		/*
		List<Card> personalGoal;
		path = "json/personal_goal.json";

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(new TypeToken<List<Card>>(){}.getType(), new CardDeserializer());
			scoringToken = gsonBuilder.create().fromJson(reader, new TypeToken<List<Card>>(){}.getType());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/





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