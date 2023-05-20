package test;

import assets.LivingRoom.Tabellone;
import assets.card.Card;

import assets.commongoal.CommonGoal1;  //funge
import assets.commongoal.CommonGoal2;  //non funge da sempre true
import assets.commongoal.CommonGoal3;  //non funge da sempre true
import assets.commongoal.CommonGoal4; //funge
import assets.commongoal.CommonGoal5; // funge
import assets.commongoal.CommonGoal6; // Non funge da false nonostante ogni tessera di ogni linea è diversa
import assets.commongoal.CommonGoal7; //funge
import assets.commongoal.CommonGoal8; //funge
import assets.commongoal.CommonGoal9; // Da errore Exception in thread main... errore potrebbe essere a riga 65 nel for della classe CommonGoal9
import assets.commongoal.CommonGoal10; //funge
import assets.commongoal.CommonGoal11; //Da errore Exception in Thread errore potrebbe essere in CommonGoal riga 55 o CommonGoal11 riga 42
import assets.commongoal.CommonGoal12; //Non funge ma non so bene se l ho testata in modo corretto
import assets.component.Cella;
import assets.component.Player;

import java.util.ArrayList;
import java.util.SplittableRandom;

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
                System.out.print(player.libreria.get(i).get(j).tile.type+ "\t ");
            }
            System.out.println();
        }


        CommonGoal2 commonGoal2 = new CommonGoal2(null, null);
        System.out.println(commonGoal2.controllo(player));

    }


}
