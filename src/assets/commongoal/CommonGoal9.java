package assets.commongoal;

import assets.card.Card;
import assets.card.CardContainer;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal9 extends CommonGoal {
    private CardContainer cardContainer;

    public CommonGoal9(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        ArrayList<String> tipi = cercoTipi(player);
        for (int k = 0; k < tipi.size(); k++) {
            int contatore = 0;
            for (int i = 0; i < player.getLibreria().getRighe(); i++) {
                for (int j = 0; j < player.getLibreria().getColonne(); j++) {
                    String tipo = ritornoTipo(i, j, player);
                    if (tipo != null) {
                        if (tipo.equals(tipi.get(k)))
                            contatore++;
                    }
                }
            }
            if (contatore >= 8)
                return true;
        }

        return false;
    }

    private ArrayList<String> cercoTipi(Player player) {
        ArrayList<String> tipi = new ArrayList<>();
        for (int i = 0; i < player.getLibreria().getRighe(); i++) {
            for (int j = 0; j < player.getLibreria().getColonne(); j++) {
                String tipo = ritornoTipo(i, j, player);
                if (tipo != null) {
                    if (!tipi.contains(tipo))
                        tipi.add(tipo);
                }
            }

        }
        return tipi;

    }



}
