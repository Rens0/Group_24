package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal3 extends CommonGoal {

    public CommonGoal3(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int contC = 0;
        for (int i = 0; i < player.libreria.size(); i++) {
            int cont = 0;
            for (int j = 0; j < player.libreria.get(i).size(); j++) {
                if(ritornoTipo(i, j, player)!=null&&ritornoTipo(i, j, player)!=null) {
                    if (ritornoTipo(i, j, player).equals(ritornoTipo(i, j + 1, player))) {
                        cont++;
                    }
                }
                if (cont == 4) {
                    contC++;
                    break;
                }
            }
        }
        if (contC >= 4) {
            return true;
        } else {
            return false;
        }

    }
}
