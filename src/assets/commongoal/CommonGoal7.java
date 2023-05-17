package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal7 extends CommonGoal {
    public CommonGoal7(String id, String path, ArrayList<Card>token){
        this.id= id;
        this.path=path;
        this.token=token;
    }
    public boolean controllo(Player libreria) {
        /*int contatore = 0;
        for(int i = 0; i < libreria.mappa.get(0).size(); i++){
            ArrayList<Card> tile = new ArrayList<>();

            for(int j = 0; j <libreria.mappa.size(); j++){
                for(int c = 0; c<tile.size(); c++){
                    Card card = tile.get(c);
                    boolean aggiungi = true;
                    for(int k = 0; k<tile.size(); k++){
                        if (k!=c){
                            if(card.type == tile.get(k).type)
                                aggiungi = false;
                        }
                    }
                    if(aggiungi)
                        tile.add(card);
                }
                if(tile.size()<=3)
                    contatore++;

            }

        }
        if(contatore>=3)
            return true;

        return false;*/
        int contatore=0;
        for (int i=0; i< libreria.getRighe(); i++){
            ArrayList<String> cardType=new ArrayList<>();
            boolean isFull=true;
            if(contatore+(libreria.getRighe()-i)<4)
                return false;
            for (int j=0; j< libreria.getColonne(); j++){

                if(libreria.getCella(i, j).isEmpty()) {
                    isFull=false;
                    break;//passa alla prossima riga
                }
                String type=ritornoTipo(i,j, libreria);

                if(!cardType.contains(type)){
                    cardType.add(type);
                }
                if(cardType.size()>3){      //numero dei tipi nell'arrayList
                    break; //passa alla prox riga
                }

            }
            if(isFull && cardType.size()<=3){
                contatore++;
            }
            if(contatore==4) {
                return true;
            }
        }
        return false;
    }
}
