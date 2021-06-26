package Teste.quake_parser;

import Teste.base.Jogador;
import Teste.base.Jogo;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    public static Jogo criar(int escolha){
        Jogo game =new Jogo();

        game.setGamenumber(""+(escolha+1));
        game.setJogador(new ArrayList<Jogador>());

        return game;
    }

    public static void  imprimirJogos (int numgame, List<Jogo> jogos) {
        if (numgame == 0) {
            System.out.println(jogos);//printar todos os jogos do game.log
        }else{
            System.out.println(jogos.get(numgame-1)); //printar o jogo selecionado
        }
    }
}
