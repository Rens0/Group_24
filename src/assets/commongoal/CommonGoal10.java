package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal10 extends CommonGoal {

    public CommonGoal10(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        for (int i = 0; i < player.getLibreria().getRighe() - 2; i++) {
            for (int j = 0; j < player.getLibreria().getColonne() - 2; j++) {
                String usx = ritornoTipo(i, j, player);
                String udx = ritornoTipo(i, j + 2, player);
                String dsx = ritornoTipo(i + 2, j, player);
                String ddx = ritornoTipo(i + 2, j + 2, player);
                String mid = ritornoTipo(i + 1, j + 1, player);
                if (usx != null && udx != null && dsx != null && ddx != null && mid != null) {
                    return usx.equals(udx) && usx.equals(dsx) && usx.equals(ddx) && usx.equals(mid);
                }
            }
        }
        return false;
       /*
       int righe = player.getRighe();
        int colonne = player.getColonne();
        for (int i = 1; i < righe - 1; i++) {
            for (int j = 1; j < colonne - 1; j++) {
                Cella centro = player.getCella(i, j);
                Cella altosx = player.getCella(i - 1, j - 1);
                Cella bassosx = player.getCella(i + 1, j - 1);
                Cella altodx = player.getCella(i - 1, j + 1);
                Cella bassodx = player.getCella(i + 1, j + 1);
                if (!centro.isEmpty() && !altosx.isEmpty() && !altodx.isEmpty() && !bassodx.isEmpty()) {
                    String tipo = centro.getTessera().type;

                    if (tipo.equals(altosx.getTessera().type)
                            && tipo.equals(altodx.getTessera().type)
                            && tipo.equals(bassodx.getTessera().type)
                            && tipo.equals(bassosx.getTessera().type)) {
                        return true;
                    }
                }
            }
        }
        return false;
        */
    }
}
