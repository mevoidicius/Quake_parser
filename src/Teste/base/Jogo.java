package Teste.base;

import java.util.ArrayList;

public class Jogo {
    private String gamenumber;
    private int allkills;
    private ArrayList<Jogador> jogador;


    @Override
    public String toString() {
        return "game-"+ gamenumber +": {"+ "\n"+
                "     total_kills:" + allkills + "\n"+
                "     players and kills : " + jogador +"\n";
    }

    public Jogo(){
        this.allkills=0;
        this.gamenumber="";
        this.jogador=null;
    }

    public ArrayList<Jogador> getJogador() {
        return jogador;
    }

    public void setJogador(ArrayList<Jogador> jogador) {
        this.jogador = jogador;
    }

    public int getAllkills() {
        return allkills;
    }

    public void setAllkills(int allkills) {
        this.allkills = allkills;
    }

    public String getGamenumber() {
        return gamenumber;
    }

    public void setGamenumber(String gamenumber) {
        this.gamenumber = gamenumber;
    }


}
