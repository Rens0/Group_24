package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal8 extends CommonGoal {

    public CommonGoal8(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        if(ritornoTipo(0, 0, player)!=null&&ritornoTipo(0, player.libreria.get(0).size() - 1, player)!=null&&ritornoTipo(player.libreria.size() - 1, player.libreria.get(0).size() - 1, player)!=null&&ritornoTipo(player.libreria.size() - 1, 0, player)!=null) {
            return ritornoTipo(0, 0, player).equals(ritornoTipo(0, player.libreria.get(0).size() - 1, player)) &&
                    ritornoTipo(0, 0, player).equals(ritornoTipo(player.libreria.size() - 1, player.libreria.get(0).size() - 1, player)) &&
                    ritornoTipo(0, 0, player).equals(ritornoTipo(player.libreria.size() - 1, 0, player));
        }
        return false;

    }
}
