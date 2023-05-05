package Test;

import card.Card;
import game.Libreria;


import java.util.ArrayList;
import java.util.List;

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
        ArrayList < Card> card= new ArrayList<>();
        ArrayList < Integer> it= new ArrayList<>();
        it.add(0); //seconda carta
        it.add(1); //prima carta
        Card card1= new Card();
        Card card2= new Card();
        card1.id="1";
        card2.id="2";
        card.add(card1);
        card.add(card2);
        Libreria libreria= new Libreria();
        libreria.inserisciTessere(card,4,it);
        libreria.print();

    }
}
