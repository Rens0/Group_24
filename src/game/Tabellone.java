package game;
import card.Card;
import card.Cards;


import java.util.Random;

public class Tabellone{
	public String path;
	public String id;

	public int [][] mappa;
	public Cella [][] celle = new Cella[9][9];

	public Card randomTile(Cards tiles){
		Random rand = new Random();
		int rand1 = rand.nextInt(tiles.list.size());
		int rand2 = rand.nextInt(tiles.list.get(rand1).moreId.size());

		Card c = tiles.list.get(rand1);
		c.id = (String) tiles.list.get(rand1).moreId.get(rand2);

		if(tiles.list.get(rand1).amount>0) {
			tiles.list.get(rand1).amount--;
			System.out.println(tiles.list.get(rand1).id+" "+tiles.list.get(rand1).amount);


		}
		if(tiles.list.get(rand1).amount==0)
			tiles.list.remove(rand1);

		return c;
	}

	public void riempimento (Cards tiles)
	{

		for(int i = 0; i < mappa.length&&tiles.list.size()>0; i++){

			for(int j = 0; j<mappa[i].length&&tiles.list.size()>0;j++){

				if(celle[i][j] == null)
					celle[i][j] = new Cella();

				if(mappa[i][j]!=0){
					celle[i][j].setCella(randomTile(tiles));
					celle[i][j].attiva = true;
				}else{
					celle[i][j].attiva = false;
				}
			}
		}
		//riempe con le carte dentro la sacchetta/mazzo : GESTORE
		
		/*ntb le tessere alla fine del turno di un player se vicino alla tessera non ci sono altre tessere adiacenti,
		  allora la tavola deve essere ririempita, DXSX*/
	}
	public void print(){
		for(int i = 0; i < mappa.length; i++){
			for(int j = 0; j<mappa[i].length;j++){
				if(celle[i][j].attiva)
					System.out.println(celle[i][j].attiva+" "+celle[i][j].tile.toString());

			}
		}

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

