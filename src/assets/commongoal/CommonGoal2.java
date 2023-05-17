package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal2 extends CommonGoal {
    public CommonGoal2(String id, String path, ArrayList<Card> token){
        this.id= id;
        this.path=path;
        this.token=token;
    }
    public boolean controllo(Player player) {
        int cont = 0;
        for (int i = 0; i < player.libreria.get(0).size(); i++) {
            boolean help = true;
            for (int j = 0; j < player.libreria.size(); j++) {

                String tipo = ritornoTipo(j, i, player);

                for (int y = 0; y < player.libreria.size() - 1; y++) {
                    if (tipo.equals(ritornoTipo(y, i + 1, player))) {
                        help = false;
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
