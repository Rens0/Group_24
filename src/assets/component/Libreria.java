package assets.component;

import assets.card.Card;

import java.util.ArrayList;
import java.util.List;


public class Libreria {


    private int righe;
    private int colonne;
    private List<List<Cella>> libreria;
   
    public Libreria() {
        this(6, 5);
    }

    public Libreria(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;


        libreria = new ArrayList<>();
        ArrayList<Cella> rigac;
       for (int i = 0; i < righe; i++) {
            rigac = new ArrayList<>();

            for (int j = 0; j < colonne; j++) {
                rigac.add(new Cella());
            }
            libreria.add(rigac);
        }
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


    public int inserisciTessere(ArrayList<Card> card, int COLONNASELEZIONATA) throws Exception {
        int contaCelle = 0;
        //--- Conto celle disponibili
        for (int j = 0; j < righe; j++) {
            if (libreria.get(j).get(COLONNASELEZIONATA).getTessera().getType() == null) {
                contaCelle++;
            }
        }


        if (contaCelle - card.size() >= 0) {
            int h = 0;
            for (int i = contaCelle - 1; i >= 0; i--) {
                if (libreria.get(i).get(COLONNASELEZIONATA).getTessera().getType() == null) {
                    if (h < card.size() ) {
                        libreria.get(i).get(COLONNASELEZIONATA).setCella(card.get(h));

                    }
                    h++;
                }
            }
        }
        return contaCelle;
    }


    public boolean libreriaPiena() {
       int contacella = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (libreria.get(i).get(j).getTessera().getType() != null) {
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

    public String tipoCasella(int riga, int colonna) {
        return libreria.get(riga).get(colonna).getTessera().getType();
    }
    
    /**
     * controlla che la casella non sia nulla e che sia rientri nella matrice della libreria
     * @param riga della casella 
     * @param colonna della casella 
     * @param visitato matrice di controllo
     * @param tipo della tessera
     * @return true se sono soddisfatte le condizioni "non nulla" e "dentro la matrice" 
     */

    private boolean checkCasella(int riga, int colonna, boolean visitato[][], String tipo) {
 
        return (riga >= 0) && (riga < righe) && (colonna >= 0) && (colonna < colonne) && !(libreria.get(riga).get(colonna).isEmpty())
                && tipoCasella(riga, colonna).equals(tipo)
                && !(visitato[riga][colonna]);
    }
    /**
     * partendo da una casella conta se le caselle adiacenti hanno lo stesso tipo di tessera
     * @param riga della casella
     * @param colonna della casella 
     * @param visitata matrice di supporto
     * @param tipo della tessera 
     * @return contatore: numero di caselle nel gruppo
     */
    private int contaCaselleAdicenti(int riga, int colonna, boolean visitata[][], String tipo) {
        int contatore = 1;
        visitata[riga][colonna]=true;
        if (checkCasella(riga, colonna + 1, visitata, tipo)) {//destra
            contatore += contaCaselleAdicenti(riga, colonna + 1, visitata, tipo);
        }
        if (checkCasella(riga + 1, colonna, visitata, tipo)) {//sotto
            contatore += contaCaselleAdicenti(riga + 1, colonna, visitata, tipo);
        }
        if (checkCasella(riga, colonna - 1, visitata, tipo)) {//sinistra
            contatore += contaCaselleAdicenti(riga, colonna - 1, visitata, tipo);
        }
        if (checkCasella(riga - 1, colonna, visitata, tipo)) {//sopra
            contatore += contaCaselleAdicenti(riga - 1, colonna, visitata, tipo);
        }
        return contatore;
    }

    private static final String tipi[] = {"cornice", "gatto", "gioco", "trofeo", "libro", "pianta"};

    private ArrayList<Integer> caselleGruppo = new ArrayList<>();
    
    public ArrayList<Integer> getCaselleGruppo() {
		return caselleGruppo;
	}
    
    /**
     * mette nella lista "caselleGruppo" la dimensione di ogni gruppo
     */
 
	public void contaCaselleGruppi() {//ritorna un array con il numero di caselle di ogni gruppo
		caselleGruppo = new ArrayList<>(); 
        for (String tipo : tipi) {
            boolean visitato[][] = new boolean[righe][colonne];
            for (int riga = 0; riga < righe; riga++) {
                for (int colonna = 0; colonna < colonne; colonna++) {
                    if (!(libreria.get(riga).get(colonna).isEmpty()) && tipoCasella(riga, colonna).equals(tipo)
                            && !(visitato[riga][colonna])) {

                    	int numeroCaselle = contaCaselleAdicenti(riga, colonna, visitato, tipo);
                    if(numeroCaselle>1)
                    caselleGruppo.add(numeroCaselle);
                    }
                }
            }
        }
        
    }
	
	/**
	 * @return punti: ritorna il numero di punti in base al numero di caselle adiacenti 
	 */

    public int contaPuntiCaselleAdiacenti() {
        int punti = 0;
        contaCaselleGruppi();
        for (int i : caselleGruppo) {
            if (i == 3) {
                punti += 2;
            }
            if (i == 4) {
                punti += 3;
            }
            if (i == 5) {
                punti += 5;
            }
            if (i >= 6) {
                punti += 8;
            }
        }

        return punti;
    }
    public List<List<Cella>> getLibreria() {
		return libreria;
	}
}
