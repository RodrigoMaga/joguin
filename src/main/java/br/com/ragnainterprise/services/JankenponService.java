package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.util.Scanner;

public class JankenponService {

    public void gamePlay() {

        Player player1 = new Player();
        Player player2 = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        String name = scanner.next();

        System.out.printf("Informe sua escolha: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura: ");
        int hand = scanner.nextInt();

        player1.name = name;
        player1.hand = hand;

        System.out.print("Informe seu nome: ");
        name = scanner.next();
        System.out.printf("Informe sua escolha: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura: ");
        hand = scanner.nextInt();

        player2.name = name;
        player2.hand = hand;

        if (player1.hand < 1 || player1.hand > 3){
            System.out.println("Escolha uma opção válida!");
        }

        if (player2.hand < 1 || player2.hand > 3){
            System.out.println("Escolha uma opção válida!");
        }

        if (player1.hand == player2.hand) {
            System.out.println("Empate!");
            return; //todo resolver questão do empate
        }

        if (player1.hand == 1 && player2.hand == 2) {
            System.out.println(player2.name + " Wins!");
            return;
        }

        if (player1.hand == 2 && player2.hand == 1) {
            System.out.println(player1.name + " Wins!");
            return;
        }

        if (player1.hand == 1 && player2.hand == 3) {
            System.out.println(player1.name + " Wins!");
            return;
        }

        if (player1.hand == 3 && player2.hand == 1) {
            System.out.println(player2.name + " Wins!");
            return;
        }

        if (player1.hand == 2 && player2.hand == 3) {
            System.out.println(player2.name + " Wins!");
            return;
        }

        if (player1.hand == 3 && player2.hand == 2) {
            System.out.println(player1.name + " Wins!");
        }
    }
}