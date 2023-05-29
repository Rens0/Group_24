package test;

import assets.card.Card;
import assets.component.Cella;

public class AddTessere {
    public Cella aggiungiTessera(String tipo) {
        if(tipo.equals(""))
            return new Cella();
        Cella colonna = new Cella();
        colonna.setTile(new Card("0", tipo));
        return colonna;
    }
}
