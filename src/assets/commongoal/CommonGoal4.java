package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal4 extends ControlloCommonGoal {
    public boolean controlloCommonGoal4(Libreria libreria) {
        int contatore = 0;

        for (int i = 0; i < libreria.mappa.get(0).size(); i++) {

            for (int j = 0; j < libreria.mappa.size() - 1; j++) {
                if(ritornoTipo(j,i,libreria).equals(ritornoTipo(j+1,i,libreria)))
                {
                    contatore++;
                }
            }
        }
        if(contatore>=6) {
             return true;
         }else{
            return false;
        }
}}
