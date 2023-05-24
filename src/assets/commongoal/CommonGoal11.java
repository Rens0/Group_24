package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal11 extends CommonGoal {

    public CommonGoal11(String path, ArrayList<Card> token) {
        super(path, token);
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
        boolean diagop = false;
        Boolean diagos;
        for (int i = 0; i < player.libreria.size(); i++) {
            diagop = diagop(player, i);
            //diagos = diagos(player, i);
        }
        return diagop;
    }

    private boolean diagos(Player player, int index) {
        String tipo = ritornoTipo(index, 0, player);
        for (int i = index; i < player.libreria.size(); i++) {
            if (tipo != null) {
                for (int j = 0; j < player.libreria.get(0).size(); j++) {
                    if ((player.libreria.get(0).size()-index-1) == j) {
                        String next = ritornoTipo(i, j, player);
                        System.out.println(next);
                        if (next != null)
                            if (!next.equals(tipo))
                                return false;


                    }

                }


            }
        }
        return true;

    }

    private boolean diagop(Player player, int index) {

        String tipo = ritornoTipo(index, 0, player);
        for (int i = index; i < player.libreria.size(); i++) {

            if (tipo != null) {
                for (int j = 0; j < player.libreria.get(0).size(); j++) {
                    if (i - index == j) {
                        String next = ritornoTipo(i, j, player);
                        if (next != null)
                            if (!next.equals(tipo))
                                return false;


                    }

                }


            }
        }
        return true;
    }
}
