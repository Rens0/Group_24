import assets.LivingRoom.Tabellone;
import assets.LivingRoom.TabelloneDeserializer;
import assets.card.CardContainer;
import assets.card.Goals;
import assets.component.Gestore;
import assets.component.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Inizializza l'applicazione
 *
 */
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
        path = "json/scoring_tokens.json";
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


        Goals personalGoal;
        path = "json/personal_goal.json";

        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            personalGoal = gson.fromJson(reader, Goals.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Tabellone tabellone;
        path = "json/tabellone.json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Tabellone.class, new TabelloneDeserializer());
            tabellone = gsonBuilder.create().fromJson(reader, Tabellone.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Player> players = new ArrayList<>();


        int number_of_players=0;
        do {
            System.out.print("Insert number of players: ");
            try {
                Scanner scanner = new Scanner(System.in);
                number_of_players = scanner.nextInt();
                if (number_of_players < 2 || number_of_players > 4)
                    System.out.println("Please insert from 2 to 4 players ");
            }catch (Exception e){
                System.out.println(e);
            }


        } while (number_of_players < 2 || number_of_players > 4);

        for (int i = 0; i < number_of_players; i++) {
            System.out.print("Insert player " + (i + 1) + " name: ");
            Scanner in = new Scanner(System.in);
            players.add(new Player(in.nextLine()));
        }
        tabellone.setPlayer(number_of_players);


        Gestore gestore = new Gestore(tabellone, players, commonGoal, scoringToken, tile, personalGoal);
        gestore.init();

        gestore.start();

    }

}