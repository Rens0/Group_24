package assets.component;

import assets.card.Card;

public class Cella {
    private Card tile;
    private int accessibilitaCella;

    public Cella() {
        tile = new Card();
    }

    public Card getTile() {
    	return tile;
    }
    public void setCella(Card tile) {

        this.tile = tile;
    }

    public Card getTessera() {
        return tile;
    }

    public boolean isEmpty() {
        if (tile.getType() == null||tile.getId()==null) {
            return true;
        }
        return false;
    }

	public void setTile(Card tile) {
		this.tile = tile;
	}

	public int getAccessibilitaCella() {
		return accessibilitaCella;
	}

	public void setAccessibilitaCella(int accessibilitaCella) {
		this.accessibilitaCella = accessibilitaCella;
	}

}
