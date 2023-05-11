package LivingRoom;
import card.Card;
import card.CardContainer;
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

	public void riempimentoTabellone(CardContainer card) {
		for(int i=0; i<mappa.size();i++) {
			for(int j=0; j<mappa.get(i).size();j++) {
				switch (nPlayer) {
					case 2:{
						if(mappa.get(i).get(j).accessibilitaCella ==2) {
							mappa.get(i).get(j).setCella(randomCard(card));
						}
						break;
					}
					case 3:{
						if(mappa.get(i).get(j).accessibilitaCella >=2&&mappa.get(i).get(j).accessibilitaCella <=3) {
							mappa.get(i).get(j).setCella(randomCard(card));
						}

						break;
					}
					case 4:{
						if(mappa.get(i).get(j).accessibilitaCella >=2&&mappa.get(i).get(j).accessibilitaCella <=4) {
							mappa.get(i).get(j).setCella(randomCard(card));
						}
						break;
					}
				}
			}
		}
	}

	private Card randomCard(CardContainer card) {
		Random rand = new Random();
		int randomCard = rand.nextInt(card.list.size());
		Card cardSalvata = card.list.get(randomCard);
		int sum = 0;
		for(Card c : card.list){
			sum+=c.amount;
		}

		if(sum<=0)
			return new Card();
		if(cardSalvata.amount<=0) {
			randomCard(card);
		}

		//card.list.remove(valore);
		int randomId = rand.nextInt(card.list.get(randomCard).moreId.size());
		String id = card.list.get(randomCard).moreId.get(randomId);
		String type =  card.list.get(randomCard).type;

		cardSalvata = new Card(id, type);
		//System.out.println(cardSalvata.id);
		card.list.get(randomCard).amount--;

		return cardSalvata;
	}

	public void print(){
		for(int i = 0; i < mappa.size(); i++){
			for(int j = 0; j<mappa.get(i).size();j++){
				if(mappa.get(i).get(j).getTessera().id==null) {
					System.out.print(".......\t");
				} else {
					System.out.print(mappa.get(i).get(j).getTessera().type+"\t");
				}


			}

			System.out.println();
		}

	}

	public Card ritornoTessera(int riga, int colonna) {
		Card tipo;
		tipo = mappa.get(riga).get(colonna).tile;
		return tipo;
	}

	public boolean controlloTessereVicine() {
		for(int i = 0; i < mappa.size(); i++){
			for(int j = 0; j < mappa.get(0).size(); j++){
				if(i==mappa.size()-1&&j>=mappa.get(0).size()-1)
					break;
				if(mappa.get(i).get(j).tile.id!=null){

					if(j>=mappa.get(0).size()-1) {

						if (controlloRighe(i, j).type != null)
							return true;
					}
					else {

						if (controlloColonna(i, j).id != null)
							return true;
					}

					if(i>=mappa.size()-1) {
						if(controlloColonna(i, j).id!=null)
							return true;

					}else {
						if(controlloRighe(i, j).id!=null)
							return true;
					}
				}

			}

		}
		return false;
	}
	public Card controlloRighe(int riga, int colonna){

		return mappa.get(riga+1).get(colonna).tile;

	}
	public Card controlloColonna(int riga, int colonna){

		return mappa.get(riga).get(colonna+1).tile;
	}

	public ArrayList<Card> prelevaTessera(ArrayList <ArrayList<Integer>>posizioni){

		ArrayList<Card>cardSelezionate= new ArrayList<>();

		for(int i=0; i<posizioni.size();i++) {
			int k=0;
			if(posizioni.get(i).get(k)>=mappa.size())
				return null;
			if(posizioni.get(i).get(k+1)>=mappa.get(0).size())
				return null;
			cardSelezionate.add(mappa.get(posizioni.get(i).get(k)).get(posizioni.get(i).get(k+1)).tile);
			mappa.get(posizioni.get(i).get(k)).get(posizioni.get(i).get(k+1)).tile=new Card();
		}

		return cardSelezionate;
	}

    /*public Card randomTile(Cards tiles){
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
	}*/

    /*public void riempimento (Cards tiles)
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
	//}
	//public void setCella(int i, int j, Cards tiles){
	//celle[i][j].setCella(randomTile(tiles));
	//celle[i][j].stato = true;
	//}



    /*public Celle pesca(int posizione)
	{
		//controlli, risettaggio cella vuota
		return list.get(posizione);
	}
	
	public void inserisciTessera(Card card, int posizione) {
		//da vedere
	}*/


}

