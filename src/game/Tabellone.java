package game;
import card.Card;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Tabellone {
	public Celle [][] celle;
	public String path;

	public void riempimento()
	{
		//riempe con le carte dentro la sacchetta/mazzo : GESTORE
		
		/*ntb le tessere alla fine del turno di un player se vicino alla tessera non ci sono altre tessere adiacenti,
		  allora la tavola deve essere ririempita, DXSX*/
	}
	
	/*public Celle pesca(int posizione)
	{
		//controlli, risettaggio cella vuota
		return list.get(posizione);
	}
	
	public void inserisciTessera(Card card, int posizione) {
		//da vedere
	}*/
}

