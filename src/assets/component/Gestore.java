package assets.component;

import assets.LivingRoom.Tabellone;
import assets.card.Card;
import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gestore {

    public Tabellone tabellone;
    public ArrayList<Player> players;
    public ArrayList<Player> finito;
    public CardContainer commonGoal;
    public CardContainer scoringToken;
    public CardContainer tile;
    public Goals personalGoal;
    public int maxTesserePescabili;
    public ArrayList<Goals> commonGoalPoint;
    public ArrayList<Integer> commonGoals;
    public int maxCommonGoal;

    public CommonGoal1 commonGoal1;
    public CommonGoal2 commonGoal2;
    public CommonGoal3 commonGoal3;
    public CommonGoal4 commonGoal4;
    public CommonGoal5 commonGoal5;
    public CommonGoal6 commonGoal6;
    public CommonGoal7 commonGoal7;
    public CommonGoal8 commonGoal8;
    public CommonGoal9 commonGoal9;
    public CommonGoal10 commonGoal10;
    public CommonGoal11 commonGoal11;
    public CommonGoal12 commonGoal12;


    public Gestore(Tabellone tabellone, ArrayList<Player> players, CardContainer commonGoal, CardContainer scoringToken, CardContainer tile, Goals personalGoal) {
        this.tabellone = tabellone;
        this.players = players;
        this.commonGoal = commonGoal;
        this.scoringToken = scoringToken;
        this.tile = tile;
        this.personalGoal = personalGoal;
        finito = new ArrayList<>();
        commonGoals = new ArrayList<>();
        commonGoalPoint = new ArrayList<>();
        maxTesserePescabili = 3;
        maxCommonGoal = 2;

    }

    public void init() {
        for (Player player : players) {
            player.personalGoal = selectRandomPersonalGoal();//--- Assegnamento dei personal goal
        }
        for (int i = 0; i < maxCommonGoal; i++)
            commonGoals.add(selectRandomCommonGoal());//--- prendo degli id dei commongoal randomici e li aggiungo
        for (Player player : players) {
            player.setCommonGoal(commonGoals); //--- Aggiungo ai giocatori il common goal
        }
        for (int i : commonGoals) {//---Scorro i commongoal id e creo solo le classi corrispondenti a quegli id
            switch (i) {
                case 1 -> {
                    commonGoal1 = new CommonGoal1(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal1.print();
                }
                case 2 -> {

                    commonGoal2 = new CommonGoal2(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal2.print();
                }
                case 3 -> {
                    commonGoal3 = new CommonGoal3(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal3.print();

                }
                case 4 -> {
                    commonGoal4 = new CommonGoal4(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal4.print();

                }
                case 5 -> {
                    commonGoal5 = new CommonGoal5(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal5.print();
                }
                case 6 -> {
                    commonGoal6 = new CommonGoal6(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal6.print();
                }
                case 7 -> {
                    commonGoal7 = new CommonGoal7(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal7.print();
                }
                case 8 -> {
                    commonGoal8 = new CommonGoal8(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal8.print();
                }
                case 9 -> {
                    commonGoal9 = new CommonGoal9(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal9.print();
                }
                case 10 -> {
                    commonGoal10 = new CommonGoal10(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal10.print();
                }
                case 11 -> {
                    commonGoal11 = new CommonGoal11(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal11.print();
                }
                case 12 -> {
                    commonGoal12 = new CommonGoal12(commonGoal.list.get(i).id, commonGoal.path,assegnamentoToken());
                    commonGoal12.print();
                }

            }
        }

    }

    private ArrayList<Card> assegnamentoToken() {//---Aggiungo i token
        ArrayList<Card> token = new ArrayList<>();
        switch (players.size()) {
            case 2 -> {
                token.add(selectToken("scoring_4"));
                token.add(selectToken("scoring_8"));
            }
            case 3 -> {
                token.add(selectToken("scoring_4"));
                token.add(selectToken("scoring_6"));
                token.add(selectToken("scoring_8"));
            }
            case 4 -> {
                token.add(selectToken("scoring_2"));
                token.add(selectToken("scoring_4"));
                token.add(selectToken("scoring_6"));
                token.add(selectToken("scoring_8"));
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
                    finito.add(player);
                    players.remove(player);
                }
                try {
                    pescaTesseraDalTabellone(player);
                } catch (Exception e) {
                    System.out.println(e);
                }
                for(int i = 0; i < commonGoals.size();i++) {
                    if(player.commonGoal.contains(commonGoals.get(i))) {//--- Se il common goal è presente allora controllo
                        System.out.println("common: "+controlloCommonGoal(player, commonGoals.get(i)));   //---- Controllo che il common goal sia stato completato
                    }
                }


            }
        } while (players.size() != 0);


    }

    private Boolean controlloCommonGoal(Player player, int i) {//--- Controllo il common goal specifico

            switch (i) {
                case 1 -> {
                    if (commonGoal1.controllo(player)) {
                        player.addCommonToken(commonGoal1.prendiToken());
                        return true;
                    }

                }
                case 2 -> {
                    if (commonGoal2.controllo(player)) {
                        player.addCommonToken(commonGoal2.prendiToken());
                        return true;
                    }
                }
                case 3 -> {
                    if (commonGoal3.controllo(player)) {
                        player.addCommonToken(commonGoal3.prendiToken());
                        return true;
                    }

                }
                case 4 -> {
                    if (commonGoal4.controllo(player)) {
                        player.addCommonToken(commonGoal4.prendiToken());
                        return true;
                    }

                }
                case 5 -> {
                    if (commonGoal5.controllo(player)) {
                        player.addCommonToken(commonGoal5.prendiToken());
                        return true;
                    }
                }
                case 6 -> {
                    if (commonGoal6.controllo(player)) {
                        player.addCommonToken(commonGoal6.prendiToken());
                        return true;
                    }
                }
                case 7 -> {
                    if (commonGoal7.controllo(player)) {
                        player.addCommonToken(commonGoal7.prendiToken());
                        return true;
                    }
                }
                case 8 -> {
                    if (commonGoal8.controllo(player)) {
                        player.addCommonToken(commonGoal8.prendiToken());
                        return true;
                    }
                }
                case 9 -> {
                    if (commonGoal9.controllo(player, tile)) {
                        player.addCommonToken(commonGoal9.prendiToken());
                        return true;
                    }
                }
                case 10 -> {
                    if (commonGoal10.controllo(player)) {
                        player.addCommonToken(commonGoal9.prendiToken());
                        return true;
                    }
                }
                case 11 -> {
                    if (commonGoal11.controllo(player)) {
                        player.addCommonToken(commonGoal11.prendiToken());
                        return true;
                    }
                }
                case 12 -> {
                    if (commonGoal12.controllo(player)) {
                        player.addCommonToken(commonGoal12.prendiToken());
                        return true;
                    }
                }
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

    private int selectRandomCommonGoal() {
        Random rand = new Random();
        int randomCard = rand.nextInt(commonGoal.list.size());
        if (commonGoals.contains(randomCard))
            selectRandomCommonGoal();
        return randomCard;
    }


}
