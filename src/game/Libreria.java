package game;
import card.Card;
public class Libreria {
	private static int COLONNE=6;
	private static int RIGHE=5;
	private Card [][] celle;
	
	public Libreria () {
		
	 celle= new Card[COLONNE][RIGHE];
	 for(int i=0;i<RIGHE;i++)
	 {
		 for(int j=0;j<COLONNE;j++)
		 {
			 celle[i][j]= new Card();
			 //rivedere
		 }
	 }
		
	}


}
