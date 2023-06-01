package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonGoal5 extends CommonGoal {

    public CommonGoal5(String path, ArrayList<Card> token) {
        super(path, token);
    }
    
    public boolean controllo(Player player) {
    int counter=0; 
    for(int j=0; j<player.getLibreria().getColonne(); j++) {
    	Set <String> tipi = new HashSet<>(); 
    	for (int i=0; i<player.getLibreria().getRighe(); i++) {
    		String tipo= ritornoTipo(i, j, player); 
    		if(tipo==null) {
    			break; 
    		}
    		
    		tipi.add(tipo); 
    		
    		if (tipi.size()<=3 && i==5) {
    			counter++; 
    		}
    		
    	}
    		if(counter>=4) 
    			return true; 
    }
    return false; 
   }
}
