package card;

import java.util.ArrayList;

public class Card {
    public String id;
    public String description;
    public String type;
    public ArrayList <?> moreId;
    public int amount;
    public int row;
    public int column;

    @Override
    public String toString() {
        return id+" "+description+" "+type+" "+amount+" "+row+" "+ " "+column;
    }
}
