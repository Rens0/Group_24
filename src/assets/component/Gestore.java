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
	public int maxTesserePescabili;
	public ArrayList<Goals>chosenCommonGoal;
	public Gestore(Tabellone tabellone, ArrayList<Player>players, CardContainer commonGoal, CardContainer scoringToken, CardContainer tile, Goals personalGoal) {
		this.tabellone = tabellone;
		this.players = players;
		this.commonGoal = commonGoal;
		this.scoringToken = scoringToken;
		this.tile = tile;
		this.personalGoal = personalGoal;
		chosenCommonGoal = new ArrayList<>();
		maxTesserePescabili = 3;
	}
	public void init(){
		for (Player player : players) {
			player.personalGoal = pickRandomPersonalGoal();//--- Assegnamento dei personal goal
		}
		for(int i = 0; i < 2; i++){//--- Assegnamento common goal
			chosenCommonGoal.add(new Goals(pickRandomCommonGoal()));//--- Assegnazione dei final token
			switch (players.size()) {
				case 2 -> {
					chosenCommonGoal.get(i).token.add(selectToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_8"));
				}
				case 3 -> {
					chosenCommonGoal.get(i).token.add(selectToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_6"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_8"));
				}
				case 4 -> {
					chosenCommonGoal.get(i).token.add(selectToken("scoring_2"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_4"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_6"));
					chosenCommonGoal.get(i).token.add(selectToken("scoring_8"));
				}
			}
		}


	}

	public void start() throws Exception {
		tabellone.riempimentoTabellone(tile);
		tabellone.print();
		boolean continua = false;
		do{
			for (Player player : players) {
				if (player.libreria.libreriaPiena())
					continua = true;
				pescaTesseraDalTabellone(player);                //--- Preleva tessera
				//--- Qui avvengono i preleva tessere e i vari controlli

			}

		}while(continua);
	}
	private void pescaTesseraDalTabellone(Player player) throws Exception {

		ArrayList<Card> card = prelevaTessera(); //--- tessere prelevate
		ArrayList<Integer> ordine = riordinamentoDelleTessere(card);

		System.out.println("Seleziona colonna: ");
		Scanner sc = new Scanner(System.in);
		//--- inserisciTessere ritorneta le tessere che non possono essere inserite nel tabellone
		//--- creare funzione per il rinserimento delle tessere qualora non ci stassero
		int colonna = sc.nextInt();
		int spaziLiberi = player.inserisciTessera(card, ordine, colonna );

		if (card.size()-spaziLiberi>0){
			tabellone.rimuoviTessere(tessereNonCiStanno(player, card, spaziLiberi, colonna));	//--- chiedo all'utente se vuole inserire le tessere
		}else
			tabellone.rimuoviTessere(card);
		tabellone.print();
		player.libreria.print();
	}
	private ArrayList<Card> prelevaTessera() throws Exception { //--- prelevo le posizioni delle tessere dal tabellone
		String continua = "";
		ArrayList<Card> card = new ArrayList<>();
		boolean controllo;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Scegli tessera "+(card.size()+1));
			System.out.print("Riga: ");
			int riga = sc.nextInt();
			System.out.print("Colonna: ");
			int colonna = sc.nextInt();

			card = tabellone.prelevaTessera(riga,colonna,card);
			if(card.size()==maxTesserePescabili)
				break;
			System.out.print("next/ no, per terminare: ");
			continua = sc.next();

		}while(!continua.toLowerCase().contains("next") );
		return card;
	}
	private ArrayList<Integer> riordinamentoDelleTessere(ArrayList<Card>card){
		String conferma;
		ArrayList<Integer>ordine=new ArrayList<>();
		if(card.size()-1>0) {
			do {
				System.out.println("Seleziona lordine delle tessere: ");
				Scanner sc = new Scanner(System.in);
				ordine = new ArrayList<>();
				for (int i = 0; i < card.size(); i++) {
					boolean continua;
					do {
						continua = false;
						System.out.print(card.get(i).type + " posizione: ");
						int numero = sc.nextInt();
						if (numero >= card.size() || numero < 0) {
							System.out.println("Errore indice");
							continua = true;
						}
						if (!continua) {
							if (ordine.contains(numero)) {
								System.out.println("Indice gia presente");
								continua = true;
							} else
								ordine.add(numero);
						}

					} while (continua);
				}
				System.out.print("conferma/ no: ");
				conferma = sc.next().toLowerCase();
			} while (!conferma.contains("conferma"));
		}else
			ordine.add(0);
		return ordine;
	}


	//--- Chiedo all'utente, cosa vuole fare nel caso le tessere non ci stanno nella sua colonna della libreria
	private ArrayList<Card> tessereNonCiStanno(Player player, ArrayList<Card>card, int spaziLiberi, int colonna) throws Exception {
		System.out.println("Queste tessere non ci stanno nella libreria: ");
		ArrayList<Card>tessereNonDisponibili = new ArrayList<>();
		for(int i = spaziLiberi; i <card.size(); i++){
			System.out.println(card.get(i).id);
			tessereNonDisponibili.add(card.get(i));
		}
		if(card.size()-spaziLiberi!=maxTesserePescabili){
			System.out.println("Vuoi aggiungere queste tessere? si/ no");
			ArrayList<Card>tessereDisponibili = new ArrayList<>();
			for(int i = 0; i <spaziLiberi; i++){
				System.out.println(card.get(i).id);
				tessereDisponibili.add(card.get(i));
			}

			Scanner sc = new Scanner(System.in);
			if(sc.next().toLowerCase().equals("si")){
				ArrayList<Integer> ordine = riordinamentoDelleTessere(tessereDisponibili);
				player.inserisciTessera(tessereDisponibili, ordine, colonna);
				return tessereDisponibili;
			}
		}
		System.out.println("Le tessere non ci stanno seleziona nuova colonna [colonna]/ ripesca [ripesca]");
		Scanner sc = new Scanner(System.in);
		if(sc.next().toLowerCase().equals("colonna")){
			System.out.print("Inserisci colonna: ");
			tessereNonCiStanno(player,card,spaziLiberi,sc.nextInt());
		}else{
			tabellone.inserisciTessere(card);
			pescaTesseraDalTabellone(player);
		}
		return card;
	}

	private Card selectToken(String id){
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
