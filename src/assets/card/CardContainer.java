package assets.card;

import java.util.List;

public class CardContainer {
    public String path;
    public List<Card> list;
    public String id;

    @Override
    public String toString() {
        String txt=id+"\n";
        for(int i = 0; i < list.size(); i++){
            txt+=list.get(i).type+" "+list.get(i).row+" "+list.get(i).column+"\n";


        }
        return txt;
    }
}
