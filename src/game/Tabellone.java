package game;
import card.Card;
import java.util.ArrayList;

public class Tabellone {
	public ArrayList <Celle> celle;
	
	public Tabellone() {
		
		for(int i=0; i<45;i++)
		{
			celle.add(new Celle());
		}
	}

	public void riempimento()
	{
		//riempe con le carte dentro la sacchetta/mazzo : GESTORE
		
		/*ntb le tessere alla fine del turno di un player se vicino alla tessera non ci sono altre tessere adiacenti,
		  allora la tavola deve essere ririempita, DXSX*/
	}
	
	public Celle pesca(int posizione)
	{
		//controlli, risettaggio cella vuota
		return celle.get(posizione);
	}
	
	public void inserisciTessera(Card card, int posizione) {
		//da vedere
	}
}

