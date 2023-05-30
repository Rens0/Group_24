package test;

import assets.card.CardContainer;
import assets.card.Goals;
import assets.commongoal.*;
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
        CardContainer tile;
        path = "json/tiles.json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            tile = gson.fromJson(reader, CardContainer.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        Player player = new Player("mario");

        AddTessere addTessere = new AddTessere();

        ArrayList<Cella> arrayList = new ArrayList<>();


        //---Colonne riga1
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("persona"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("oggetto"));//---Aggiungo una tessera


        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga2
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("oggetto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera

        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();
        //---COlonne riga3
        arrayList.add(addTessere.aggiungiTessera("oggetto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("wew"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("df"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---COlonne riga4
        arrayList.add(addTessere.aggiungiTessera("d"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("oggetto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("to"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("sdv"));//---Aggiungo una tessera

        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga

        arrayList = new ArrayList<>();

        //---COlonne riga5
        arrayList.add(addTessere.aggiungiTessera("e"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera(""));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("topo"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera(""));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("sd"));//---Aggiungo una tessera


        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga
        arrayList = new ArrayList<>();
        //---Colonne riga6
        arrayList.add(addTessere.aggiungiTessera("f"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera(""));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("gatto"));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera(""));//---Aggiungo una tessera
        arrayList.add(addTessere.aggiungiTessera("df"));//---Aggiungo una tessera

        player.getLibreria().getLibreria().add(arrayList);//---Aggiungo riga
        player.printLibreria();
      //  System.out.println(player.getLibreria().contaPuntiCaselleAdiacenti());
       // System.out.println(player.getLibreria().tipoCasella(5, 1));
        CommonGoal2 commonGoal = new CommonGoal2(null, null);
        System.out.println(commonGoal.controllo(player));

        

        CardContainer pg = personalGoal.list.get(7);
        player.setPersonalGoal(pg);
       // player.contaPunti(tile);
        //System.out.println(player.points);
        player.printPersonalGoal();



    }


}
