package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;

public class CommonGoal2 extends CommonGoal {

    public CommonGoal2(String path, ArrayList<Card> token) {
        super(path, token);
    }

/*    public boolean controllo(Player player) {
        int cont = 0;
        for (int i = 0; i < player.libreria.get(0).size(); i++) {
            boolean help = true;
            for (int j = 0; j < player.libreria.size(); j++) {

                String tipo = ritornoTipo(j, i, player);

                for (int y = 0; y < player.libreria.size() - 1; y++) {
                    if (tipo.equals(ritornoTipo(y, i + 1, player))) {
                        help = false;
                    }
                }
            }
            if (help) {
                cont++;
            }
            if (cont >= 2) {
                return true;
            }
        }
        return false;
    }

 */

    public boolean controllo(Player player) {
        int contatore = 0;
        for (int j = 0; j < player.libreria.size() - 1; j++) {
            //for (int i = 0; i < player.libreria.size(); i++) {
            int i =0;
                System.out.println("colonna:" + j + "--" + "riga" + i);
                if (!ritornoTipo(i, j, player).equals(ritornoTipo(i + 1, j, player)) &&
                        !ritornoTipo(i, j, player).equals(ritornoTipo(i + 2, j, player)) &&
                        !ritornoTipo(i, j, player).equals(ritornoTipo(i + 3, j, player)) &&
                        !ritornoTipo(i, j, player).equals(ritornoTipo(i + 4, j, player)) &&
                        !ritornoTipo(i, j, player).equals(ritornoTipo(i + 5, j, player)) &&
                        !ritornoTipo(i + 1, j, player).equals(ritornoTipo(i + 2, j, player)) &&
                        !ritornoTipo(i + 1, j, player).equals(ritornoTipo(i + 3, j, player)) &&
                        !ritornoTipo(i + 1, j, player).equals(ritornoTipo(i + 4, j, player)) &&
                        !ritornoTipo(i + 1, j, player).equals(ritornoTipo(i + 5, j, player)) &&
                        !ritornoTipo(i + 2, j, player).equals(ritornoTipo(i + 3, j, player)) &&
                        !ritornoTipo(i + 2, j, player).equals(ritornoTipo(i + 4, j, player)) &&
                        !ritornoTipo(i + 2, j, player).equals(ritornoTipo(i + 5, j, player)) &&
                        !ritornoTipo(i + 3, j, player).equals(ritornoTipo(i + 4, j, player)) &&
                        !ritornoTipo(i + 3, j, player).equals(ritornoTipo(i + 5, j, player)) &&
                        !ritornoTipo(i + 4, j, player).equals(ritornoTipo(i + 5, j, player))) {
                    contatore++;
                    System.out.println("Controllo colonna:" + j + "--" + "riga" + i);
                }


           // }

        }

        if (contatore >= 2) {
            return true;
        } else {
            return false;

        }
    }
}
