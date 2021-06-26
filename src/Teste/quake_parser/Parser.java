package Teste.quake_parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Teste.base.Jogo;
import Teste.base.Jogador;

public class Parser {

    public void parser(int escolha){

        try{
            File arqLog =new File("C:\\Users\\rosta\\IdeaProjects\\Quake_parser\\src\\Teste\\games.log");
            Scanner arq =new Scanner(arqLog);
            int countJogos =0;
            List<Jogo> ljogos =new ArrayList<Jogo>();

            while(arq.hasNext()){
                String line= arq.nextLine();
                if(line.contains("InitGame")){
                  // System.out.println(countJogos);
                    ljogos.add(Builder.criar(countJogos));
                   // System.out.println(ljogos);
                }
                else if (line.contains("ClientUserinfoChanged:")){
                    Jogo reyna= ljogos.get(countJogos);

                }
                else if(line.contains("Kill:")){
                    Jogo game = ljogos.get(countJogos);
                    game.setAllkills(game.getAllkills()+1);
                }
                else if(line.contains("ShutdownGame")){
                    countJogos++;
                }

            }
            arq.close();
            Builder.imprimirJogos(escolha,ljogos);
        }catch (FileNotFoundException exception){
            System.out.println("arquivo inválido.");
        };





    }


}

