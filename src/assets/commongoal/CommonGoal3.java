package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal3 extends CommonGoal {

    public CommonGoal3(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int counter = 0;
        //--- Controllo per colonna
        counter += controlloRriga(player.getLibreria().getRighe(), player.getLibreria().getColonne(), player.getLibreria().getColonne(), player, 0);
        //--- Controllo per riga
        counter += controlloColonna(player.getLibreria().getColonne(), player.getLibreria().getRighe(), player.getLibreria().getRighe(), player, 1);
        if (counter >= 4)
            return true;
        return false;

    }

    private int controlloRriga(int x, int y, int z, Player player, int scelta) {
        int counter = 0;
        //--- Controllo per colonna
        for (int i = 0; i < x; i++) {
            int controllo = 0;
            for (int j = 0; j < y; j++) {
                String tipo = ritornoTipo(i, j, player);
                if (tipo != null) {
                    for (int k = 0; k < z; k++) {
                        String tipoN = ritornoTipo(i, k, player);
                        if (tipoN != null) {
                            if (j != k && tipo.equals(tipoN)) {
                                controllo++;
                            }

                        }
                    }
                }
            }
            if (controllo >= 4)
                counter++;
        }
        return counter;
    }

    private int controlloColonna(int x, int y, int z, Player player, int scelta) {
        int counter = 0;
        //--- Controllo per colonna
        for (int i = 0; i < x; i++) {
            int controllo = 0;
            for (int j = 0; j < y; j++) {
                String tipo = ritornoTipo(j, i, player);
                if (tipo != null) {
                    for (int k = 0; k < z; k++) {
                        String tipoN = ritornoTipo(k, i, player);
                        if (tipoN != null) {
                            if (j != k && tipo.equals(tipoN)) {
                                controllo++;
                            }

                        }
                    }
                }
            }
            if (controllo >= 4)
                counter++;
        }
        return counter;
    }
}
