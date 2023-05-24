package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal4 extends CommonGoal {

    public CommonGoal4(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        //---Controllo colonna
        for (int i = 0; i < player.libreria.size(); i++) {
            for (int j = 0; j < player.libreria.get(0).size() - 1; j++) {
                String t = ritornoTipo(i, j, player);
                if (t != null) {
                    String t_next = ritornoTipo(i, j + 1, player);
                    if (t_next != null) {
                        if (t.equals(t_next))
                            counter++;
                    }
                }
            }
        }
        //---Controllo riga
        for (int i = 0; i < player.libreria.get(0).size(); i++) {
            for (int j = 0; j < player.libreria.size() - 1; j++) {
                String t = ritornoTipo(j, i, player);
                if (t != null) {
                    String t_next = ritornoTipo(j + 1, i, player);
                    if (t_next != null) {
                        if (t.equals(t_next))
                            counter++;
                    }
                }
            }
        }


        return (counter >= 6);
    }
}
