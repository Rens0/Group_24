package game;
import card.Card;
public class Libreria {
	private static int COLONNE=6;
	private static int RIGHE=5;
	private Celle [][] celle;
	
	public Libreria () {
		
	 celle= new Celle[COLONNE][RIGHE];
	 for(int i=0;i<RIGHE;i++)
	 {
		 for(int j=0;j<COLONNE;j++)
		 {
			 celle[i][j]= new Celle(new Card());
			 //rivedere
		 }
	 }
		
	}


}
