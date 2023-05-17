package assets.card;

import java.util.ArrayList;

public class Goals {
    public String path;
    public String id;
    public Card card;

    public ArrayList<CardContainer>list;
    public ArrayList<Card>token;
    public Goals(Card card){
        this.card = card;
        token = new ArrayList<>();
        list = new ArrayList<>();
    }
}
