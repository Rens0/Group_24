package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal2 extends ControlloCommonGoal{
    public boolean controlloCommonGoal2(Libreria libreria) {
        int cont = 0;
        for (int i = 0; i < libreria.mappa.get(0).size(); i++) {
            boolean help = true;
            for (int j = 0; j < libreria.mappa.size(); j++) {

                String tipo = ritornoTipo(j, i, libreria);

                for (int y = 0; y < libreria.mappa.size() - 1; y++) {
                    if (tipo.equals(ritornoTipo(y, i + 1, libreria))) {
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
