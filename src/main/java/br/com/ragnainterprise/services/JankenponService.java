package br.com.ragnainterprise.services;

import br.com.ragnainterprise.Main;
import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.helpers.InputUserTerminal;

import java.util.Scanner;

public class JankenponService {

    Player player1 = askPlayerInput();
    Player player2 = askPlayerInput();
    String winner;
    String loser;
    int winnerHand;
    private static final int PEDRA = 1;
    private static final int PAPEL = 2;
    private static final int TESOURA = 3;;

    public void gamePlay() {

        findWinner();

        System.out.println(loser + " mamou o " + winner);

        switch (winnerHand) {
            case PEDRA -> System.out.println("Pedra vence tesoura");
            case PAPEL -> System.out.println("Papel vence pedra");
            case TESOURA -> System.out.println("Tesoura vence papel");

        }

        if (willContinue()) {
            gamePlay();
        }

    }

    private Player askPlayerInput() {
        Player player = new Player();

        player.name = InputUserTerminal.askString("Informe seu nome: ");
        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player.hand = InputUserTerminal.askInt("Informe sua escolha: ");

        while (player.hand != PEDRA && player.hand != PAPEL && player.hand != TESOURA){
            player.hand = InputUserTerminal.askInt("Escolha uma opção válida: ");
        }

        return player;
    }

    private void drawSolver() {

        System.out.printf(player1.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player1.hand = InputUserTerminal.askInt("Informe sua escolha: ");

        while (player1.hand != PEDRA && player1.hand != PAPEL && player1.hand != TESOURA) {
            player1.hand = InputUserTerminal.askInt("Escolha uma opção válida: ");
        }

        System.out.printf(player2.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player2.hand = InputUserTerminal.askInt("Informe sua escolha: ");

        while (player2.hand != PEDRA && player2.hand != PAPEL && player2.hand != TESOURA) {
            player2.hand = InputUserTerminal.askInt("Escolha uma opção válida: ");
        }

        while (player1.hand == player2.hand) {
            System.out.println("Empate!");
            drawSolver();
        }
    }

    private void findWinner() {

        if (player1.hand == player2.hand) {
            System.out.println("Empate!");
            drawSolver();
        }

        if (player1.hand == PEDRA && player2.hand == PAPEL) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;

        }

        if (player1.hand == PAPEL && player2.hand == PEDRA) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }

        if (player1.hand == PEDRA && player2.hand == TESOURA) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }

        if (player1.hand == TESOURA && player2.hand == PEDRA) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;
        }

        if (player1.hand == PAPEL && player2.hand == TESOURA) {
            winner = player2.name;
            loser = player1.name;
            winnerHand = player2.hand;
        }

        if (player1.hand == TESOURA && player2.hand == PAPEL) {
            winner = player1.name;
            loser = player2.name;
            winnerHand = player1.hand;
        }
    }
    private boolean willContinue(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja jogar novamente?");
        System.out.printf("1 - Sim %n2 - Não%n");
        int choice = scanner.nextInt();

        if (choice == 1){
        player1 = askPlayerInput();
        player2 = askPlayerInput();
        } else {
            return false;
        }
        return true;
    }
}