package game;
import card.Card;

import java.util.ArrayList;
import java.util.List;


public class Libreria {
	private static int COLONNE=5;
	private static int RIGHE=6;
	public List <List< Cella>>celle;

	public Libreria () {

		celle=new ArrayList<>();
		ArrayList <Cella> rigac;
		for(int i=0;i<RIGHE;i++) {
			rigac=new ArrayList<>();

			for(int j=0;j<COLONNE;j++) {
				rigac.add(new Cella());
			}
			celle.add(rigac);
		}

	}

	public void inserisciTessere(ArrayList<Card> card, int COLONNASELEZIONATA, ArrayList <Integer> ordine) {
		int contarighe=0;

		for(int y=0;y<RIGHE;y++) {

			if(celle.get(y).get(COLONNASELEZIONATA).tile==null) {
				contarighe++;
			}
		}

		if(contarighe-card.size()>=0) {
			for (int i=contarighe-1; i>0;i--) {

				if(celle.get(i).get(COLONNASELEZIONATA).tile==null) {

					if(ordine.size()>0)
					{

						celle.get(i).get(COLONNASELEZIONATA).tile=card.get(ordine.get(0));
						ordine.remove(0);


					}

				}
			}
		} else throw new RuntimeException("Le tessere non ci stanno");
	}


	public boolean libreriaPiena() {
		int contacella=0;
		for(int i=0;i<RIGHE;i++) {
			for(int j=0;j<COLONNE;j++) {
				if(celle.get(i).get(j).tile!=null) {
					contacella++;
				}
			}
		}
		if(contacella==(RIGHE*COLONNE)) {
			return true;
		} else {
			return false;
		}
	}

	public void print()
	{
		for(int i=0; i<RIGHE; i++)
		{
			for( int y=0; y<COLONNE; y++)
			{
				if(celle.get(i).get(y).tile==null) {
					System.out.print("NULL");
				}
				else {
					System.out.print(celle.get(i).get(y).tile.id);
				}
			}
			System.out.println();
		}
	}



}
