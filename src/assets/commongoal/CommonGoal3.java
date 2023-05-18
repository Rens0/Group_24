package assets.commongoal;

import assets.card.Card;
import assets.component.Player;

import java.util.ArrayList;

public class CommonGoal3 extends CommonGoal {

    public CommonGoal3(String path, ArrayList<Card> token) {
        super(path, token);
    }

    public boolean controllo(Player player) {
        return true;
    }
}
