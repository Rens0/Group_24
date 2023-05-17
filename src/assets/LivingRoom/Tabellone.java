package assets.LivingRoom;
import assets.card.Card;
import assets.card.CardContainer;
import assets.component.Cella;


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
							mappa.get(i).get(j).setCella(randomCard(card,i,j));
						}
						break;
					}
					case 3:{
						if(mappa.get(i).get(j).accessibilitaCella >=2&&mappa.get(i).get(j).accessibilitaCella <=3) {
							mappa.get(i).get(j).setCella(randomCard(card,i,j));
						}

						break;
					}
					case 4:{
						if(mappa.get(i).get(j).accessibilitaCella >=2&&mappa.get(i).get(j).accessibilitaCella <=4) {
							mappa.get(i).get(j).setCella(randomCard(card,i,j));
						}
						break;
					}
				}
			}
		}
	}

	private Card randomCard(CardContainer card, int riga, int colonna) {
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
			randomCard(card, riga, colonna);
		}

		//test.card.list.remove(valore);
		int randomId = rand.nextInt(card.list.get(randomCard).moreId.size());
		String id = card.list.get(randomCard).moreId.get(randomId);
		String type =  card.list.get(randomCard).type;

		cardSalvata = new Card(id, type);
		cardSalvata.setCoord(riga, colonna);
		//System.out.println(cardSalvata.id);
		card.list.get(randomCard).amount--;

		return cardSalvata;
	}
	public void inserisciTessere(ArrayList<Card>card){
		for(int i = 0; i < card.size(); i++){
			mappa.get(card.get(i).row).get(card.get(i).column).tile=card.get(i);
		}

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

	public Card getTessera(int riga, int colonna) throws Exception {

		if(riga<0||colonna<0)
			throw new Exception("Indice negativo");
		if(riga>mappa.size())
			throw new Exception("riga "+riga+" > "+mappa.size());
		if(colonna>mappa.get(0).size())
			throw new Exception("colonna "+colonna+" > "+mappa.get(0).size());
		if(mappa.get(riga).get(colonna).tile.id==null)
			throw new Exception("La tessera selezionata non è disponibile");

		Card cartaSelezionata = mappa.get(riga).get(colonna).tile;
		if(cartaSelezionata.type==null)
			throw new Exception("La carta e' null ");

		return cartaSelezionata;

	}

	public boolean controlloTessereVicine() {
		for(int i = 0; i < mappa.size(); i++){
			for(int j = 0; j < mappa.get(0).size(); j++){
				if(i==mappa.size()-1&&j>=mappa.get(0).size()-1)
					break;
				Card card = mappa.get(i).get(j).tile;
				if(card.id!=null){
					if(j>=mappa.get(0).size()-1) {
						if (controlloRighaSotto(card))
							return true;
					}
					else {
						if (controlloColonnaDestra(card))
							return true;
					}
					if(i>=mappa.size()-1) {
						if(controlloColonnaDestra(card))
							return true;
					}else {
						if(controlloRighaSotto(card))
							return true;
					}
				}

			}

		}
		return false;
	}
	public boolean controlloSpazioLibero(Card card) {//se trova uno spazio libero ritorna true seno false


		//---- se ci troviamo in pos 0 0 controlliamo sotto e a destra
		if(card.row==0&&card.column==0) {
			return true;
		}
		//--- se ci troviamo in pos [mappa.size-1; 0] controlliamo sopra e a destra
		if(card.row==mappa.size()-1&&card.column==0) {
			return true;
		}
		//--- se ci troviamo in posizione [0; mappa.get(0).size-1) controlliamo a sinistra e sotto
		if(card.row==0&&card.column==mappa.get(0).size()-1){
			return true;
		}
		//--- se ci troviamo in posizione [mappa.size()-1, mappa.get(0).size-1] controllo sopra e sx
		if(card.row==mappa.size()-1&&card.column==mappa.get(0).size()-1){
			return true;
		}
		//---Se sono alla riga 0 controllo sotto a dx e a sx
		if(card.row==0){
			return controlloColonnaDestra(card)&&controlloColonnaSinistra(card)&&controlloRighaSotto(card);
		}
		//---Se sono alla riga mappa.size()-1 controllo sopra sx dx
		if(card.row==mappa.size()-1)
			return controlloRighaSopra(card)&&controlloColonnaDestra(card)&&controlloColonnaSinistra(card);
		//---Se sono alla colonna 0 controllo sopra sotto dx
		if(card.column==0)
			return controlloRighaSopra(card)&&controlloRighaSotto(card)&&controlloColonnaDestra(card);
		//---Se sono alla colonna = mappa.get(0).size-1 controllo sopra sotto sx
		if(card.column==mappa.get(0).size()-1)
			return controlloRighaSopra(card)&&controlloRighaSotto(card)&&controlloColonnaSinistra(card);

		return controlloColonnaDestra(card)&&controlloColonnaSinistra(card)&&controlloRighaSopra(card)&&controlloRighaSotto(card);


	}
	public Boolean controlloRighaSotto(Card card){
		if(mappa.get(card.row+1).get(card.column).tile.type!=null)
			return true;
		return false;
	}
	public Boolean controlloColonnaDestra(Card card){
		if(mappa.get(card.row).get(card.column+1).tile.type!=null)
			return true;
		return false;
	}
	public Boolean controlloRighaSopra(Card card){
			if( mappa.get(card.row-1).get(card.column).tile.type!=null)
			return true;
		return false;
	}
	public Boolean controlloColonnaSinistra(Card card){
		if (mappa.get(card.row).get(card.column-1).tile.type!=null)
			return true;
		return false;
	}

	public void rimuoviTessera(Card card) throws Exception {
		mappa.get(card.row).get(card.column).tile = new Card();
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
	
	public void inserisciTessera(Card test.card, int posizione) {
		//da vedere
	}*/


}

