package assets.card;

import java.util.ArrayList;

public class Card implements Comparable<Card> {
    private String id;
    private String description;
    private String type;
    private ArrayList<String> moreId;
    private int amount;
    private int row;
    private int column;
    private int point;

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

    public int getRow() {
        return row;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getMoreId() {
        return moreId;
    }

    public int getAmount() {
        return amount;
    }

    public int getColumn() {
        return column;
    }

    public int getPoint() {
        return point;
    }

    public String getPath() {
        return path;
    }

}
