package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.CommonGoal;

import java.util.*;

public class Gestore {

    private Tabellone tabellone;
    private ArrayList<Player> players;
    private ArrayList<Player> finito;
    private CardContainer commonGoal;
    private CardContainer scoringToken;
    private CardContainer tile;
    private Goals personalGoal;
    private int maxTesserePescabili;
    private ArrayList<Card> id_commonGoal;
    private int maxCommonGoal;

    private final Map<String, CommonGoal> commonGoals = new HashMap<>();


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
            player.setPersonalGoal(selectRandomPersonalGoal());//--- Assegnamento dei personal goal
        }
        for (int i = 0; i < maxCommonGoal; i++) {
            id_commonGoal.add(selectRandomCommonGoal());//--- prendo degli id dei commongoal randomici e li aggiungo

        }


        for (Player player : players) {
            player.setId_commonGoal(id_commonGoal); //--- Aggiungo ai giocatori il common goal
        }
        for (Card card : id_commonGoal) {//---Scorro i commongoal id e creo solo le classi corrispondenti a quegli id
            commonGoals.put(card.getId(), CommonGoal.getCommonGoalById(card.getId(), commonGoal.getPath(), assegnamentoToken()));
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
                System.out.print("E' il turno di : ");
                player.printName();
                printCommonGoal();

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
                player.printLibreria();
                //---Controllo common goal
                for (Card card : id_commonGoal) {
                    controlloCommonGoal(player, card);   //---- Controllo che il common goal sia verificato se viene verificato, viene prelevato il token dalla classe commongoal_n viene aggiunto ai token del player e verra rimosso l'id  dai goal da verificare del player
                }
                if (player.getLibreria().libreriaPiena()) {
                    if (finito.size() == 0) {//---Se primo giocatore prende il l'endgame token
                        player.addToken(selectToken("end game"));
                        System.out.println("Hai finito per primo e hai ottenuto l'end game token");
                    }
                    finito.add(player);
                    break;
                }
            }
        } while (finito.size() != 1);

        //--- Classifica

        for (Player p : players) {
            p.contaPunti(tile);
        }
        Collections.sort(players, Collections.reverseOrder());
        int i = 1;
        for (Player p : players) {
            System.out.println(i + " " + p.getName() + " point: " + p.getPoints());
            i++;
        }

    }

    //--- Controllo che commongoalN.controllo sia verificato
    //--- se si verifica aggiungo il token al player
    private Boolean controlloCommonGoal(Player player, Card card) {//--- Controllo il common goal specifico
        CommonGoal commonGoal = commonGoals.get(card.getId());

        if (!player.getId_commonGoal().contains(card)) //--- controllo che lid del controllo sia presente in player
            return false;
        if (commonGoal.controllo(player)) {
            player.addToken(commonGoal.prendiToken(), card);
            System.out.println("Hai sbloccato il common goal: " + card.getId() + " token: " + player.getToken().get(player.getToken().size() - 1).getId());
            return true;
        }
        return false;
    }

    private Boolean pescaTesseraDalTabellone(Player player) {
        ArrayList<Card> card = prelevaTessera();

        System.out.println("Hai pescato queste carte: ");
        for (Card c : card)
            System.out.print(c.getType() + "\t");
        System.out.println();

        String decisione = domanda("Vuoi annullare ciò che hai pescato e ripescare? si/ no: ", "si", "no");
        if (decisione.equals("si"))
            return pescaTesseraDalTabellone(player);
        inserisciTessere(player,  riordinamentoDelleTessere(card));

        return true;
    }

    private void inserisciTessere(Player player, ArrayList<Card> card) {
        int spaziLiberi = 0;
        int colonna = selezionaColonna(player);
        try {
            spaziLiberi = player.getLibreria().inserisciTessere(card, colonna);
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
                    inserisciTessere(player, card);
                if (decisione.equals("ripesca"))
                    pescaTesseraDalTabellone(player);
            }
        } else{

            tabellone.rimuoviTessere(card);

        }

    }

    private int selezionaColonna(Player player) {

        int colonna = 0;
        boolean continua;
        do {
            continua = true;
            try {
                System.out.println("Seleziona colonna: ");
                Scanner sc = new Scanner(System.in);
                colonna = sc.nextInt();
                if (colonna >= 0 && colonna <= player.getLibreria().getColonne() - 1) {
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

    private ArrayList<Card> riordinamentoDelleTessere(ArrayList<Card> card) {
        String decisione;
        ArrayList<Integer> ordine = new ArrayList<>();
        if (card.size() - 1 == 0) {
            return card;
        }
        System.out.println("Seleziona l'ordine delle tessere: ");



        for (int i = 0; i < card.size(); i++) {
            boolean continua;
            do {
                continua = false;
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print(card.get(i).getType() + " posizione: ");
                    int numero = sc.nextInt() - 1;
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
        for(int i=0; i<ordine.size()-1; i++)
        {
            for(int j=i+1; j<ordine.size(); j++)
                if(ordine.get(i)> ordine.get(j)) {
                    Collections.swap(ordine,i,j);
                    Collections.swap(card,i,j);
                }
        }
        decisione = domanda("Conferma si/no: ", "si", "no");
        if (decisione.equals("no"))
            riordinamentoDelleTessere(card);
        return card;
    }

    private String domanda(String msg, String c1, String c2) {
        Scanner sc = new Scanner(System.in);
        String decisione;
        c1 = c1.toLowerCase();
        c2 = c2.toLowerCase();
        do {
            System.out.println(msg);
            decisione = sc.next().toLowerCase();
            if(decisione!=null) {
                if (decisione.equals(c1))
                    return c1;
                if (decisione.equals(c2))
                    return c2;
            }
        } while (!decisione.contains(c1) && !decisione.contains(c2));
        return null;
    }

    //--- Chiedo all'utente, cosa vuole fare nel caso le tessere non ci stanno nella sua colonna della libreria
    private ArrayList<Card> tessereNonCiStanno(Player player, ArrayList<Card> card, int spaziLiberi, int colonna) {
        String decisione;
        System.out.println("Queste tessere non ci stanno nella libreria: ");
        ArrayList<Card> tessereNonDisponibili = new ArrayList<>();
        for (int i = spaziLiberi; i < card.size(); i++) {
            System.out.println(card.get(i).getType());
            tessereNonDisponibili.add(card.get(i));
        }
        if (card.size() - tessereNonDisponibili.size() != 0) {
            System.out.println("Vuoi aggiungere queste tessere?  ");
            ArrayList<Card> tessereDisponibili = new ArrayList<>();
            for (int i = 0; i < spaziLiberi; i++) {
                System.out.println(card.get(i).getType());
                tessereDisponibili.add(card.get(i));
            }
            decisione = domanda("si/ no:", "si", "no");
            if (decisione.equals("si")) {
                try {
                    player.getLibreria().inserisciTessere(riordinamentoDelleTessere(tessereDisponibili), colonna);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return tessereDisponibili;
            }
        }
        return null;
    }

    private Card selectToken(String id) {
        for (int i = 0; i < scoringToken.getList().size(); i++) {
            if (scoringToken.getList().get(i).getId().equals(id)) {
                return scoringToken.getList().get(i);
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

        int randomCard = rand.nextInt(commonGoal.getList().size());
        Card id = commonGoal.getList().get(randomCard);

        for (int i = 0; i < id_commonGoal.size(); i++) {
            if (id.getId() == id_commonGoal.get(i).getId()) {
                return selectRandomCommonGoal();
            }
        }

        return id;
    }

    private void printCommonGoal() {
        int i = 1;
        for (Card card : id_commonGoal) {
            System.out.println("CommonGoal " + i++ + ":");
            System.out.println(card.getDescription());
        }
    }
}
