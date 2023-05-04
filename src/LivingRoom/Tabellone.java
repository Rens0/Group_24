package LivingRoom;
import card.Card;
import game.Cella;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabellone{
	public String path;
	public String id;
	public int nPlayer;

	public List<ArrayList<Cella>> mappa;

	public Tabellone(){
		mappa = new ArrayList<ArrayList<Cella>>();
	}

	public void setPlayer(int nPlayer){
		this.nPlayer = nPlayer;
	}
	public Card randomTile(Cards tiles){
		Random rand = new Random();
		int rand1 = rand.nextInt(tiles.list.size());
		int rand2 = rand.nextInt(tiles.list.get(rand1).moreId.size());

		Card c = tiles.list.get(rand1);
		c.id = (String) tiles.list.get(rand1).moreId.get(rand2);

		if(tiles.list.get(rand1).amount>0) {
			tiles.list.get(rand1).amount--;
		//	System.out.println(tiles.list.get(rand1).id+" "+tiles.list.get(rand1).amount);


		}
		if(tiles.list.get(rand1).amount==0)
			tiles.list.remove(rand1);

		return c;
	}

	public void riempimento (Cards tiles)
	{


		/*for(int i = 0; i < mappa.length&&tiles.list.size()>0; i++){

			for(int j = 0; j<mappa[i].length&&tiles.list.size()>0;j++){

				if(celle[i][j] == null)
					celle[i][j] = new Cella();

				if(mappa[i][j]!=0){
					switch (nPlayer){
						case 2:{
							if(mappa[i][j]==2)
								setCella(i,j,tiles);
							break;
						}
						case 3:{
							if(mappa[i][j]>=2&&mappa[i][j]<=3)
								setCella(i,j,tiles);
							break;
						}
						case 4:{
							if(mappa[i][j]>=2&&mappa[i][j]<=4)
								setCella(i,j,tiles);
							break;
						}
					}
				}else{
					celle[i][j].stato = false;
				}
			}
		}*/
		//riempe con le carte dentro la sacchetta/mazzo : GESTORE
		
		/*ntb le tessere alla fine del turno di un player se vicino alla tessera non ci sono altre tessere adiacenti,
		  allora la tavola deve essere ririempita, DXSX*/
	}
	public void setCella(int i, int j, Cards tiles){
		//celle[i][j].setCella(randomTile(tiles));
		//celle[i][j].stato = true;
	}
	public void print(){
		for(int i = 0; i < mappa.size(); i++){
			for(int j = 0; j<mappa.get(i).size();j++){
				System.out.print(mappa.get(i).get(j).access);

			}
			System.out.println();
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

