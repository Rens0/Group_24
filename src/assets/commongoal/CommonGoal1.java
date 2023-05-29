package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal1 extends CommonGoal {

    public CommonGoal1(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        for (int i = 0; i < player.getLibreria().getRighe() - 1; i++) {
            for (int j = 0; j < player.getLibreria().getColonne() - 1; j++) {
                boolean controllo = false;
                if (ritornoTipo(i, j, player) != null && ritornoTipo(i, j + 1, player) != null 
                		&& ritornoTipo(i + 1, j, player) != null && ritornoTipo(i + 1, j + 1, player) != null) {
                    		controllo = ritornoTipo(i, j, player).equals(ritornoTipo(i, j + 1, player))
                    				&& ritornoTipo(i, j, player).equals(ritornoTipo(i + 1, j, player)) 
                    					&& ritornoTipo(i + 1, j, player).equals(ritornoTipo(i + 1, j + 1, player));

                }
                if (controllo)
                    counter++;

            }
        }
        if (counter >= 2)
            return true;
        return false;
    }


}
