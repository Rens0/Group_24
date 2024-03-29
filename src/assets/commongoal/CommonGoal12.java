package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal12 extends CommonGoal {

    public CommonGoal12(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int casellePrimaColonna = ContaCaselleLibere(player, 0);
        for (int j = 1; j < player.getLibreria().getRighe(); j++) {
            if (casellePrimaColonna != (ContaCaselleLibere(player, j) - j)) {
                break;
            }
            if (j == 4) {
                return true;
            }
        }
        for (int j = 1; j < player.getLibreria().getRighe(); j++) {
            if (casellePrimaColonna != (ContaCaselleLibere(player, j) + j)) {
                break;
            }
            if (j == 4) {
                return true;
            }
        }
        return false;
    }
}
