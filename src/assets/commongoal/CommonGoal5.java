package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal5 extends CommonGoal {

    public CommonGoal5(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        ArrayList<String> base = getArray(player, 0);
        if (base != null) {
            for (int i = 0; i < player.getLibreria().getColonne(); i++) {
                int controllo = 0;

                ArrayList<String> confronto = getArray(player, i);
                if (confronto != null) {
                    for (int j = 0; j < confronto.size(); j++) {
                        if (confronto.get(j).contains(base.get(j))) {
                            controllo++;
                        }
                    }
                }
                if (controllo == base.size())
                    counter++;

            }


        }


        return (counter >= 3);
    }

    private ArrayList<String> getArray(Player player, int index) {
        ArrayList<String> tessere = new ArrayList<>();
        //--- Utilizzo array di support

        for (int i = index; i < player.getLibreria().getColonne(); i++) {
            int counter = 0;
            if (tessere.size() != 3)
                tessere = new ArrayList<>();

            for (int j = 0; j < player.getLibreria().getRighe(); j++) {
                String tessera = ritornoTipo(j, i, player);
                if (tessera != null) {
                    counter++;
                    if (!tessere.contains(tessera))
                        tessere.add(tessera);
                }
            }
            if (tessere.size() == 3 && counter == player.getLibreria().getRighe())
                return tessere;
        }
        return null;
    }
}
