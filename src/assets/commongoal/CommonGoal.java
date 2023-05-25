package assets.commongoal;

import assets.card.Card;
import assets.card.CardContainer;
import assets.component.Player;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class CommonGoal {
    public String path;
    public ArrayList<Card> token;

    private static final Map<String, Class<? extends CommonGoal>> commonGoals = new HashMap<>();

    static {
        commonGoals.put("1", CommonGoal1.class);
        commonGoals.put("2", CommonGoal2.class);
        commonGoals.put("3", CommonGoal3.class);
        commonGoals.put("4", CommonGoal4.class);
        commonGoals.put("5", CommonGoal5.class);
        commonGoals.put("6", CommonGoal6.class);
        commonGoals.put("7", CommonGoal7.class);
        commonGoals.put("8", CommonGoal8.class);
        commonGoals.put("9", CommonGoal9.class);
        commonGoals.put("10", CommonGoal10.class);
        commonGoals.put("11", CommonGoal11.class);
        commonGoals.put("12", CommonGoal12.class);
    }

    public CommonGoal(String path, ArrayList<Card> token) {
        this.path = path;
        this.token = token;
    }

    public int ContaCaselleLibere(Player player, int colonna) {
        int conta = 0;
        for (int i = 0; i < player.libreria.size(); i++) {

            if (player.libreria.get(i).get(colonna).getTessera() == null) {
                conta++;
            }
            if (player.libreria.get(i).get(colonna).getTessera() != null) {
                break;
            }
        }
        return conta;
    }

    public String ritornoTipo(int riga, int colonna, Player player) {
        String tipo;
        tipo = player.libreria.get(riga).get(colonna).tile.type;
        return tipo;
    }

    public Card prendiToken() {
        Card t = token.get(0);
        token.remove(0);
        return t;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setToken(ArrayList<Card> token) {
        this.token = token;
    }

    public void print() {
        for (int i = 0; i < token.size(); i++) {
            System.out.println("path: " + path + " id: " + token.get(i).id);
        }
    }

    public static CommonGoal getCommonGoalById(String id, String path, ArrayList<Card> token) {
        Class<? extends CommonGoal> clazz = commonGoals.get(id);
        if (clazz == null) throw new RuntimeException();

        try {
            Constructor<? extends CommonGoal> constructor = clazz.getConstructor(String.class, ArrayList.class);
            CommonGoal goal = constructor.newInstance(path, token);



            return goal;
        } catch (Exception e) {
            return null;
        }
    }

    public abstract boolean controllo(Player player);


}

