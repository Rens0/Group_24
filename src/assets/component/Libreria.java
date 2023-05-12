package assets.component;

import assets.card.Card;

import java.util.ArrayList;
import java.util.List;


public class Libreria {
    private int righe;
    private int colonne;
    public List<List<Cella>> mappa;
    public Libreria(){
        this(6,5);
    }

    public Libreria(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;

        mappa = new ArrayList<>();
        ArrayList<Cella> rigac;
        for (int i = 0; i < righe; i++) {
            rigac = new ArrayList<>();

            for (int j = 0; j < colonne; j++) {
                rigac.add(new Cella());
            }
            mappa.add(rigac);
        }

    }

    public ArrayList<Card> inserisciTessere(ArrayList<Card> card, ArrayList<Integer> ordine,  int COLONNASELEZIONATA) {
        int contaCelle = 0;

        for (int y = 0; y < righe; y++) {

            if (mappa.get(y).get(COLONNASELEZIONATA).getTessera().type == null) {
                contaCelle++;
            }
        }

        if (contaCelle - card.size() >= 0) {
            for (int i = contaCelle - 1; i > 0; i--) {

                if (mappa.get(i).get(COLONNASELEZIONATA).getTessera().type == null) {

                    if (ordine.size() > 0) {

                        mappa.get(i).get(COLONNASELEZIONATA).setCella(card.get(ordine.get(0)));
                        ordine.remove(0);


                    }

                }
            }
        } else throw new RuntimeException("Le tessere non ci stanno");
        return null;
    }


    public boolean libreriaPiena() {
        int contacella = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (mappa.get(i).get(j).getTessera() != null) {
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
            for (int y = 0; y < colonne; y++) {
                if (mappa.get(i).get(y).getTessera() == null) {
                    System.out.print(".......\t");
                } else {
                    System.out.print(mappa.get(i).get(y).getTessera().id+"\t");
                }
            }
            System.out.println();
        }
    }


}
