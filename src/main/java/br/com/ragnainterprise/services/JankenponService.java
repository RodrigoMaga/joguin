package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.util.Scanner;

public class JankenponService {

    public void gamePlay() {

        Player player1 = askPlayerInput();
        Player player2 = askPlayerInput();

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

    private Player askPlayerInput() {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        player.name = scanner.next();
        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");
        player.hand = scanner.nextInt();
        if (player.hand < 1 || player.hand > 3){
            System.out.println("Escolha uma opção válida!");
        }

        return player;
    }

}