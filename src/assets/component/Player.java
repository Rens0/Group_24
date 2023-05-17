package assets.component;
import java.util.ArrayList;

import assets.card.Card;
import assets.card.CardContainer;

public class Player extends Libreria {

	public String name;
	public int ID;
	private static int ID_Number=0; 
	private int points=0;
	public ArrayList<Card>token;
	public CardContainer personalGoal;
	public ArrayList<Card> id_commonGoal;

	public Player (String name) {
		this.name=name;
		this.ID=ID_Number;
		ID_Number++;
		token = new ArrayList<>();



	}
	public void setId_commonGoal(ArrayList<Card> id_commonGoal){
		this.id_commonGoal = new ArrayList<>(id_commonGoal);



	}
	//---Aggiungo il token e rimuovo l'id
	public void addToken(Card token, Card goal){
		this.id_commonGoal.remove(goal);
		this.token.add(token);
	}
	public void addToken(Card token){
		this.token.add(token);
	}

	public void contaPunti(){
		for(Card t : token) //---punti dei common goal
			points+=t.point;
		points+=personalGoal.point.get(controlloPeronsalGoal());//--- Controllo punti personal goal
		//--- Controllo dei punti in base alle tessere vicine
	}
	private int controlloPeronsalGoal(){
		int contatore = 0;
		for(int i = 0; i < personalGoal.list.size(); i++){
			Card card = personalGoal.list.get(i);
			if(card.type==libreria.get(card.row).get(card.column).tile.type)
				contatore++;
		}
		return contatore;
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


	public void tokenPrint() {

		for(Card t : token)
			System.out.println(t.id);
	}
}