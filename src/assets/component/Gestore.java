package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.CommonGoal;

import java.util.*;

public class Gestore {

    public Tabellone tabellone;
    public ArrayList<Player> players;
    public ArrayList<Player> finito;
    public CardContainer commonGoal;
    public CardContainer scoringToken;
    public CardContainer tile;
    public Goals personalGoal;
    public int maxTesserePescabili;

    public ArrayList<Card> id_commonGoal;
    public int maxCommonGoal;

    public final Map<String, CommonGoal> commonGoals = new HashMap<>();


    public Gestore(Tabellone tabellone, ArrayList<Player> players, CardContainer commonGoal, CardContainer scoringToken, CardContainer tile, Goals personalGoal) {
        this.tabellone = tabellone;
        this.players = players;
        this.commonGoal = commonGoal;
        this.scoringToken = scoringToken;
        this.tile = tile;
        this.personalGoal = personalGoal;
        finito = new ArrayList<>();
        id_commonGoal = new ArrayList<>();

        maxTesserePescabili = 3;
        maxCommonGoal = 2;

    }

    public void init() {


        for (Player player : players) {
            player.personalGoal = selectRandomPersonalGoal();//--- Assegnamento dei personal goal
        }
        for (int i = 0; i < maxCommonGoal; i++) {
            id_commonGoal.add(selectRandomCommonGoal());//--- prendo degli id dei commongoal randomici e li aggiungo

        }


        for (Player player : players) {
            player.setId_commonGoal(id_commonGoal); //--- Aggiungo ai giocatori il common goal
        }
        for (Card card : id_commonGoal) {//---Scorro i commongoal id e creo solo le classi corrispondenti a quegli id
            commonGoals.put(card.id, CommonGoal.getCommonGoalById(card.id, commonGoal.path, assegnamentoToken(), tile));
        }
    }

    private ArrayList<Card> assegnamentoToken() {//---Aggiungo i token
        ArrayList<Card> token = new ArrayList<>();
        switch (players.size()) {
            case 2 -> {
                token.add(selectToken("scoring_8"));
                token.add(selectToken("scoring_4"));

            }
            case 3 -> {
                token.add(selectToken("scoring_8"));
                token.add(selectToken("scoring_6"));
                token.add(selectToken("scoring_4"));


            }
            case 4 -> {
                token.add(selectToken("scoring_8"));
                token.add(selectToken("scoring_6"));
                token.add(selectToken("scoring_4"));
                token.add(selectToken("scoring_2"));
            }
        }
        return token;
    }


    public void start() {
        do {
            for (Player player : players) {
                if (!tabellone.controlloTabellone()) {//--- Se il tabellone non ha tessere adiacenti lo riempie
                    tabellone.riempimentoTabellone(tile);
                }
                tabellone.print();//--- Stampo il tabellone
                player.printPersonalGoal();
                player.printLibreria();
                try {
                    pescaTesseraDalTabellone(player);
                } catch (Exception e) {
                    System.out.println(e);
                }
                //---Controllo common goal
                for (Card card : id_commonGoal) {
                    controlloCommonGoal(player, card);   //---- Controllo che il common goal sia verificato se viene verificato, viene prelevato il token dalla classe commongoal_n viene aggiunto ai token del player e verra rimosso l'id  dai goal da verificare del player
                }
                if (player.libreriaPiena()) {
                    if (finito.size() == 0) {//---Se primo giocatore prende il l'endgame token
                        player.addToken(selectToken("end game"));
                        System.out.println("Hai finito per primo e hai ottenuto l'end game token");
                    }
                    finito.add(player);

                }
            }
        } while (finito.size() != players.size());

        //--- Classifica

        for (Player p : finito) {
            p.contaPunti(tile);
        }
        Collections.sort(finito, Collections.reverseOrder());
        int i = 1;
        for (Player p : finito) {
            System.out.println(i + " " + p.name + " point: " + p.points);
            i++;
        }

    }

    //--- Controllo che commongoalN.controllo sia verificato
    //--- se si verifica aggiungo il token al player
    private Boolean controlloCommonGoal(Player player, Card card) {//--- Controllo il common goal specifico
        CommonGoal commonGoal = commonGoals.get(card.id);

        if (!player.id_commonGoal.contains(card)) //--- controllo che lid del controllo sia presente in player
            return false;
        if (commonGoal.controllo(player)) {
            player.addToken(commonGoal.prendiToken(), card);
            System.out.println("Hai sbloccato il common goal: "+commonGoal+" token: "+player.token.get(player.token.size()-1));
            return true;
        }
        return false;
    }

    private Boolean pescaTesseraDalTabellone(Player player) {
        ArrayList<Card> card = prelevaTessera();

        String decisione = domanda("Vuoi ripescare? si/ no: ", "si", "no");
        if (decisione.equals("si"))
            return pescaTesseraDalTabellone(player);

        ArrayList<Integer> ordine = riordinamentoDelleTessere(card);

        inserisciTessere(player, card, ordine);

        return true;
    }

