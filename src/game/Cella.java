package game;

import card.Card;

public class Cella {
    private Card tile;
    public int accessibilitaCella;
    public Cella(){
        this(null);
    }
    public Cella(Card tile){
        this.tile=tile;

    }

    public void setCella(Card tile){
        this.tile = tile;
    }
    public Card getTessera()
    {
        return tile;
    }


}
