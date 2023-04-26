package game;
import card.Card;

import java.util.ArrayList;

public class Libreria {
	private static int COLONNE=6;
	private static int RIGHE=5;
	private Card [][] celle;

	public Libreria () {

		celle= new Card[RIGHE][COLONNE];
		for(int i=0;i<RIGHE;i++) {
			for(int j=0;j<COLONNE;j++) {
				celle[i][j]= new Card();
				//rivedere
			}
		}

	}

	public void inserisciTessere(ArrayList <Card> card, int COLONNE)
	{
		int contarighe=0;
		for(int y=0;y<RIGHE;y++)
		{
			if(celle[y][COLONNE]!=null)
			{
				contarighe++;
			}
		}
		if(contarighe-card.size()>=0)
		{
			for (int i=RIGHE-1; i>0;i--) {

				if(celle[i][COLONNE]!=null)
				{

				}


			}
		}
	}



}
