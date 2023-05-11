package assets.component;

import assets.card.Card;
import assets.card.CardContainer;

import java.util.ArrayList;

public class ControlloCommonGoal {
    public boolean controlloCommonGoal1(Libreria libreria) {
        return true;
    }

    public boolean controlloCommonGoal2(Libreria libreria) {
        return true;
    }

    public boolean controlloCommonGoal3(Libreria libreria) {

        if (ritornoTipo(0, 0, libreria) == ritornoTipo(0, libreria.mappa.get(0).size() - 1, libreria) &&
                ritornoTipo(0, 0, libreria) == ritornoTipo(libreria.mappa.size() - 1, libreria.mappa.get(0).size() - 1, libreria) &&
                ritornoTipo(0, 0, libreria) == ritornoTipo(libreria.mappa.size() - 1, 0, libreria)
        ) {
            return true;
        }

        return false;
    }



    public boolean controlloCommonGoal4(Libreria libreria) {
        return true;
    }

    public boolean controlloCommonGoal5(Libreria libreria) {
        return true;
    }

    public boolean controlloCommonGoal6(Libreria libreria, CardContainer cardContainer) {
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

    public boolean controlloCommonGoal7(Libreria libreria) {
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
                    if (ritornoTipo(j + i, j, libreria) == ritornoTipo(0, 0, libreria)) {
                        contDiagoPrinc++;
                        if (contDiagoPrinc >= libreria.mappa.get(0).size()) {
                            return true;
                        }
                    }

                    if (ritornoTipo(0, libreria.mappa.get(0).size(), libreria) ==
                            ritornoTipo(j + i, libreria.mappa.get(0).size() - j - 1, libreria)) {
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

    public boolean controlloCommonGoal8(Libreria libreria) {
        int contatore = 0;
        for(int i = 0; i < libreria.mappa.get(0).size(); i++){
            ArrayList<Card> tile = new ArrayList<>();

            for(int j = 0; j <libreria.mappa.size(); j++){
                for(int c = 0; c<tile.size(); c++){
                    Card card = tile.get(c);
                    boolean aggiungi = true;
                    for(int k = 0; k<tile.size(); k++){
                        if (k!=c){
                            if(card.type == tile.get(k).type)
                                aggiungi = false;
                        }
                    }
                    if(aggiungi)
                        tile.add(card);
                }
                if(tile.size()<=3)
                    contatore++;

            }

        }
        if(contatore>=3)
            return true;

        return false;
    }

    public boolean controlloCommonGoal9(Libreria libreria) {
        int cont = 0;
        for (int i = 0; i < libreria.mappa.size(); i++) {
            boolean help = true;
            for (int j = 0; j < libreria.mappa.get(i).size(); j++) {

                String tipo = ritornoTipo(i, j, libreria);

                for (int y = 0; y < libreria.mappa.get(i).size() - 1; y++) {
                    if (tipo == ritornoTipo(i, y + 1, libreria)) {
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

    public boolean controlloCommonGoal10(Libreria libreria) {
        int cont = 0;
        for (int i = 0; i < libreria.mappa.get(0).size(); i++) {
            boolean help = true;
            for (int j = 0; j < libreria.mappa.size(); j++) {

                String tipo = ritornoTipo(j, i, libreria);

                for (int y = 0; y < libreria.mappa.size() - 1; y++) {
                    if (tipo == ritornoTipo(y, i + 1, libreria)) {
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

    public boolean controlloCommonGoal11(Libreria libreria) {
        return true;
    }

    public boolean controlloCommonGoal12(Libreria libreria) {
        int casellePrimaColonna=ContaCaselleLibere(libreria, 0);
        for(int j = 1; j<libreria.mappa.size(); j++){
            if(casellePrimaColonna!=(ContaCaselleLibere(libreria, j)-j)){
                break;
            }
            if(j==4){
                return true;
            }
        }
        for(int j = 1; j<libreria.mappa.size(); j++){
            if(casellePrimaColonna!=(ContaCaselleLibere(libreria, j)+j)){
                break;
            }
            if(j==4){
                return true;
            }
        }
        return false;
    }
    public int ContaCaselleLibere(Libreria libreria, int colonna){
        int conta=0;
        for (int i = 0; i<libreria.mappa.size(); i++){

            if(libreria.mappa.get(i).get(colonna).getTessera()==null){
                conta++;
            }
            if(libreria.mappa.get(i).get(colonna).getTessera()!=null){
                break;
            }
        }
        return conta;
    }
    public String ritornoTipo(int riga, int colonna, Libreria libreria) {
        String tipo;
        tipo = libreria.mappa.get(riga).get(colonna).tile.type;
        return tipo;
    }
}