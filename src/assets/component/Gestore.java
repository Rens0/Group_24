package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gestore {
	
	public Tabellone tabellone;
	public ArrayList<Player>players;
	public CardContainer commonGoal;
	public CardContainer scoringToken;
	public CardContainer tile;
	public Goals personalGoal;
	public ArrayList<Goals>chosenCommonGoal;
	public Gestore(Tabellone tabellone, ArrayList<Player>players, CardContainer commonGoal, CardContainer scoringToken, CardContainer tile, Goals personalGoal) {
		this.tabellone = tabellone;
		this.players = players;
		this.commonGoal = commonGoal;
		this.scoringToken = scoringToken;
		this.tile = tile;
		this.personalGoal = personalGoal;
		chosenCommonGoal = new ArrayList<>();
	}
	public void init(){
		for(int i = 0; i < players.size(); i++){
			players.get(i).personalGoal=pickRandomPersonalGoal();//--- Assegnamento dei personal goal
		}
		for(int i = 0; i < 2; i++){//--- Assegnamento common goal
			chosenCommonGoal.add(new Goals(pickRandomCommonGoal()));//--- Assegnazione dei final token
			switch (players.size()){
				case 2:{
					chosenCommonGoal.get(i).token.add(pickToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_8"));
					break;
				}
				case 3:{
					chosenCommonGoal.get(i).token.add(pickToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_6"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_8"));
					break;
				}
				case 4:{
					chosenCommonGoal.get(i).token.add(pickToken("scoring_2"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_6"));
					chosenCommonGoal.get(i).token.add(pickToken("scoring_8"));
					break;
				}

			}
		}


	}

	public void start(){
		tabellone.riempimentoTabellone(tile);
		tabellone.print();
		boolean continua = false;
		do{
			for(int i = 0; i < players.size(); i++){
				if(players.get(i).libreria.libreriaPiena())
					continua = true;
				pickCard(players.get(i));				//--- Preleva tessera
				//--- Qui avvengono i preleva tessere e i vari controlli

			}

		}while(continua);
	}
	private void pickCard(Player player){

		ArrayList<Card> card = prelevaTessera(); //--- tessere prelevate
		ArrayList<Integer> ordine = ordineDelleTessere(card);

		System.out.println("Seleziona colonna: ");
		Scanner sc = new Scanner(System.in);
		//--- inserisciTessere ritorneta le tessere che non possono essere inserite nel tabellone
		//--- creare funzione per il rinserimento delle tessere qualora non ci stassero
		player.inserisciTessera(card, ordine, sc.nextInt());
		tabellone.print();
		player.libreria.print();
	}
	private ArrayList<Integer> ordineDelleTessere(ArrayList<Card>card){
		String conferma;
		ArrayList<Integer>ordine;
		do{
			System.out.println("Seleziona lordine delle tessere: ");
			Scanner sc = new Scanner(System.in);
			ordine = new ArrayList<>();
			for(int i = 0; i < card.size(); i++){
				boolean continua;
				do{
					continua = false;
					System.out.print(card.get(i).type+" posizione: ");
					int numero = sc.nextInt();
					if(numero>=card.size()||numero<0) {
						System.out.println("Errore indice");
						continua = true;
					}
					if(!continua) {
						if (ordine.contains(numero)) {
							System.out.println("Indice gia presente");
							continua = true;
						} else
							ordine.add(numero);
					}

				}while(continua);
			}
			System.out.print("conferma/ no: ");
			conferma = sc.next().toLowerCase();
		}while(!conferma.contains("conferma"));
		return ordine;
	}
	private ArrayList<Card> prelevaTessera(){ //--- prelevo le posizioni delle tessere dal tabellone
		String continua = "";
		ArrayList<Card> card = new ArrayList<>();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Scegli tessera");
			System.out.print("Riga: ");
			int riga = sc.nextInt();
			System.out.print("Colonna: ");
			int colonna = sc.nextInt();
			//--- Qua si deve fare il controllo che le tessere prelevate siano sulla stessa retta

			if(tabellone.mappa.get(riga).get(colonna).tile.id==null)//--- Controllo che la tessera selezionata non sia null
				System.out.println("Errore");
			else
			//if controllo
			{
				try {
					card.add(tabellone.prelevaTessera(riga, colonna));
				} catch (Exception e) {
					System.out.println(e);
				}finally {
					//else {
					if(card.size()>=3)
						break;

					System.out.print("next/ no, per terminare: ");
					continua = sc.next();
					//}
				}
			}

		}while(!continua.toLowerCase().contains("next"));

		return card;
	}
	private Card pickToken(String id){
		for(int i = 0; i < scoringToken.list.size(); i++){
			if ( scoringToken.list.get(i).id.equals(id)) {

				return scoringToken.list.get(i);
			}
		}
		return null;
	}


	private CardContainer pickRandomPersonalGoal(){
		Random rand = new Random();
		int randomCard = rand.nextInt(personalGoal.list.size());
		CardContainer personalGoal = this.personalGoal.list.get(randomCard);
		this.personalGoal.list.remove(randomCard);
		return personalGoal;
	}
	private Card pickRandomCommonGoal(){
		Random rand = new Random();
		int randomCard = rand.nextInt(commonGoal.list.size());
		Card commonGoal = this.commonGoal.list.get(randomCard);
		this.commonGoal.list.remove(randomCard);
		return commonGoal;
	}




}
