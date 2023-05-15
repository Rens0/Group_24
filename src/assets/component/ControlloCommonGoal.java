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

        if (ritornoTipo(0, 0, libreria).equals(ritornoTipo(0, libreria.mappa.get(0).size() - 1, libreria)) &&
                ritornoTipo(0, 0, libreria).equals(ritornoTipo(libreria.mappa.size() - 1, libreria.mappa.get(0).size() - 1, libreria)) &&
                ritornoTipo(0, 0, libreria).equals(ritornoTipo(libreria.mappa.size() - 1, 0, libreria))
        ) {
            return true;
        }

        return false;
    }



    public boolean controlloCommonGoal4(Libreria libreria) {
        int contatore=0;

        for (int i = 0; i < libreria.mappa.size()-1; i++) {
            for (int j = 0; j < libreria.mappa.get(i).size()-1; j++) {
                if(ritornoTipo(i,j,libreria).equals(ritornoTipo(i+1,j,libreria))||
                        ritornoTipo(i,j+1,libreria).equals(ritornoTipo(i,j,libreria))||
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

    public boolean controlloCommonGoal5(Libreria libreria) {
        int contatore=0;
        for (int j=0; j< libreria.getColonne(); j++){
            ArrayList <String> cardType=new ArrayList<>();
            boolean isFull=true;
            if(contatore+(libreria.getColonne()-j)<3)
                return false;
            for (int i=0; i< libreria.getRighe(); i++){

                if(libreria.getCella(i, j).isEmpty()) {
                    isFull=false;
                    break;//passa alla prossima colonna
                }
                String type=ritornoTipo(i,j, libreria);

                if(!cardType.contains(type)){
                    cardType.add(type);
                }
                if(cardType.size()>3){      //numero dei tipi nell'arrayList
                    break; //passa alla prox colonna
                }

            }
            if(isFull && cardType.size()<=3){
                contatore++;
            }
            if(contatore==3) {
                return true;
            }
        }
        return false;
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

    public boolean controlloCommonGoal8(Libreria libreria) {
        /*int contatore = 0;
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

        return false;*/
        int contatore=0;
        for (int i=0; i< libreria.getRighe(); i++){
            ArrayList <String> cardType=new ArrayList<>();
            boolean isFull=true;
            if(contatore+(libreria.getRighe()-i)<4)
                return false;
            for (int j=0; j< libreria.getColonne(); j++){

                if(libreria.getCella(i, j).isEmpty()) {
                    isFull=false;
                    break;//passa alla prossima riga
                }
                String type=ritornoTipo(i,j, libreria);

                if(!cardType.contains(type)){
                    cardType.add(type);
                }
                if(cardType.size()>3){      //numero dei tipi nell'arrayList
                    break; //passa alla prox riga
                }

            }
            if(isFull && cardType.size()<=3){
                contatore++;
            }
            if(contatore==4) {
                return true;
            }
        }
        return false;
    }

    public boolean controlloCommonGoal9(Libreria libreria) {
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

    public boolean controlloCommonGoal10(Libreria libreria) {
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

    public boolean controlloCommonGoal11(Libreria libreria) {
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