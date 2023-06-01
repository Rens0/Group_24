package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal11 extends CommonGoal {

    public CommonGoal11(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        boolean diagop = false;
        Boolean diagos = false;
        for (int i = 0; i < player.getLibreria().getRighe(); i++) {
            diagop = diagop(player, i);
            diagos = diagos(player, i);
            if (diagop || diagos)
                return true;
        }
        return false;
    }

    private boolean diagos(Player player, int index) {
        String tipo = ritornoTipo(index, 0, player);
        for (int i = 0; i < player.getLibreria().getRighe(); i++) {
            if (tipo != null) {
                for (int j = 0; j < player.getLibreria().getColonne(); j++) {
                    if ((index - i) == j) {
                        String next = ritornoTipo(i, j, player);
                        if (next != null) {
                            if (!next.equals(tipo))
                                return false;

                        } else return false;

                    }

                }

            } else return false;

        }
        return true;

    }

    private boolean diagop(Player player, int index) {

        String tipo = ritornoTipo(index, 0, player);
        for (int i = index; i < player.getLibreria().getRighe(); i++) {

            if (tipo != null) {
                for (int j = 0; j < player.getLibreria().getColonne(); j++) {
                    if (i - index == j) {
                        String next = ritornoTipo(i, j, player);
                        if (next != null) {
                            if (!next.equals(tipo))
                                return false;
                        } else return false;

                    }

                }


            } else return false;
        }
        return true;
    }
}
