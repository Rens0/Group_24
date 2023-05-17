package assets.commongoal;


import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal5 extends CommonGoal {
    public CommonGoal5( String path, ArrayList<Card>token){

        this.path=path;
        this.token=token;
    }
    public boolean controllo(Player player) {
        int contatore=0;
        for (int j=0; j< player.getColonne(); j++){
            ArrayList<String> cardType=new ArrayList<>();
            boolean isFull=true;
            if(contatore+(player.getColonne()-j)<3)
                return false;
            for (int i=0; i< player.getRighe(); i++){

                if(player.getCella(i, j).isEmpty()) {
                    isFull=false;
                    break;//passa alla prossima colonna
                }
                String type=ritornoTipo(i,j, player);

                if(!cardType.contains(type)){
                    cardType.add(type);
                }
                if(cardType.size()>3){      //numero dei tipi nell'arrayList
                    break; //passa alla prox colonna
                }

            }
            if(isFull && cardType.size()<=3){
                contatore++;
            }
            if(contatore==3) {
                return true;
            }
        }
        return false;
    }
}
