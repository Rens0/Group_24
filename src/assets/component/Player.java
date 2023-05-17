package assets.component;
import java.util.ArrayList;

import assets.card.Card;
import assets.card.CardContainer;

public class Player extends Libreria {

	private String name;
	public int ID;
	private static int ID_Number=0; 
	private int points=0;
	public ArrayList<Card>token;
	public CardContainer personalGoal;
	public ArrayList<Integer>commonGoal;

	public Player (String name) {
		this.name=name;
		this.ID=ID_Number;
		ID_Number++;
		token = new ArrayList<>();
		commonGoal= new ArrayList<>();

	}
	public void setCommonGoal(ArrayList<Integer>commonGoal){
		this.commonGoal = commonGoal;

	}

	public void addCommonToken(Card token){
		commonGoal.remove(token.id);
		this.token.add(token);
	}
	public void contaPunti(){
		for(Card t : token)
			points+=t.point;
		//--- Controllo dei punti in base alle tessere vicine
		//--- Controllo punti personal goal

	}


	

	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int points) {
		
		 this.points+=points; 
	}

	public int inserisciTessera(ArrayList <Card> card, ArrayList <Integer> ordine, int COLONNA) throws Exception {
		return inserisciTessere(card,ordine, COLONNA);

	}



	@Override
	public String toString() {
		return this.name+" "+this.ID+" "+this.points;
	}


}