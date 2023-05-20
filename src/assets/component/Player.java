package assets.component;

import assets.card.Card;
import assets.card.CardContainer;

import java.util.ArrayList;

public class Player extends Libreria {

    public String name;
    public int ID;
    private static int ID_Number = 0;
    private int points = 0;
    public ArrayList<Card> token;
    public CardContainer personalGoal;
    public ArrayList<Card> id_commonGoal;

    public Player(String name) {
        this.name = name;
        this.ID = ID_Number;
        ID_Number++;
        token = new ArrayList<>();


    }

    public void setId_commonGoal(ArrayList<Card> id_commonGoal) {
        this.id_commonGoal = new ArrayList<>(id_commonGoal);


    }

    //---Aggiungo il token e rimuovo l'id
    public void addToken(Card token, Card goal) {
        this.id_commonGoal.remove(goal);
        this.token.add(token);
    }

    public void addToken(Card token) {
        this.token.add(token);
    }

    public void contaPunti(CardContainer tile) {
        for (Card t : token) //---punti dei common goal
            points += t.point;
        points += personalGoal.point.get(controlloPersonalGoal());//--- Controllo punti personal goal
        points += contaPuntiCaselleAdiacenti(); //--- Controllo dei punti in base alle tessere vicine
    }

    private int controlloPersonalGoal() {
        int contatore = 0;
        for (int i = 0; i < personalGoal.list.size(); i++) {
            Card card = personalGoal.list.get(i);
            if (card.type.equals(libreria.get(card.row).get(card.column).tile.type))
                contatore++;
        }
        return contatore;
    }


    public int inserisciTessera(ArrayList<Card> card, ArrayList<Integer> ordine, int COLONNA) throws Exception {
        return inserisciTessere(card, ordine, COLONNA);

    }


    @Override
    public String toString() {
        return this.name + " " + this.ID + " " + this.points;
    }


    public void tokenPrint() {
        for (Card t : token)
            System.out.println(t.id);
    }
    public void printLibreria() {
        System.out.println("Libreria "+name);
        for (int i = 0; i <= libreria.size(); i++) {
            for (int j = 0; j < libreria.get(0).size(); j++) {
                if (i == libreria.size())
                    System.out.print("___" + j + "___\t");
                else {
                    if (libreria.get(i).get(j).getTessera().type == null) {
                        System.out.print(".......\t");
                    } else {
                        System.out.print(libreria.get(i).get(j).getTessera().id + "\t");
                    }
                }
            }
            System.out.println();
        }
    }

    public void personalGoalPrint() {
        System.out.println(personalGoal.id);
        for (int i = 0; i <= libreria.size(); i++) {
            for (int j = 0; j <= libreria.get(0).size(); j++) {
                if(i==libreria.size()&&j==libreria.get(0).size())
                {
                    System.out.print("_______");
                }
                else {
                    if (i == libreria.size())
                        System.out.print("___" + j + "___\t");

                    if (j == libreria.get(0).size())
                        System.out.print("___" + i + "___\t");
                }

                if(i < libreria.size()&& j < libreria.get(0).size()){

                        if(i < libreria.size()&& j < libreria.get(0).size()){
                            String help = ritornoTipo(i,j);
                            if(help!=null)
                                System.out.print(help+"\t");
                            else{
                                System.out.print(".......\t");
                            }
                        }
                    }
                }
             System.out.println();
            }


        }


    private String ritornoTipo(int i, int j){
        for(Card card : personalGoal.list){
            if(card.row==i&&card.column==j)
                return card.type;
        }
        return null;
    }


}