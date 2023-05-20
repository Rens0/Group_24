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
        List<String> Colonna = new ArrayList();
        Set<String> noduplicati = new LinkedHashSet<>();
        for (int j = 0; j < player.libreria.size() - 1; j++) {
            for (int i = 0; i < player.libreria.size(); i++) {
                Colonna.add(ritornoTipo(i, j, player));
                noduplicati.addAll(Colonna);
            }
            if (Colonna.size() == noduplicati.size()) {
                contatore++;
            }

            Colonna.clear();
            noduplicati.clear();
        }

        if (contatore >= 2) {
            return true;
        } else {
            return false;

        }
    }

}