    private void inserisciTessere(Player player, ArrayList<Card> card, ArrayList<Integer> ordine) {
        int spaziLiberi = 0;
        int colonna = selezionaColonna(player);
        try {
            spaziLiberi = player.inserisciTessera(card, ordine, colonna);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (card.size() - spaziLiberi > 0) {
            ArrayList<Card> supporto = tessereNonCiStanno(player, card, spaziLiberi, colonna);
            if (supporto != null)
                tabellone.rimuoviTessere(supporto);    //--- chiedo all'utente se vuole inserire le tessere
            else {
                String decisione = domanda("Seleziona nuova colonna o ripesca: ", "colonna", "ripesca");
                if (decisione.equals("colonna"))
                    inserisciTessere(player, card, ordine);
                if (decisione.equals("ripesca"))
                    pescaTesseraDalTabellone(player);
            }
        } else
            tabellone.rimuoviTessere(card);
        System.out.println("Hai pescato queste carte: ");
        for (Card c : card)
            System.out.print(c.type + "\t");
        System.out.println();

    }

    private int selezionaColonna(Player player) {


        int colonna=0;
        boolean continua;
        do {
            continua = true;
            try {
                System.out.println("Seleziona colonna: ");
                Scanner sc = new Scanner(System.in);
                colonna = sc.nextInt();
                if (colonna >= 0 && colonna <= player.libreria.get(0).size() - 1) {
                    continua = false;
                } else {
                    System.out.println("Errore");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (continua);
        return colonna;
    }


    private ArrayList<Card> prelevaTessera() { //--- prelevo le posizioni delle tessere dal tabellone

        String decisione = "";
        ArrayList<Card> card = new ArrayList<>();


        do {
            System.out.println("Scegli tessera " + (card.size() + 1));
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Riga: ");
                int riga = sc.nextInt();
                System.out.print("Colonna: ");
                int colonna = sc.nextInt();
                card = tabellone.prelevaTessera(riga, colonna, card);

                decisione = domanda("Conferma tessera si/ no: ", "si", "no");
                if (decisione.equals("no")) {
                    card.remove(card.size() - 1);
                    decisione = "";
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (card.size() == maxTesserePescabili)
                    break;
                if (card.size() > 0) {
                    decisione = domanda("Vuoi continuare a pescare? si/no: ", "si", "no");
                }
            }
        } while (!decisione.contains("no"));
        return card;
    }

    private ArrayList<Integer> riordinamentoDelleTessere(ArrayList<Card> card) {
        String decisione;
        ArrayList<Integer> ordine = new ArrayList<>();
        if (card.size() - 1 == 0) {
            ordine.add(0);
            return ordine;
        }
        System.out.println("Seleziona l'ordine delle tessere: ");


        ordine = new ArrayList<>();
        for (int i = 0; i < card.size(); i++) {
            boolean continua;
            do {
                continua = false;
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print(card.get(i).type + " posizione: ");
                    int numero = sc.nextInt();
                    if (numero >= card.size() || numero < 0) {
                        System.out.println("Errore indice");
                        continua = true;
                    }
                    if (!continua) {
                        if (ordine.contains(numero)) {
                            System.out.println("Indice gia presente");
                            continua = true;
                        } else
                            ordine.add(numero);
                    }
                } catch (Exception e) {
                    continua = true;
                    System.out.println(e);
                }
            } while (continua);
        }
        decisione = domanda("Conferma si/no: ", "si", "no");
        if (decisione.equals("no"))
            riordinamentoDelleTessere(card);
        return ordine;
    }

    private String domanda(String msg, String c1, String c2) {
        Scanner sc = new Scanner(System.in);
        String decisione;
        c1 = c1.toLowerCase();
        c2 = c2.toLowerCase();
        do {
            System.out.println(msg);
            decisione = sc.next().toLowerCase();
            if (decisione.equals(c1))
                return c1;
            if (decisione.equals(c2))
                return c2;
        } while (!decisione.contains(c1) && !decisione.contains(c2));
        return null;
    }

    //--- Chiedo all'utente, cosa vuole fare nel caso le tessere non ci stanno nella sua colonna della libreria
    private ArrayList<Card> tessereNonCiStanno(Player player, ArrayList<Card> card, int spaziLiberi, int colonna) {
        String decisione;
        System.out.println("Queste tessere non ci stanno nella libreria: ");
        ArrayList<Card> tessereNonDisponibili = new ArrayList<>();
        for (int i = spaziLiberi; i < card.size(); i++) {
            System.out.println(card.get(i).id);
            tessereNonDisponibili.add(card.get(i));
        }
        if (card.size() - tessereNonDisponibili.size() != 0) {
            System.out.println("Vuoi aggiungere queste tessere?  ");
            ArrayList<Card> tessereDisponibili = new ArrayList<>();
            for (int i = 0; i < spaziLiberi; i++) {
                System.out.println(card.get(i).id);
                tessereDisponibili.add(card.get(i));
            }
            decisione = domanda("si/ no:", "si", "no");
            if (decisione.equals("si")) {
                ArrayList<Integer> ordine = riordinamentoDelleTessere(tessereDisponibili);
                try {
                    player.inserisciTessera(tessereDisponibili, ordine, colonna);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return tessereDisponibili;
            }
        }
        return null;
    }

    private Card selectToken(String id) {
        for (int i = 0; i < scoringToken.list.size(); i++) {
            if (scoringToken.list.get(i).id.equals(id)) {
                return scoringToken.list.get(i);
            }
        }
        return null;
    }

    private CardContainer selectRandomPersonalGoal() {
        Random rand = new Random();
        int randomCard = rand.nextInt(personalGoal.list.size());
        CardContainer personalGoal = this.personalGoal.list.get(randomCard);
        this.personalGoal.list.remove(randomCard);
        return personalGoal;
    }

    private Card selectRandomCommonGoal() {
        Random rand = new Random();

        int randomCard = rand.nextInt(commonGoal.list.size());
        Card id = commonGoal.list.get(randomCard);

        for (int i = 0; i < id_commonGoal.size(); i++) {
            if (id.id == id_commonGoal.get(i).id) {
                return selectRandomCommonGoal();
            }
        }

        return id;
    }


}
