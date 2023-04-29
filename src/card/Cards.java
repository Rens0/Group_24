package card;

import java.util.ArrayList;

public class Cards extends Card{
    public String path;
    public ArrayList<Card>list;
    public void addCard(Card card){
        list.add(card);
    }

}
