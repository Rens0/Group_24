package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal11 extends CommonGoal {
    public CommonGoal11(String id, String path, ArrayList<Card> token){
        this.id= id;
        this.path=path;
        this.token=token;
    }
    public boolean controllo(Player player) {
        /*  ottimizzato con nuova funzione
        boolean foundMainDiagonalValue = true;
        boolean foundSecondaryDiagonalValue = true;
        for (int i = 1; i < 5; i++) {

            if (libreria.celle.get(i).get(i).tile.type != libreria.celle.get(0).get(0).tile.type) {
                foundMainDiagonalValue = false;
            }
            if (libreria.celle.get(i).get(5-i).tile.type != libreria.celle.get(0).get(5).tile.type) {
                foundSecondaryDiagonalValue = false;
            }
        }
        return foundMainDiagonalValue || foundSecondaryDiagonalValue;*/

        for (int i = 0; i < player.libreria.size(); i++) {
            int contDiagoPrinc = 0;
            int contDiagoSec = 0;
            if ((player.libreria.size() - i) >= player.libreria.get(0).size()) {
                for (int j = 0; j < player.libreria.get(i).size(); j++) {
                    if (ritornoTipo(j + i, j, player).equals(ritornoTipo(0, 0, player))) {
                        contDiagoPrinc++;
                        if (contDiagoPrinc >= player.libreria.get(0).size()) {
                            return true;
                        }
                    }

                    if (ritornoTipo(0, player.libreria.get(0).size(), player).equals(
                            ritornoTipo(j + i, player.libreria.get(0).size() - j - 1, player))) {
                        contDiagoSec++;
                        if (contDiagoSec >= player.libreria.get(0).size()) {
                            return true;
                        }
                    }


                }
            }


        }
        return false;
    }
}
