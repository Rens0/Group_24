package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal4 extends CommonGoal {

    public CommonGoal4(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int contatore = 0;

        for (int i = 0; i < player.libreria.get(0).size(); i++) {

            for (int j = 0; j < player.libreria.size() - 1; j++) {
                if(ritornoTipo(j,i,player)!=null&&ritornoTipo(j+1,i,player)!=null) {
                    if (ritornoTipo(j, i, player).equals(ritornoTipo(j + 1, i, player))) {
                        contatore++;
                    }
                }
            }
        }
        if(contatore>=6) {
             return true;
         }else{
            return false;
        }
}}
