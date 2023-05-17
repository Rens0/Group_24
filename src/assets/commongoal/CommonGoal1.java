package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal1 extends ControlloCommonGoal{

    public boolean controlloCommonGoal1(Libreria libreria) {
        int contatore=0;

        for (int i = 0; i < libreria.mappa.size()-1; i++) {
            for (int j = 0; j < libreria.mappa.get(i).size()-1; j++) {
                if(ritornoTipo(i,j,libreria).equals(ritornoTipo(i+1,j,libreria))&&
                        ritornoTipo(i,j+1,libreria).equals(ritornoTipo(i,j,libreria))&&
                        ritornoTipo(i,j,libreria).equals(ritornoTipo(i+1,j+1,libreria))){

                    contatore++;
                }
            }
        }
        if(contatore>=2)
        {
            return true;
        }
        else{
            return false;
        }
    }










}
