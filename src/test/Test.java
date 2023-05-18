package test;

import assets.LivingRoom.Tabellone;
import assets.card.Card;

import assets.commongoal.CommonGoal1;
import assets.commongoal.CommonGoal4;
import assets.component.Cella;
import assets.component.Player;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Test {
    public static void main(String[] args) {
        Player player = new Player("mario");
        AddTessere addTessere = new AddTessere();

        ArrayList<Cella>arrayList= new ArrayList<>();


        //---Colonne riga1
        arrayList.add(addTessere.addTessera("merda"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("merda"));//---Aggiungo una tessera



        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList= new ArrayList<>();
        //---COlonne riga2
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList= new ArrayList<>();
        //---COlonne riga3
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList= new ArrayList<>();
        //---COlonne riga4
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList= new ArrayList<>();
        //---COlonne riga5
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList= new ArrayList<>();
        //---COlonne riga6
        arrayList.add(addTessere.addTessera("merda"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("culo"));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga


        for(int i = 0; i < player.libreria.size(); i++){
            for(int j = 0; j < player.libreria.get(0).size(); j++){
                System.out.print(player.libreria.get(i).get(j).tile.type);
            }
            System.out.println();
        }


       CommonGoal4 commonGoal4 = new CommonGoal4(null,null);
        System.out.println(commonGoal4.controllo(player));

    }


}
