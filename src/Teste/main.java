package Teste;

import Teste.quake_parser.Parser;

import java.io.IOException;
import java.util.Scanner;
public class main {

    public static void main(String[] args){ //teste
        Scanner s =new Scanner(System.in);
        System.out.println("n do jogo que deseja procurar");
        int numero= s.nextInt();
        new Parser().parser(numero);
    }


}
