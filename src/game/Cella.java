package game;

import card.Card;

public class Cella {
    public Card tile;
    public int access;
    public Cella(){
        this(null);
    }
    public Cella(Card tile){
        this.tile=tile;

    }

    public void setCella(Card tile){
        this.tile = tile;
    }


}
