package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.*;

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
        tabellone.riempimentoTabellone(tile);
        do {
            tabellone.print();
            for (Player player : players) {
                player.print();

                if (player.libreriaPiena()) {
                    if (finito.size() == 0)//---Se primo giocatore prende il l'endgame token
                        player.addToken(selectToken("end game"));
                    finito.add(player);
                    players.remove(player);
                }
                try {
                    pescaTesseraDalTabellone(player);
                } catch (Exception e) {
                    System.out.println(e);
                }
                //---Controllo common goal
                for (int i = 0; i < id_commonGoal.size(); i++) {
                    if (player.id_commonGoal.contains(id_commonGoal.get(i)))//--- controllo che lid del controllo sia presente in player
                        controlloCommonGoal(player, id_commonGoal.get(i));   //---- Controllo che il common goal sia verificato se viene verificato, viene prelevato il token dalla classe commongoal_n viene aggiunto ai token del player e verra rimosso l'id  dai goal da verificare del player
                }


            }
        } while (players.size() != 0);


    }

    //--- Controllo che commongoalN.controllo sia verificato
    //--- se si verifica aggiungo il token al player
    private Boolean controlloCommonGoal(Player player, Card card) {//--- Controllo il common goal specifico

        CommonGoal commonGoal = commonGoals.get(card.id);
        if (commonGoal.controllo(player)) {
            player.addToken(commonGoal.prendiToken(), card);
        }

        return false;
    }

    private void pescaTesseraDalTabellone(Player player) throws Exception {

        ArrayList<Card> card = prelevaTessera(); //--- tessere prelevate
        ArrayList<Integer> ordine = riordinamentoDelleTessere(card);

        System.out.println("Seleziona colonna: ");
        Scanner sc = new Scanner(System.in);
        //--- inserisciTessere ritorneta le tessere che non possono essere inserite nel tabellone
        //--- creare funzione per il rinserimento delle tessere qualora non ci stassero
        int colonna = sc.nextInt();
        int spaziLiberi = player.inserisciTessera(card, ordine, colonna);

        if (card.size() - spaziLiberi > 0) {
            tabellone.rimuoviTessere(tessereNonCiStanno(player, card, spaziLiberi, colonna));    //--- chiedo all'utente se vuole inserire le tessere
        } else
            tabellone.rimuoviTessere(card);

    }

    private ArrayList<Card> prelevaTessera() throws Exception { //--- prelevo le posizioni delle tessere dal tabellone
        String continua = "";
        ArrayList<Card> card = new ArrayList<>();
        boolean controllo;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Scegli tessera " + (card.size() + 1));
            System.out.print("Riga: ");
            int riga = sc.nextInt();
            System.out.print("Colonna: ");
            int colonna = sc.nextInt();

            card = tabellone.prelevaTessera(riga, colonna, card);
            if (card.size() == maxTesserePescabili)
                break;
            System.out.print("next/ no, per terminare: ");
            continua = sc.next();

        } while (!continua.toLowerCase().contains("next"));
        return card;
    }

    private ArrayList<Integer> riordinamentoDelleTessere(ArrayList<Card> card) {
        String conferma;
        ArrayList<Integer> ordine = new ArrayList<>();
        if (card.size() - 1 > 0) {
            do {
                System.out.println("Seleziona lordine delle tessere: ");
                Scanner sc = new Scanner(System.in);
                ordine = new ArrayList<>();
                for (int i = 0; i < card.size(); i++) {
                    boolean continua;
                    do {
                        continua = false;
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

                    } while (continua);
                }
                System.out.print("conferma/ no: ");
                conferma = sc.next().toLowerCase();
            } while (!conferma.contains("conferma"));
        } else
            ordine.add(0);
        return ordine;
    }

    //--- Chiedo all'utente, cosa vuole fare nel caso le tessere non ci stanno nella sua colonna della libreria
    private ArrayList<Card> tessereNonCiStanno(Player player, ArrayList<Card> card, int spaziLiberi, int colonna) {
        System.out.println("Queste tessere non ci stanno nella libreria: ");
        ArrayList<Card> tessereNonDisponibili = new ArrayList<>();
        for (int i = spaziLiberi; i < card.size(); i++) {
            System.out.println(card.get(i).id);
            tessereNonDisponibili.add(card.get(i));
        }
        if (card.size() - spaziLiberi != maxTesserePescabili) {
            System.out.println("Vuoi aggiungere queste tessere? si/ no");
            ArrayList<Card> tessereDisponibili = new ArrayList<>();
            for (int i = 0; i < spaziLiberi; i++) {
                System.out.println(card.get(i).id);
                tessereDisponibili.add(card.get(i));
            }

            Scanner sc = new Scanner(System.in);
            if (sc.next().toLowerCase().equals("si")) {
                ArrayList<Integer> ordine = riordinamentoDelleTessere(tessereDisponibili);
                try {
                    player.inserisciTessera(tessereDisponibili, ordine, colonna);
                } catch (Exception e) {
                    System.out.println(e);
                }

                return tessereDisponibili;


            }
        }
        System.out.println("Le tessere non ci stanno seleziona nuova colonna [colonna]/ ripesca [ripesca]");
        Scanner sc = new Scanner(System.in);
        if (sc.next().toLowerCase().equals("colonna")) {
            System.out.print("Inserisci colonna: ");
            tessereNonCiStanno(player, card, spaziLiberi, sc.nextInt());
        } else {
            tabellone.inserisciTessere(card);
            try {
                pescaTesseraDalTabellone(player);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return card;
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
