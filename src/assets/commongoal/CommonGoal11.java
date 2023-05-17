package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal11 extends ControlloCommonGoal{
    public boolean controlloCommonGoal11(Libreria libreria) {
        /*  ottimizzato con nuova funzione
        boolean foundMainDiagonalValue = true;
        boolean foundSecondaryDiagonalValue = true;
        for (int i = 1; i < 5; i++) {

            if (libreria.celle.get(i).get(i).tile.type != libreria.celle.get(0).get(0).tile.type) {
                foundMainDiagonalValue = false;
            }
            if (libreria.celle.get(i).get(5-i).tile.type != libreria.celle.get(0).get(5).tile.type) {
                foundSecondaryDiagonalValue = false;
            }
        }
        return foundMainDiagonalValue || foundSecondaryDiagonalValue;*/

        for (int i = 0; i < libreria.mappa.size(); i++) {
            int contDiagoPrinc = 0;
            int contDiagoSec = 0;
            if ((libreria.mappa.size() - i) >= libreria.mappa.get(0).size()) {
                for (int j = 0; j < libreria.mappa.get(i).size(); j++) {
                    if (ritornoTipo(j + i, j, libreria).equals(ritornoTipo(0, 0, libreria))) {
                        contDiagoPrinc++;
                        if (contDiagoPrinc >= libreria.mappa.get(0).size()) {
                            return true;
                        }
                    }

                    if (ritornoTipo(0, libreria.mappa.get(0).size(), libreria).equals(
                            ritornoTipo(j + i, libreria.mappa.get(0).size() - j - 1, libreria))) {
                        contDiagoSec++;
                        if (contDiagoSec >= libreria.mappa.get(0).size()) {
                            return true;
                        }
                    }


                }
            }


        }
        return false;
    }
}
