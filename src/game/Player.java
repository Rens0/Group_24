package game;
import java.util.ArrayList;
import card.Card;
public class Player {

	private String name;
	public int ID;
	private static int ID_Number=0; 
	private int points=0; 
	public Libreria libreria;
	
	public Player (String name) {
		
		this.name=name;
		this.ID=ID_Number;
		ID_Number++;
		libreria = new Libreria();
	}
	
	public void inserisciTessere(int posizione,ArrayList <Integer> ordine, ArrayList <Card> card)
	{
		// 1,2,3 + controlli se n tessere superano la dimensione massima della colonna 
		//return n leght- n tessere con lastpose (da vedere)
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int points) {
		
		 this.points+=points; 
	}
	
	public ArrayList<Card> drawItemTiles(Tabellone t ){
		ArrayList<Card> drawItemTiles= new ArrayList<Card>(); 
		if(/*t.getTessera().pescabile()*/true) {
			drawItemTiles.add(null); 
		}//da completare
		return drawItemTiles; 
	}
	
	public void inserisciTessera(ArrayList <Card> card, int COLONNA)
	{
		this.libreria.inserisciTessere(card, COLONNA);
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.ID+" "+this.points;
	}
}