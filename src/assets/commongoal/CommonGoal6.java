package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal6 extends ControlloCommonGoal{
    public boolean controlloCommonGoal6(Libreria libreria) {
        int cont = 0;
        for (int i = 0; i < libreria.mappa.size(); i++) {
            boolean help = true;
            for (int j = 0; j < libreria.mappa.get(i).size(); j++) {

                String tipo = ritornoTipo(i, j, libreria);

                for (int y = 0; y < libreria.mappa.get(i).size() - 1; y++) {
                    if (tipo.equals(ritornoTipo(i, y + 1, libreria))) {
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
}
