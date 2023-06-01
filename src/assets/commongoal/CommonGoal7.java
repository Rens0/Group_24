package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonGoal7 extends CommonGoal {

    public CommonGoal7(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
    	int counter=0;
    	
    	for(int i=0;i<player.getLibreria().getRighe();i++) {
    		Set<String> tipi= new HashSet<>();
    		for(int j=0;j<player.getLibreria().getColonne();j++) {
    			String tipo= ritornoTipo(i,j,player);
        		if(tipo==null) {
        			break;
        		}
        		tipi.add(tipo);
        		if(tipi.size()<=3 && j==4) {
        			counter++;
        		}
        	}
    		if(counter>= 4)
    			return true;
    	}
    	return false;

    }

    private ArrayList<String> getArray(Player player, int index) {
        ArrayList<String> tessere = new ArrayList<>();
        //--- Utilizzo array di support

        for (int i = index; i < player.getLibreria().getRighe(); i++) {
            int counter = 0;
            if (tessere.size() != 3)
                tessere = new ArrayList<>();

            for (int j = 0; j < player.getLibreria().getColonne(); j++) {
                String tessera = ritornoTipo(i, j, player);
                if (tessera != null) {
                    counter++;
                    if (!tessere.contains(tessera))
                        tessere.add(tessera);
                }
            }
            if (tessere.size() == 3 && counter == player.getLibreria().getColonne())
                return tessere;
        }
        return null;
    }
}
