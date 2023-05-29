package assets.component;

import assets.card.Card;
import assets.card.CardContainer;

import java.util.ArrayList;

public class Player implements Comparable<Player> {

	private String name;
    private int ID;
    private static int ID_Number = 0;
    private int points = 0;
    private ArrayList<Card> token;
    private CardContainer personalGoal;
    private ArrayList<Card> id_commonGoal;
    private Libreria libreria;
    
    public Player(String name) {
    	libreria= new Libreria();
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
            points += t.getPoint();
        points += controlloPersonalGoal();//--- Controllo punti personal goal
        points += libreria.contaPuntiCaselleAdiacenti(); //--- Controllo dei punti in base alle tessere vicine
    }

    public int controlloPersonalGoal() {
        int contatore = 0;
        for (int i = 0; i < getPersonalGoal().list.size(); i++) {
            Card card = getPersonalGoal().list.get(i);
            if(card.getRow()<libreria.getRighe()&&card.getColumn()<libreria.getColonne()) {
                if (card.getType().equals(libreria.getLibreria().get(card.getRow()).get(card.getColumn()).tile.getType()))
                    contatore++;
            }
        }
        if(contatore==0)
            return 0;
        return getPersonalGoal().point.get(contatore-1);
    }


    public int inserisciTessera(ArrayList<Card> card, ArrayList<Integer> ordine, int COLONNA) throws Exception {
        return libreria.inserisciTessere(card, ordine, COLONNA);

    }


    @Override
    public String toString() {
        return this.name + " " + this.ID + " " + this.points;
    }


    public void tokenPrint() {
        for (Card t : token)
            System.out.println(t.getId());
    }

    public void printLibreria() {
        System.out.println("Libreria " + name);
        for (int i = 0; i <= libreria.getRighe(); i++) {
            for (int j = 0; j < libreria.getColonne(); j++) {
                if (i == libreria.getRighe())
                    System.out.print("___" + j + "___\t");
                else {
                    if (libreria.getLibreria().get(i).get(j).getTessera().getType() == null) {
                        System.out.print(".......\t");
                    } else {
                        System.out.print(libreria.getLibreria().get(i).get(j).getTessera().getType() + "\t");
                    }
                }
            }
            System.out.println();
        }
    }

    public int getID() {
        return ID;
    }

    public void printPersonalGoal() {
        if(getPersonalGoal()!=null) {
            System.out.println(getPersonalGoal().id);
            for (int i = 0; i <= libreria.getRighe(); i++) {
                for (int j = 0; j <= libreria.getColonne(); j++) {
                    if (i == libreria.getRighe() && j == libreria.getColonne()) {
                        System.out.print("_______");
                    } else {
                        if (i == libreria.getRighe())
                            System.out.print("___" + j + "___\t");

                        if (j == libreria.getColonne())
                            System.out.print("___" + i + "___\t");
                    }

                    if (i < libreria.getRighe() && j < libreria.getColonne()) {

                        if (i < libreria.getRighe() && j < libreria.getColonne()) {
                            String help = ritornoTipo(i, j);
                            if (help != null)
                                System.out.print(help + "\t");
                            else {
                                System.out.print(".......\t");
                            }
                        }
                    }
                }
                System.out.println();
            }
        }

    }


    public String getName() {
		return name;
	}

	public static int getID_Number() {
		return ID_Number;
	}

	public int getPoints() {
		return points;
	}

	public ArrayList<Card> getToken() {
		return token;
	}

	public CardContainer getPersonalGoal() {
		return personalGoal;
	}

	public ArrayList<Card> getId_commonGoal() {
		return id_commonGoal;
	}

	public Libreria getLibreria() {
		return libreria;
	}

	private String ritornoTipo(int i, int j) {
        for (Card card : getPersonalGoal().list) {
            if (card.getRow() == i && card.getColumn() == j)
                return card.getType();
        }
        return null;
    }

	public void printName() {
		System.out.println(name);
	}
    @Override
    public int compareTo(Player player) {
        if(this.points > player.points)
            return 1;
        if(this.points < player.points)
            return -1;
        return 0;
    }

	public void setPersonalGoal(CardContainer personalGoal) {
		this.personalGoal=personalGoal;
	}
}