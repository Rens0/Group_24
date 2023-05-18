package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal1 extends CommonGoal {

    public CommonGoal1(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int contatore=0;

        for (int i = 0; i < player.libreria.size()-1; i++) {
            for (int j = 0; j < player.libreria.get(i).size()-1; j++) {

                if(ritornoTipo(i,j,player).equals(ritornoTipo(i+1,j,player))&&
                        ritornoTipo(i,j+1,player).equals(ritornoTipo(i,j,player))&&
                        ritornoTipo(i,j,player).equals(ritornoTipo(i+1,j+1,player))){

                    contatore++;
                }
            }
        }
        if(contatore>=2)
        {
            return true;
        }
        else{
            return false;
        }
    }










}
