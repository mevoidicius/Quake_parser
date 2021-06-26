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
            List<Jogo> ljogos =new ArrayList<>();
            Tratamento tratamento =new Tratamento();
            while(arq.hasNext()){
                String line= arq.nextLine();
                if(line.contains("InitGame")){
                    ljogos.add(Builder.criar(countJogos));
                }else if(line.contains("ShutdownGame")){
                    countJogos++;
                }else if (line.contains("ClientUserinfoChanged:")){
                    String namePlayer = tratamento.tratarnome(line);
                    String idPlayer = tratamento.tratarid(line);
                    Jogador j =new Jogador(namePlayer,idPlayer);
                    Jogo client = ljogos.get(countJogos);
                    //Primeiramente se a lista estiver vazia,é necessário adicionar o jogador na lista.
                    if(client.getJogador().isEmpty()){
                        client.getJogador().add(j);
                    }else {
                        //como a lista não está vazia é realizado uma busca para saber se o jogador está ou não na lista , se não estiver ele é adicionado.
                        if(tratamento.buscarjogador(client,j)){
                            client.getJogador().add(j);
                        }else{
                            //se houver um jogador com o id repetido, faz-se uma busca para saber para qual novo nick ele trocou.
                            Jogador jogadorrepet =tratamento.buscaridjogador(client,j);
                            if(jogadorrepet!=null){
                                jogadorrepet.setNome(j.getNome());
                            }
                        }
                    }
                }
                else if(line.contains("Kill:")){
                    Jogo game = ljogos.get(countJogos);
                    game.setAllkills(game.getAllkills()+1);
                }
            }
            arq.close();
            Builder.imprimirJogos(escolha,ljogos);
        }catch (FileNotFoundException exception){
            System.out.println("arquivo inválido.");
        };
    }

}

