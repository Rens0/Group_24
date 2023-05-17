package assets.commongoal;

import assets.card.CardContainer;
import assets.component.Libreria;

public class CommonGoal9 extends ControlloCommonGoal{
    public boolean controlloCommonGoal9(Libreria libreria, CardContainer cardContainer) {
     /*   int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;
        int cont6 = 0;

        for (int i = 0; i < RIGHE; i++)
        {
            for (int j = 0; j < COLONNE; j++)
            {
                if (cont1 == 8 || cont2 == 8 || cont3 == 8 || cont4 == 8 || cont5 == 8 || cont6 == 8)
                {
                    return true;
                }
                switch (libreria.celle.get(i).get(j).tile.type)
                {
                    case "cornice": {
                        cont1++;
                        break;
                    }
                    case "gatto": {
                        cont2++;
                        break;
                    }
                    case "gioco": {
                        cont3++;
                        break;
                    }
                    case "libro": {
                        cont4++;
                        break;

                    }
                    case "pianta": {
                        cont5++;
                        break;
                    }
                    case "trofeo": {
                        cont6++;
                        break;
                    }
                }
            }

        }*/
        //versione ottimizzata

        for (int c = 0; c < cardContainer.list.size(); c++) {
            int contacarte = 0;
            for (int i = 0; i < libreria.mappa.size(); i++) {
                for (int j = 0; j < libreria.mappa.get(i).size(); j++) {
                    if (ritornoTipo(i, j, libreria) == cardContainer.list.get(c).type) {
                        contacarte++;
                        if (contacarte >= 8) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
