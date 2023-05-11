package assets.component;

import assets.card.Card;

import java.util.ArrayList;
import java.util.List;


public class Libreria {
    private int righe;
    private int colonne;
    public List<List<Cella>> celle;
    public Libreria(){
        this(6,5);
    }

    public Libreria(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;

        celle = new ArrayList<>();
        ArrayList<Cella> rigac;
        for (int i = 0; i < righe; i++) {
            rigac = new ArrayList<>();

            for (int j = 0; j < colonne; j++) {
                rigac.add(new Cella());
            }
            celle.add(rigac);
        }

    }

    public void inserisciTessere(ArrayList<Card> card, int COLONNASELEZIONATA, ArrayList<Integer> ordine) {
        int contarighe = 0;

        for (int y = 0; y < righe; y++) {

            if (celle.get(y).get(COLONNASELEZIONATA).getTessera() == null) {
                contarighe++;
            }
        }

        if (contarighe - card.size() >= 0) {
            for (int i = contarighe - 1; i > 0; i--) {

                if (celle.get(i).get(COLONNASELEZIONATA).getTessera() == null) {

                    if (ordine.size() > 0) {

                        celle.get(i).get(COLONNASELEZIONATA).setCella(card.get(ordine.get(0)));
                        ordine.remove(0);


                    }

                }
            }
        } else throw new RuntimeException("Le tessere non ci stanno");
    }


    public boolean libreriaPiena() {
        int contacella = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (celle.get(i).get(j).getTessera() != null) {
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
                if (celle.get(i).get(y).getTessera() == null) {
                    System.out.print("NULL");
                } else {
                    System.out.print(celle.get(i).get(y).getTessera().id);
                }
            }
            System.out.println();
        }
    }


}
