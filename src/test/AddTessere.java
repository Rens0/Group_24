package test;

import assets.card.Card;
import assets.component.Cella;
import assets.component.Player;

public class AddTessere {
    public Cella addTessera(String tipo) {

        Cella colonna = new Cella();
        colonna.tile = new Card("0", tipo);
        return colonna;

    }
}
