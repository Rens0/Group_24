package assets.commongoal;

import assets.component.Cella;
import assets.component.Libreria;

public class CommonGoal10 extends ControlloCommonGoal{
    public boolean controlloCommonGoal10(Libreria libreria) {
        int righe=libreria.getRighe();
        int colonne=libreria.getColonne();
        for (int i=1; i<righe-1; i++){
            for (int j=1; j<colonne-1; j++){
                Cella centro=libreria.getCella(i, j);
                Cella altosx= libreria.getCella(i-1,j-1);
                Cella bassosx=libreria.getCella(i+1, j-1);
                Cella altodx=libreria.getCella(i-1,j+1);
                Cella bassodx=libreria.getCella(i+1, j+1);
                if(!centro.isEmpty() && !altosx.isEmpty() && !altodx.isEmpty() && !bassodx.isEmpty()){
                    String tipo=centro.getTessera().type;

                    if(tipo.equals(altosx.getTessera().type)
                            && tipo.equals(altodx.getTessera().type)
                            && tipo.equals(bassodx.getTessera().type)
                            && tipo.equals(bassosx.getTessera().type)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
