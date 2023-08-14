package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;

import java.util.Scanner;

public class JankenponService {

    Player player1 = askPlayerInput()[0];
    Player player2 = askPlayerInput()[0];
    String winner;

    public void gamePlay() {

        findWinner();

        System.out.println(winner + " Wins!");

    }

    private Player[] askPlayerInput() {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        player.name = scanner.next();

        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");
        player.hand = scanner.nextInt();

        while (player.hand < 1 || player.hand > 3){
            System.out.print("Escolha uma opção válida: ");
            player.hand = scanner.nextInt();
            //gethand();
            //quando tava chamando o método ele ficava reatribuindo o player aí o nome ficava null
        }

        return new Player[]{player};
    }
    private void drawSolver() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf(player1.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");

        player1.hand = scanner.nextInt();

        System.out.printf(player2.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");

        player2.hand = scanner.nextInt();

        if (player1.hand != player2.hand) {
        findWinner();
        } else {
            drawSolver();
        }

    }

    private void findWinner() {



        if (player1.hand == player2.hand) {
            System.out.println("Empate!");
            drawSolver();
        }

        if (player1.hand == 1 && player2.hand == 2) {
            winner = player2.name;
            return;
        }

        if (player1.hand == 2 && player2.hand == 1) {
            winner = player1.name;
            return;
        }

        if (player1.hand == 1 && player2.hand == 3) {
            winner = player1.name;
            return;
        }

        if (player1.hand == 3 && player2.hand == 1) {
            winner = player2.name;
            return;
        }

        if (player1.hand == 2 && player2.hand == 3) {
            winner = player2.name;
            return;
        }

        if (player1.hand == 3 && player2.hand == 2) {
            winner = player1.name;
        }
    }
}