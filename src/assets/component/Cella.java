package assets.component;

import assets.card.Card;

public class Cella {
    public Card tile;

    public Card getTile() {
        return tile;
    }

    public int getAccessibilitaCella() {
        return accessibilitaCella;
    }

    public int accessibilitaCella;

    public Cella() {
        tile = new Card();
    }


    public void setCella(Card tile) {

        this.tile = tile;
    }

    public Card getTessera() {
        return tile;
    }

    public boolean isEmpty() {
        if (tile.getId() == null) {
            return true;
        }
        return false;
    }

}
