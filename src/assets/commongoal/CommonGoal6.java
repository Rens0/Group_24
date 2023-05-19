package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal6 extends CommonGoal {

    public CommonGoal6(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {

        int cont = 0;
        for (int i = 0; i < player.libreria.size(); i++) {
            boolean help = true;
            for (int j = 0; j < player.libreria.get(i).size(); j++) {

                String tipo = ritornoTipo(i, j, player);

                for (int y = 0; y < player.libreria.get(i).size() - 1; y++) {
                    if (tipo != null) {
                        if (tipo.equals(ritornoTipo(i, y + 1, player))) {
                            help = false;
                        }
                    }
                }
            }
            if (help) {
                cont++;
            }
            if (cont >= 2) {
                return true;
            }
        }
        return false;
    }
}
