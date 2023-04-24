package card;

public class Card {
    public String id;
    public String description;
    public String type;
    public int amount;
    public int row;
    public int column;

    @Override
    public String toString() {
        return id+" "+description+" "+type+" "+amount+" "+row+" "+ " "+column;
    }
}
