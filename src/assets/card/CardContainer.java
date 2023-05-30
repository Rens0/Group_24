package assets.card;

import java.util.ArrayList;
import java.util.List;

public class CardContainer {
    private String path;
    private List<Card> list;
    private String id;
    private ArrayList<Integer> point;

    @Override
    public String toString() {
        String txt = id + "\n";
        for (int i = 0; i < list.size(); i++) {
            txt += list.get(i).getType() + " " + list.get(i).getRow() + " " + list.get(i).getColumn() + "\n";


        }
        return txt;
    }

    public String getPath() {
        return path;
    }

    public List<Card> getList() {
        return list;
    }

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public String getId() {
        return id;
    }
}
