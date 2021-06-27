package Teste.quake_parser;

import Teste.base.Jogador;
import Teste.base.Jogo;

public class Tratamento {


    private String[] tratarKill (String line){
        String[] breakline= line.split(":");
        String[] reverseline= breakline[2].split(" ");
        return reverseline;
    }
    public String[] tratarkill(String line){
        return tratarKill(line);
    }


    private Jogador buscarIdK (Jogo jogo, String id){
        //int idPlayer = Integer.parseInt(id);
        for(Jogador ez :jogo.getJogador()){
            if(ez.getId().equals(id)){
                return ez;
            }
        }
        return null;
    }
    public Jogador buscaridkill(Jogo jogo, String id){
        return buscarIdK (jogo,id);
    }



    private boolean buscarJogador(Jogo jogo, Jogador jogador){
        for(Jogador zac :jogo.getJogador()){
            if(zac.equals(jogador)){
                return false;
            }
        }
        return true;
    }
    public boolean buscarjogador(Jogo jogo, Jogador jogador){
        return buscarJogador(jogo,jogador);
    }

    private Jogador buscarIdJ (Jogo jogo, Jogador jogador){
        for(Jogador zed :jogo.getJogador()){
            if(zed.equals(jogador)){
                return zed;
            }
        }
        return null;
    }
    public Jogador buscaridjogador(Jogo jogo, Jogador jogador){
        return buscarIdJ(jogo,jogador);
    }

    private String tratarNome(String line){
        String[] breakline= line.split("n\\\\");
        String[] reverseline= breakline[1].split("\\\\t");
        String yasuo =reverseline[0];
        return yasuo;
    }
    public String tratarnome(String line){
        return tratarNome(line);
    }

    private String tratarId(String line){
        String[] breakline= line.split(":");
        String[] reverseline= breakline[2].split("n\\\\");
        String yone =reverseline[0];
        yone =yone.replaceAll(" ","");
        return yone;
    }
    public String tratarid (String line){
        return tratarId(line);
    }


}
