package assets.component;
import java.util.ArrayList;

import assets.card.Card;
import assets.card.CardContainer;

public class Player {

	private String name;
	public int ID;
	private static int ID_Number=0; 
	private int points=0; 
	public Libreria libreria;
	public CardContainer personalGoal;
	public Player (String name) {
		
		this.name=name;
		this.ID=ID_Number;
		ID_Number++;
		libreria = new Libreria();
	}
	

	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int points) {
		
		 this.points+=points; 
	}

	public int inserisciTessera(ArrayList <Card> card, ArrayList <Integer> ordine, int COLONNA) throws Exception {
		return libreria.inserisciTessere(card,ordine, COLONNA);

	}



	@Override
	public String toString() {
		return this.name+" "+this.ID+" "+this.points;
	}


}