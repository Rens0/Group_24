package assets.commongoal;

import assets.card.Card;

import assets.component.Player;

import java.util.ArrayList;

abstract class CommonGoal {
    public String path;
    public ArrayList<Card>token;
    public String id;

    public int ContaCaselleLibere(Player player, int colonna){
        int conta=0;
        for (int i = 0; i<player.libreria.size(); i++){

            if(player.libreria.get(i).get(colonna).getTessera()==null){
                conta++;
            }
            if(player.libreria.get(i).get(colonna).getTessera()!=null){
                break;
            }
        }
        return conta;
    }
    public String ritornoTipo(int riga, int colonna, Player player) {
        String tipo;
        tipo = player.libreria.get(riga).get(colonna).tile.type;
        return tipo;
    }
    public Card prendiToken(){
        Card token = this.token.get(this.token.size()-1);
        this.token.remove(this.token.size()-1);
        return token;
    }

    public void setPath(String path){
        this.path = path;
    }
    public void setToken(ArrayList<Card>token){
        this.token = token;
    }
    public void print(){
        for(int i = 0; i < token.size(); i++){
            System.out.println("path: "+path+"id: "+id);
        }
    }
}

