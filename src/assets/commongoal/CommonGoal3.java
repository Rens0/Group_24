package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal3 extends CommonGoal {
    public CommonGoal3(String id, String path, ArrayList<Card> token){
        this.id= id;
        this.path=path;
        this.token=token;
    }
    public boolean controllo(Player player){
        return false;
    }
}
