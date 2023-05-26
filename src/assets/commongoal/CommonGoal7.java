package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal7 extends CommonGoal {

    public CommonGoal7(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        ArrayList<String> base = getArray(player, 0);
        if (base != null) {
            for (int i = 0; i < player.getLibreria().getRighe(); i++) {
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


        return (counter >= 4);
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
