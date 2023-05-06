package card;

import java.util.ArrayList;

public class Card {
    public String id;
    public String description;
    public String type;
    public ArrayList <String> moreId;
    public int amount;
    public int row;
    public int column;

    public String path;
    public void setId(String id){
        this.id=id;

    }
    public Card(String id){
        this.id = id;
    }
    public Card(){
        this(null);
    }

    //@Override
    /*public String toString() {
        return id+" "+description+" "+type+" "+amount+" "+row+" "+ " "+column;
    }*/
}
