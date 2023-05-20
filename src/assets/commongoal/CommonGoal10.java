package assets.commongoal;

import assets.card.Card;
import assets.component.Cella;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal10 extends CommonGoal {

    public CommonGoal10(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
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

    }
}
