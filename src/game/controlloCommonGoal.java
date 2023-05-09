package game;

import card.CardContainer;

public class controlloCommonGoal {
    private static int COLONNE = 5;
    private static int RIGHE = 6;
    public boolean controlloCommonGoal1(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal2(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal3(Libreria libreria)
    {

        if(ritornoTipo(0,0,libreria)==ritornoTipo(0,libreria.celle.get(0).size()-1,libreria)&&
                ritornoTipo(0,0,libreria)==ritornoTipo(libreria.celle.size()-1,libreria.celle.get(0).size()-1,libreria)&&
                ritornoTipo(0,0,libreria)==ritornoTipo(libreria.celle.size()-1, 0,libreria)
        )
        {
          return true;
        }

       return false;
    }
    public String ritornoTipo(int riga, int colonna, Libreria libreria)
    {
        String tipo;
        tipo= libreria.celle.get(riga).get(colonna).tile.type;
        return tipo;
    }
    public boolean controlloCommonGoal4(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal5(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal6(Libreria libreria, CardContainer cardContainer) {
     /*   int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;
        int cont6 = 0;

        for (int i = 0; i < RIGHE; i++)
        {
            for (int j = 0; j < COLONNE; j++)
            {
                if (cont1 == 8 || cont2 == 8 || cont3 == 8 || cont4 == 8 || cont5 == 8 || cont6 == 8)
                {
                    return true;
                }
                switch (libreria.celle.get(i).get(j).tile.type)
                {
                    case "cornice": {
                        cont1++;
                        break;
                    }
                    case "gatto": {
                        cont2++;
                        break;
                    }
                    case "gioco": {
                        cont3++;
                        break;
                    }
                    case "libro": {
                        cont4++;
                        break;

                    }
                    case "pianta": {
                        cont5++;
                        break;
                    }
                    case "trofeo": {
                        cont6++;
                        break;
                    }
                }
            }

        }*/
        //versione ottimizzata

        for(int c=0;c<cardContainer.list.size();c++)
        {
            int contacarte=0;
            for(int i=0; i<libreria.celle.size();i++)
            {
                for(int j=0; j<libreria.celle.get(i).size();j++)
                {
                    if(ritornoTipo(i,j,libreria)==cardContainer.list.get(c).type)
                    {
                        contacarte++;
                        if(contacarte>=8)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean controlloCommonGoal7(Libreria libreria)
    {
        /*  ottimizzato con nuova funzione
        boolean foundMainDiagonalValue = true;
        boolean foundSecondaryDiagonalValue = true;
        for (int i = 1; i < 5; i++) {

            if (libreria.celle.get(i).get(i).tile.type != libreria.celle.get(0).get(0).tile.type) {
                foundMainDiagonalValue = false;
            }
            if (libreria.celle.get(i).get(5-i).tile.type != libreria.celle.get(0).get(5).tile.type) {
                foundSecondaryDiagonalValue = false;
            }
        }
        return foundMainDiagonalValue || foundSecondaryDiagonalValue;*/

        for(int i=0; i<libreria.celle.size();i++)
        {
            int contDiagoPrinc=0;
            int contDiagoSec=0;
            if((libreria.celle.size()-i)>=libreria.celle.get(0).size())
            {
                for(int j=0;j<libreria.celle.get(i).size();j++)
                {
                    if (ritornoTipo(j+i,j,libreria) == ritornoTipo(0,0,libreria))
                    {
                        contDiagoPrinc++;
                        if(contDiagoPrinc>=libreria.celle.get(0).size())
                        {
                            return true;
                        }
                    }

                    if (ritornoTipo(0,libreria.celle.get(0).size(),libreria)==
                            ritornoTipo(j+i,libreria.celle.get(0).size()-j-1,libreria))
                    {
                        contDiagoSec++;
                        if(contDiagoSec>=libreria.celle.get(0).size())
                        {
                                return true;
                        }
                    }


                }
            }


        }
        return false;
    }

    public boolean controlloCommonGoal8(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal9(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal10(Libreria libreria)
    {
        return true;
    }
    public boolean controlloCommonGoal11(Libreria libreria)
    {
        return true;
    }

    public boolean controlloCommonGoal12(Libreria libreria)
    {
        return true;
    }

}
