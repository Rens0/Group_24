package test;

import assets.commongoal.CommonGoal2;
import assets.component.Cella;
import assets.component.Player;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Player player = new Player("mario");
        AddTessere addTessere = new AddTessere();

        ArrayList<Cella> arrayList = new ArrayList<>();


        //---Colonne riga1
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("8"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera


        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga2
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("5"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("2"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("2"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga3
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("6"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---COlonne riga4
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("4"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("4"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("5"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga5
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("5"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("6"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---COlonne riga6
        arrayList.add(addTessere.addTessera("1"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("2"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("3"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("6"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("7"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga


        for (int i = 0; i < player.libreria.size(); i++) {
            for (int j = 0; j < player.libreria.get(0).size(); j++) {
                System.out.print(player.libreria.get(i).get(j).tile.type + "\t ");
            }
            System.out.println();
        }


        CommonGoal2 commonGoal2 = new CommonGoal2(null, null);
        System.out.println(commonGoal2.controllo(player));

    }


}
