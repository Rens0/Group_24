package assets.commongoal;

import assets.component.Libreria;

import java.util.ArrayList;

public class CommonGoal5 extends ControlloCommonGoal{
    public boolean controlloCommonGoal5(Libreria libreria) {
        int contatore=0;
        for (int j=0; j< libreria.getColonne(); j++){
            ArrayList<String> cardType=new ArrayList<>();
            boolean isFull=true;
            if(contatore+(libreria.getColonne()-j)<3)
                return false;
            for (int i=0; i< libreria.getRighe(); i++){

                if(libreria.getCella(i, j).isEmpty()) {
                    isFull=false;
                    break;//passa alla prossima colonna
                }
                String type=ritornoTipo(i,j, libreria);

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
