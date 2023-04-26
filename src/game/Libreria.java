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
			if(celle[y][COLONNE].id!=null)
			{
				contarighe++;
			}
		}
		System.out.println(contarighe); //test 1
		if(contarighe-card.size()>=0)
		{
			for (int i=contarighe-1; i>0;i--) {

				if(celle[i][COLONNE]!=null)
				{
					for(int j=0;j<card.size();j++)
					{
						celle[i][COLONNE]=card.get(j);
					}
				}
			}
		}
		//else throw new RuntimeException("Le tessere non ci stanno");
	}


	public boolean tabellonePieno()
	{
		int contarighe=0;
		for(int i=0;i<RIGHE;i++) {
			for(int j=0;j<COLONNE;j++) {
				if(celle[j][COLONNE].id!=null)
				{
					contarighe++;
				}
			}
		}
		if(contarighe==(RIGHE*COLONNE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}



}
