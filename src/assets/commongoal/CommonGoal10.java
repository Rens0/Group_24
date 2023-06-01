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
     
    }
}
