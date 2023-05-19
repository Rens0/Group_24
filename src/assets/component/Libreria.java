package assets.component;

import assets.card.Card;

import java.util.ArrayList;
import java.util.List;


abstract class Libreria {


    private int righe;
    private int colonne;
    public List<List<Cella>> libreria;

    public Libreria() {
        this(6, 5);
    }

    public Libreria(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        libreria= new ArrayList<>();//--Da cancellare
/*
        libreria = new ArrayList<>();
        ArrayList<Cella> rigac;
        for (int i = 0; i < righe; i++) {
            rigac = new ArrayList<>();

            for (int j = 0; j < colonne; j++) {
                rigac.add(new Cella());
            }
            libreria.add(rigac);
        }
*/
    }

    public int getColonne() {
        return colonne;
    }

    public int getRighe() {
        return righe;
    }

    public Cella getCella(int riga, int colonna) {
        return libreria.get(riga).get(colonna);
    }


    public int inserisciTessere(ArrayList<Card> card, ArrayList<Integer> ordine, int COLONNASELEZIONATA) throws Exception {
        int contaCelle = 0;
        //--- Conto celle disponibili
        for (int j = 0; j < righe; j++) {
            if (libreria.get(j).get(COLONNASELEZIONATA).getTessera().type == null) {
                contaCelle++;
            }
        }


        if (contaCelle - card.size() >= 0) {
            for (int i = contaCelle - 1; i >= 0; i--) {

                if (libreria.get(i).get(COLONNASELEZIONATA).getTessera().type == null) {

                    if (ordine.size() > 0) {
                        libreria.get(i).get(COLONNASELEZIONATA).setCella(card.get(ordine.get(0)));
                        ordine.remove(0);
                    }

                }
            }
        }
        return contaCelle;
    }


    public boolean libreriaPiena() {
        int contacella = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (libreria.get(i).get(j).getTessera().type != null) {
                    contacella++;
                }
            }
        }
        if (contacella == (righe * colonne)) {
            return true;
        } else {
            return false;
        }
    }
    public void print() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (libreria.get(i).get(j).getTessera().type == null) {
                    System.out.print(".......\t");
                } else {
                    System.out.print(libreria.get(i).get(j).getTessera().id + "\t");
                }
            }
            System.out.println();
        }
    }


}
