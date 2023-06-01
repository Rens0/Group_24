package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal4 extends CommonGoal {

    public CommonGoal4(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        
        player.getLibreria().contaCaselleGruppi(); 
        ArrayList<Integer> gruppi=player.getLibreria().getCaselleGruppo();
        for(int i: gruppi) {
        	if(i>=2) {
        		counter++; 
        	}
        	if(counter>=6) {
        		return true; 
        	}
        }
        return false; 
    }
}
