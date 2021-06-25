package Teste.base;
import Teste.base.Jogador;//utilizando dados da classe jogador
import java.util.List;//listas de jogadores

public class Jogo {
    private String gamenumber;
    private int allkills;
    private List<Jogador> jogador;


    public Jogo(String gamenumber,int allkills,List<Jogador> jogador){
        this.allkills=0;
        this.gamenumber=gamenumber;
        this.jogador=jogador;
    }

    public List<Jogador> getJogador() {
        return jogador;
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
