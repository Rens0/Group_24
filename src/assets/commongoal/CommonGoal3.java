package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;
import java.util.List;

public class CommonGoal3 extends CommonGoal {

    public CommonGoal3(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
    	
    	int counter=0; 
    	player.getLibreria().contaCaselleGruppi();
    	ArrayList<Integer> gruppi=player.getLibreria().getCaselleGruppo();
    	for(int i: gruppi) {
    		if(i>=4) {
    			counter++;
    		}
    		if(counter>=4) {
    			return true;
    		}
    	}
    	return false;
    	}
    	
}
