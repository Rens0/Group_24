package assets.card;

import java.util.ArrayList;

public class Card {
    public String id;
    public String description;
    public String type;
    public ArrayList <String> moreId;
    public int amount;
    public int row;
    public int column;
    public int point;

    public String path;
    public void setId(String id){
        this.id=id;

    }
    public Card(String id, String type){
        this.id = id;
        this.type = type;
    }
    public Card(){
        this(null, null);
    }

    //@Override
    /*public String toString() {
        return id+" "+description+" "+type+" "+amount+" "+row+" "+ " "+column;
    }*/
}
