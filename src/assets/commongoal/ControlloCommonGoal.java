package assets.commongoal;

import assets.card.Card;
import assets.card.CardContainer;
import assets.component.Cella;
import assets.component.Libreria;

import java.util.ArrayList;
import java.util.Objects;

public class ControlloCommonGoal {


    public int ContaCaselleLibere(Libreria libreria, int colonna){
        int conta=0;
        for (int i = 0; i<libreria.mappa.size(); i++){

            if(libreria.mappa.get(i).get(colonna).getTessera()==null){
                conta++;
            }
            if(libreria.mappa.get(i).get(colonna).getTessera()!=null){
                break;
            }
        }
        return conta;
    }
    public String ritornoTipo(int riga, int colonna, Libreria libreria) {
        String tipo;
        tipo = libreria.mappa.get(riga).get(colonna).tile.type;
        return tipo;
    }
}

