package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal6 extends CommonGoal {

    public CommonGoal6(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        for (int j = 0; j < player.getLibreria().getRighe(); j++) {
            Boolean controllo = true;
            for (int i = 0; i < player.getLibreria().getColonne(); i++) {
                String tessera = ritornoTipo(j, i, player);
                if (tessera != null) {
                    for (int k = 0; k < player.getLibreria().getColonne(); k++) {
                        String tesseran = ritornoTipo(j, k, player);
                        if (tesseran != null) {
                            if (k != i && tessera.equals(tesseran)) {
                                controllo = false;
                            }
                        } else {
                            controllo = false;
                            break;
                        }
                    }

                } else
                    controllo = false;

            }
            if (controllo)
                counter++;
        }
        return (counter >= 2);


    }
}
