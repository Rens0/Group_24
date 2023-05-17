package test;

import assets.LivingRoom.Tabellone;
import assets.card.Card;

import assets.component.Cella;
import assets.component.Player;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Test {
    public static void main(String[] args) {
       /* List<List<Integer>>matrice = new ArrayList<>();
        ArrayList<Integer>a,b,c;
        a =  new ArrayList<>();
        b= new ArrayList<>();
        c = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        c.add(7);
        c.add(8);
        c.add(9);
        matrice.add(a);
        matrice.add(b);
        matrice.add(c);
        System.out.println(matrice.size());
        System.out.println(matrice.get(0).size());
        for(int i = 0; i< matrice.size();i++){
            for(int j = 0; j<matrice.get(i).size(); j++)
                System.out.print(matrice.get(i).get(j));
            System.out.println();
        }
*/
        /*ArrayList < Card> test.card= new ArrayList<>();
        ArrayList < Integer> it= new ArrayList<>();
        it.add(0); //seconda carta
        it.add(1); //prima carta
        Card card1= new Card();
        Card card2= new Card();
        card1.id="1";
        card2.id="2";
        test.card.add(card1);
        test.card.add(card2);
        Libreria libreria= new Libreria();
        libreria.inserisciTessere(test.card,4,it);
        libreria.print();
*/

       /* Player p1 = new Player("Mairo");
        Player p2 = new Player("gio");
        Player p3 = new Player("lui");
        System.out.println(p1.ID+" "+p2.ID+" "+p3.ID);




/*

        Carta gatto = new Carta("Gatto",22,"Verde");
        Carta cornice = new Carta("Cornice",22,"Blue");
        Carta trofeo = new Carta("Trofeo",22,"Azzurro");
        Carta gioco = new Carta("Gioco",22,"Giallo");
        Carta libro = new Carta("Libro",22,"Bianco");
        Carta pianta = new Carta("Pianta",22,"Rosa");

        System.out.println(gatto.toString());

        gatto.prelevaTessera();
        System.out.println(gatto.toString());


        ArrayList<ScroingToken>punti = new ArrayList<>();
        punti.add(new ScroingToken(4));
        punti.add(new ScroingToken(6));
        punti.add(new ScroingToken(8));

        System.out.println(punti.get(punti.size()-1).assegnaPuntiGiovatore());

*/

/*
        Scanner sc = new Scanner(System.in);
        String c="";
        do{
            int ro, co;
            System.out.println("Row, Col");
            ro = sc.nextInt();
            co = sc.nextInt();
            ArrayList<ArrayList<Integer>>roba=new ArrayList<>();
            ArrayList<Integer>number = new ArrayList<>();
            number.add(ro);
            number.add(co);
            roba.add(number);
            tabellone.prelevaTessera(roba);
            System.out.println(tabellone.controlloTessereVicine());

            tabellone.print();
        }while (!c.contains("no"));

        */

       /*


        for(int i = card.size()-totTessere-1; i <totTessere; i++){
            System.out.println(card.get(i).id);
        }
        System.out.println("Vuoi aggiungere queste tessere? ");
        for(int i = 0; i <card.size()-totTessere-1; i++){
            System.out.println(card.get(i).id);
        }*/
        Player player = new Player("mario");
        ArrayList<Cella>arrayList= new ArrayList<>();
        String id = "0";
        Cella c = new Cella();
        c.tile=new Card(id,id);
        arrayList.add(c);

        player.libreria.add(arrayList);




    }

}
