package assets.commongoal;

import assets.component.Libreria;

public class CommonGoal12 extends ControlloCommonGoal {
    public boolean controlloCommonGoal12(Libreria libreria) {
        int casellePrimaColonna=ContaCaselleLibere(libreria, 0);
        for(int j = 1; j<libreria.mappa.size(); j++){
            if(casellePrimaColonna!=(ContaCaselleLibere(libreria, j)-j)){
                break;
            }
            if(j==4){
                return true;
            }
        }
        for(int j = 1; j<libreria.mappa.size(); j++){
            if(casellePrimaColonna!=(ContaCaselleLibere(libreria, j)+j)){
                break;
            }
            if(j==4){
                return true;
            }
        }
        return false;
    }
}
