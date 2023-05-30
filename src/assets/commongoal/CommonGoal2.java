package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;

public class CommonGoal2 extends CommonGoal {

    public CommonGoal2(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        int contatore = 0;
        int righe = 0;
        List<String> Colonna = new ArrayList();
        Set<String> noduplicati = new LinkedHashSet<>();
        for (int j = 0; j < player.getLibreria().getColonne(); j++) {
            for (int i = 0; i < player.getLibreria().getRighe(); i++) {
                if (ritornoTipo(i, j, player) != null) {
                    Colonna.add(ritornoTipo(i, j, player));
                    noduplicati.addAll(Colonna);
                    righe++;
                } else {
                    righe--;
                }
            }
            if (Colonna.size() == noduplicati.size() && righe == 6) {
                contatore++;

            }
            Colonna.clear();
            noduplicati.clear();
            righe = 0;
        }

        return contatore >= 2;


      /*  int counter = 0;
        for (int j = 0; j < player.getLibreria().getColonne(); j++) {
            Boolean controllo = true;
            for (int i = 0; i < player.getLibreria().getRighe(); i++) {
                String tessera = ritornoTipo(i, j, player);
                if (tessera != null) {
                    for (int k = 0; k < player.getLibreria().getRighe(); k++) {
                        String tesseran = ritornoTipo(k, j, player);
                        if (tesseran != null) {
                            if (k != i && tessera.equals(tesseran)) {
                                controllo = false;
                            }
                        } else {
                            controllo = false;
                            break;
                        }
                    }

                } else
                    controllo = false;


            }
            if (controllo)
                counter++;
        }
        if (counter >= 2)
            return true;
        return false;*/
    }

}
