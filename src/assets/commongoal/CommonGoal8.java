package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal8 extends ControlloCommonGoal{
    public boolean controlloCommonGoal8(Libreria libreria) {

        if (ritornoTipo(0, 0, libreria).equals(ritornoTipo(0, libreria.mappa.get(0).size() - 1, libreria)) &&
                ritornoTipo(0, 0, libreria).equals(ritornoTipo(libreria.mappa.size() - 1, libreria.mappa.get(0).size() - 1, libreria)) &&
                ritornoTipo(0, 0, libreria).equals(ritornoTipo(libreria.mappa.size() - 1, 0, libreria))
        ) {
            return true;
        }

        return false;
    }
}
