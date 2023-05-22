package test;

import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.CommonGoal2;
import assets.component.Cella;
import assets.component.Player;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {


        Goals personalGoal;
        String path = "json/personal_goal.json";
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            personalGoal = gson.fromJson(reader, Goals.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        Player player = new Player("mario");

        AddTessere addTessere = new AddTessere();

        ArrayList<Cella> arrayList = new ArrayList<>();


        //---Colonne riga1
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera


        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga2
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga3
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---COlonne riga4
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga5
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---COlonne riga6
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera("trofeo"));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera
        arrayList.add(addTessere.addTessera(" "));//---Aggiungo una tessera

        player.libreria.add(arrayList);//---Aggiungo riga
        player.printLibreria();



        CardContainer pg = personalGoal.list.get(0);
        player.personalGoal= pg;
        player.printPersonalGoal();
        System.out.println(player.controlloPersonalGoal());

/*
        CommonGoal2 commonGoal2 = new CommonGoal2(null, null);
        System.out.println(commonGoal2.controllo(player));
*/

    }


}
