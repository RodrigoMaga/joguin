package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;

import java.util.Scanner;

public class JankenponService {

    Player player1 = askPlayerInput();
    Player player2 = askPlayerInput();
    String winner;
    String loser;
    int winnerHand;
    final int pedra = 1;
    final int papel = 2;
    final int tesoura = 3;

    public void gamePlay() {

        findWinner();

        System.out.println(loser + " mamou o " + winner);

        switch (winnerHand) {
            case pedra -> System.out.println("Pedra vence tesoura");
            case papel -> System.out.println("Papel vence pedra");
            case tesoura -> System.out.println("Tesoura vence papel");
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

        while (player.hand < 1 || player.hand > 3){
            System.out.print("Escolha uma opção válida: ");
            player.hand = scanner.nextInt();
            //gethand();
            //quando tava chamando o método ele ficava reatribuindo o player aí o nome ficava null
        }

        return player;
    }
    private void drawSolver() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf(player1.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");

        player1.hand = scanner.nextInt();

        System.out.printf(player2.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        System.out.print("Informe sua escolha: ");

        player2.hand = scanner.nextInt();

        while (player1.hand == player2.hand) {
            drawSolver();
        }

    }

    private void findWinner() {

        if (player1.hand == player2.hand) {
            System.out.println("Empate!");
            drawSolver();
        }

        if (player1.hand == pedra && player2.hand == papel) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;

        }

        if (player1.hand == papel && player2.hand == pedra) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }

        if (player1.hand == pedra && player2.hand == tesoura) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }

        if (player1.hand == tesoura && player2.hand == pedra) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;
        }

        if (player1.hand == papel && player2.hand == tesoura) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;
        }

        if (player1.hand == tesoura && player2.hand == papel) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }
    }
}