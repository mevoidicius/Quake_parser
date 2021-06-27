package Teste;

import Teste.quake_parser.Parser;

import java.io.IOException;
import java.util.Scanner;
public class main {

    public static void main(String[] args) { //teste
        Scanner s = new Scanner(System.in);
        int numero;
        do {
            System.out.println("1-Buscar Jogo por Id ");
            System.out.println("0-Mostrar todos os Jogos");
            System.out.println("3-Sair");
            numero = s.nextInt();

            switch (numero) {

                case 1:
                    System.out.println("Digite o Id do jogo");
                    System.out.println("obs: os jogos vão de 1 a 21");
                    int numeroBuscaJogo = s.nextInt();
                    new Parser().parser(numeroBuscaJogo);
                    break;
                case 0:
                    System.out.println("Para mostrar todos os jogos");
                    System.out.println("Digite 0 ");
                    int numeroMostratodos = s.nextInt();
                    if(numeroMostratodos!=0){
                        System.out.println("Número inválido");
                    }else {
                        new Parser().parser(numeroMostratodos);
                    }
                    break;
                case 3:
                    System.out.println("Até Mais");
                    break;
                default:
                    System.out.println("Inválido");
                    break;
            }
        } while (numero != 3);
    }


}
