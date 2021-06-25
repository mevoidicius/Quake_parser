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
            int countJogos =1;
            List<Jogo> ljogos =new ArrayList<Jogo>();

            while(arq.hasNext()){                                                                                        //lê o arquivo todo até achar uma das condições de tratamento.
                String line= arq.nextLine();                                                                             //variável responsável por ir guardar as variáveis encontradas na linha do .log

                if(line.contains("InitGame")){
                    ljogos.add(Builder.criar(countJogos));                                                               //cria uma lista e muda o atributo do jogo cada vez que encontra um jogo novo
                    System.out.println(ljogos);
                }
                else if (line.contains("ClientUserinfoChanged:")){                                                       // se entrar aqui significa que o nome/id do usuário foi alterado e precisa ser inserido novamente na list

                }
                else if(line.contains("Kill:")){

                }
                else if(line.contains("ShutdownGame")){
                    countJogos++;
                }

            }
            arq.close();                                                                                                 //para de ler o arquivo
        }catch (FileNotFoundException exception){
            System.out.println("arquivo inválido.");
        };





    }


}

