package assets.card;

import java.util.ArrayList;

public class Card implements Comparable<Card> {
    public String id;
    public String description;
    public String type;
    public ArrayList<String> moreId;
    public int amount;
    public int row;
    public int column;
    public int point;

    public String path;

    public void setId(String id) {
        this.id = id;

    }

    public Card(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Card() {
        this(null, null);
    }

    public void setCoord(int riga, int colonna) {
        row = riga;
        column = colonna;
    }

    public String getCoord() {
        return row + " " + column;
    }

    public String getId() {
        return id;
    }


    @Override
    public int compareTo(Card card) {
        if (this.row > card.row)
            return 1;
        else if (this.row < card.row)
            return -1;
        else {
            if (this.column > card.column)
                return 1;
            else if (this.column < card.column)
                return -1;


        }
        return 0;
    }


    //@Override
    /*public String toString() {
        return id+" "+description+" "+type+" "+amount+" "+row+" "+ " "+column;
    }*/
}
