package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;

import java.util.ArrayList;
import java.util.Random;

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
		boolean continua = false;
		do{
			for(int i = 0; i < players.size(); i++){
				if(players.get(i).libreria.libreriaPiena())
					continua = true;
				//--- Qui avvengono i preleva tessere e i vari controlli

			}

		}while(continua);
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
