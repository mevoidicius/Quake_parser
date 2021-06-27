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
                // Se achar a palavra InitGame,significa que foi iniciado um jogo novo.
                if(line.contains("InitGame")){
                    ljogos.add(Builder.criar(countJogos));
                }
                // Se achar a palavra ClientUserinfoChanged, significa que um jogador precisa ser cadastrado
                else if (line.contains("ClientUserinfoChanged:")){
                    String namePlayer = tratamento.tratarnome(line);
                    String idPlayer = tratamento.tratarid(line);
                    Jogador j =new Jogador(namePlayer,idPlayer);
                    Jogo client = ljogos.get(countJogos);

                    //Primeiramente se a lista estiver vazia,é necessário adicionar o jogador na lista.
                    if(client.getJogador().isEmpty()){
                        client.getJogador().add(j);
                    }
                    else {
                        //como a lista não está vazia é realizado uma busca para saber se o jogador está ou não na lista , se não estiver ele é adicionado.
                        if(tratamento.buscarjogador(client,j)){
                            client.getJogador().add(j);
                        }
                        else{
                            //se houver um jogador com o id repetido, faz-se uma busca para saber para qual novo nick ele trocou.
                            Jogador jogadorrepet =tratamento.buscaridjogador(client,j);
                            if(jogadorrepet!=null){
                                jogadorrepet.setNome(j.getNome());
                            }
                        }
                    }
                }
                // Se encontrar a palavra Kill, houve uma morte entre os players que precisa ser contabilizada
                else if(line.contains("Kill:")){
                    String[] idkills = tratamento.tratarkill(line);
                    Jogo game = ljogos.get(countJogos);

                    // Se o id que foi analisado for o mesmo id que o <word> (1022), é necessário diminuir o kill do jogador.(Obs 1 Task 1).
                    if(idkills[1].equals("1022")){

                        // Busca a partir do jogo e do 2 id gerado se existe algum jogador com o mesmo id.
                        Jogador idmorreu =tratamento.buscaridkill(game,idkills[2]);
                        // se achar algum id que já existe, verifica se ele tem alguma kill se tiver diminui em 1. (Obs 1 Task 1).
                        if(idmorreu.getKills()!=0){
                            idmorreu.setKills(idmorreu.getKills()-1);
                        }
                        game.setAllkills(game.getAllkills()+1);
                    }
                    else{

                        // Se não for uma kill gerada pelo mundo, procura-se qual jogador matou.Então é incrementado em 1 suas kills.
                        Jogador idmatou =tratamento.buscaridkill(game,idkills[1]);
                        idmatou.setKills(idmatou.getKills()+1);
                        game.setAllkills(game.getAllkills()+1);
                    }
                }
                // Se encontrar a palavra ShutdownGame, significa que um jogo foi encerrado
                else if(line.contains("ShutdownGame")){
                    countJogos++;
                }
            }
            arq.close();
            Builder.imprimirJogos(escolha,ljogos);
        }
        catch (FileNotFoundException exception){
            System.out.println("arquivo inválido.");
        };
    }

}

