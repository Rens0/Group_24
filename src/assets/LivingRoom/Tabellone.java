package assets.LivingRoom;

import assets.card.Card;
import assets.card.CardContainer;
import assets.component.Cella;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tabellone {
    private String path;
    private String id;

    private int nPlayer;

    private List<ArrayList<Cella>> mappa;

    public Tabellone() {
        mappa = new ArrayList<ArrayList<Cella>>();
    }

    public void setPlayer(int nPlayer) {
        this.nPlayer = nPlayer;
    }

    public void riempimentoTabellone(CardContainer card) {
        for (int i = 0; i < mappa.size(); i++) {
            for (int j = 0; j < mappa.get(i).size(); j++) {
                switch (nPlayer) {
                    case 2: {
                        if (mappa.get(i).get(j).getAccessibilitaCella() == 2) {
                            mappa.get(i).get(j).setCella(randomCard(card, i, j));
                        }
                        break;
                    }
                    case 3: {
                        if (mappa.get(i).get(j).getAccessibilitaCella() >= 2 && mappa.get(i).get(j).getAccessibilitaCella() <= 3) {
                            mappa.get(i).get(j).setCella(randomCard(card, i, j));
                        }

                        break;
                    }
                    case 4: {
                        if (mappa.get(i).get(j).getAccessibilitaCella() >= 2 && mappa.get(i).get(j).getAccessibilitaCella() <= 4) {
                            mappa.get(i).get(j).setCella(randomCard(card, i, j));
                        }
                        break;
                    }
                }
            }
        }
    }

    private Card randomCard(CardContainer card, int riga, int colonna) {
        Random rand = new Random();
        int randomCard = rand.nextInt(card.getList().size());
        Card cardSalvata = card.getList().get(randomCard);
        int sum = 0;
        for (Card c : card.getList()) {
            sum += c.getAmount();
        }
        if (sum <= 0)
            return new Card();

        if (cardSalvata.getAmount() <= 0) {
            return randomCard(card, riga, colonna);
        }

        //test.card.list.remove(valore);
        int randomId = rand.nextInt(card.getList().get(randomCard).getMoreId().size());
        String id = card.getList().get(randomCard).getMoreId().get(randomId);
        String type = card.getList().get(randomCard).getType();

        cardSalvata = new Card(id, type);
        cardSalvata.setCoord(riga, colonna);
        //System.out.println(cardSalvata.id);
        card.getList().get(randomCard).getAmount();

        return cardSalvata;
    }

    public void inserisciTessere(ArrayList<Card> card) {
        for (int i = 0; i < card.size(); i++) {
            mappa.get(card.get(i).getRow()).get(card.get(i).getColumn()).setTile(card.get(i));
        }

    }

    public void print() {
        for (int i = 0; i <= mappa.size(); i++) {
            for (int j = 0; j <= mappa.get(0).size(); j++) {
                if (i == mappa.size() && j == mappa.get(0).size()) {
                    System.out.print("_______");
                } else {
                    if (i == mappa.size())
                        System.out.print("___" + j + "___\t");

                    if (j == mappa.get(0).size())
                        System.out.print("___" + i + "___\t");
                }

                if (i < mappa.size() && j < mappa.get(0).size()) {
                    if (mappa.get(i).get(j).getTessera().getType() == null) {
                        System.out.print(".......\t");
                    } else {
                        System.out.print(mappa.get(i).get(j).getTessera().getType() + "\t");
                    }
                }
            }

            System.out.println();
        }

    }

    public Card getTessera(int riga, int colonna) throws Exception {

        if (riga < 0 || colonna < 0)
            throw new Exception("Indice negativo");
        if (riga > mappa.size())
            throw new Exception("riga " + riga + " > " + mappa.size());
        if (colonna > mappa.get(0).size())
            throw new Exception("colonna " + colonna + " > " + mappa.get(0).size());
        if (mappa.get(riga).get(colonna).getTile().getId() == null)
            throw new Exception("La tessera selezionata non è disponibile");

        Card cartaSelezionata = mappa.get(riga).get(colonna).getTile();
        if (cartaSelezionata.getType() == null)
            throw new Exception("La carta e' null ");

        return cartaSelezionata;

    }


    public boolean controlloSpazioLibero(Card card) {//se trova uno spazio libero ritorna false se no true


        if (card.getRow() == 0) {
            return false;
        }
        if (card.getColumn() == 0)
            return false;

        if (card.getRow() == mappa.size() - 1) {
            return false;
        }
        if (card.getColumn() == mappa.get(0).size() - 1) {
            return false;
        }
        return controlloColonnaDestra(card) && controlloColonnaSinistra(card) && controlloRighaSopra(card) && controlloRighaSotto(card);


    }

    public boolean controlloAdiacenza(ArrayList<Card> card) {
        /*if (card.size() > 1) {
            int delta = deltaRiga(card.get(card.size() - 2), card.get(card.size() - 1)) - deltaColonna(card.get(card.size() - 2), card.get(card.size() - 1));

            int deltaRigaPre = deltaRiga(card.get(1), card.get(0));
            int deltaColonnaPre = deltaColonna(card.get(1), card.get(0));

            for (int i = 1; i < card.size() - 1; i++) {
                int deltaRigaNow = deltaRiga(card.get(i), card.get(i + 1));
                int deltaColonnaNow = deltaColonna(card.get(i), card.get(i + 1));
                System.out.println(deltaRigaPre+" "+deltaRigaNow+" delta colonna: "+deltaColonnaPre+" "+deltaColonnaNow);
                if (deltaRigaPre != deltaRigaNow)
                    return false;
                if (deltaColonnaPre != deltaColonnaNow)
                    return false;
            }


            if (delta < 0)
                delta *= -1;
            if (delta == 0 || delta == 1)
                return true;


            return false;
        }*/

        //---Prendo carta centrale
        //---Ordinamento
        boolean riga = true;
        boolean colonna = true;
        for (int i = 0; i < card.size() - 1; i++) {
            if (card.get(i).getRow() != card.get(i + 1).getRow())
                riga = false;
            if (card.get(i).getColumn() != card.get(i + 1).getColumn())
                colonna = false;
        }
        if (!riga && !colonna)
            return false;

        Collections.sort(card);


        for (int i = 0; i < card.size() - 1; i++) {
            int deltaR = deltaRiga(card.get(i), card.get(i + 1));
            int deltaC = deltaColonna(card.get(i), card.get(i + 1));
            //---Controllo stessa riga
            if (deltaR < 0)
                deltaR *= -1;
            if (deltaC < 0)
                deltaR *= -1;
            if (deltaR == 0 || deltaR == 1) {
                if (deltaC == 0 || deltaC == 1)
                    return true;
                else
                    return false;
            } else
                return false;
        }
        return true;
    }

    public boolean controlloTabellone() {
        for (int i = 0; i < mappa.size(); i++) {
            for (int j = 0; j < mappa.get(0).size(); j++) {
                if (i == mappa.size() - 1 && j >= mappa.get(0).size() - 1)
                    break;
                Card card = mappa.get(i).get(j).getTile();
                if (card.getType() != null) {
                    if (j >= mappa.get(0).size() - 1) {
                        if (controlloRighaSotto(card))
                            return true;
                    } else {
                        if (controlloColonnaDestra(card))
                            return true;
                    }
                    if (i >= mappa.size() - 1) {
                        if (controlloColonnaDestra(card))
                            return true;
                    } else {
                        if (controlloRighaSotto(card))
                            return true;
                    }
                }
            }

        }
        return false;
    }

    private int deltaRiga(Card pre, Card now) {
        int delta = pre.getRow() - now.getRow();
        if (delta < 0)
            delta *= -1;
        return delta;
    }

    private int deltaColonna(Card pre, Card now) {
        int delta = pre.getColumn() - now.getColumn();
        if (delta < 0)
            delta *= -1;
        return delta;
    }

    public Boolean controlloRighaSotto(Card card) {
        if (mappa.get(card.getRow() + 1).get(card.getColumn()).getTile().getType() != null)
            return true;
        return false;
    }

    public Boolean controlloColonnaDestra(Card card) {
        if (mappa.get(card.getRow()).get(card.getColumn() + 1).getTile().getType() != null)
            return true;
        return false;
    }

    public Boolean controlloRighaSopra(Card card) {
        if (mappa.get(card.getRow() - 1).get(card.getColumn()).getTile().getType() != null)
            return true;
        return false;
    }

    public Boolean controlloColonnaSinistra(Card card) {
        if (mappa.get(card.getRow()).get(card.getColumn() - 1).getTile().getType() != null)
            return true;
        return false;
    }

    public void rimuoviTessere(ArrayList<Card> card) {
        for (int i = 0; i < card.size(); i++) {
            mappa.get(card.get(i).getRow()).get(card.get(i).getColumn()).setTile(new Card());
        }

    }

    public void rimuoviTessera(Card card) throws Exception {
        mappa.get(card.getRow()).get(card.getColumn()).setTile(new Card());
    }

    public ArrayList<Card> prelevaTessera(int riga, int colonna, ArrayList<Card> card) throws Exception {

        boolean controllo = true;

        Card carta = getTessera(riga, colonna);

        //--- Controllo che non abbia pescato la stessa tessera
        if (card.contains(carta)) {
            throw new Exception("Tessera gia selezionata");
        } else
            card.add(carta);


        //--- Controllo che ogni tessera abbia uno spazio libero

        if (controllo && controlloSpazioLibero(carta))//--- Se una tessera non ha una cella nelle 4 direzioni libera
        {
            card.remove(carta);
            throw new Exception("La tessera non ha uno spazio libero");
        }

        //---Controllo che le tessere siano adiacenti
        if (controllo && !controlloAdiacenza(card)) {
            card.remove(carta);
            throw new Exception("Le tessere non sono adiacenti");
        }
        return card;
    }

    public List<ArrayList<Cella>> getMappa() {
        return mappa;
    }


}

