package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.helper.InputUserTerminal;

import java.util.Scanner;

public class JankenponService {
    Player player1 = askPlayerInput();
    Player player2 = askPlayerInput();
    String winner, loser;
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
        player.setName(InputUserTerminal.askString("Informe seu nome: "));
        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player.setHand(InputUserTerminal.askInt("Informe sua escolha: "));

        while (player.getHand() != PEDRA && player.getHand() != PAPEL && player.getHand() != TESOURA){
            player.setHand(InputUserTerminal.askInt("Escolha uma opção válida: "));
        }
        return player;
    }

    private void drawSolver() {
        System.out.printf(player1.getName() + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player1.setHand(InputUserTerminal.askInt("Informe sua escolha: "));


        while (player1.getHand() != PEDRA && player1.getHand() != PAPEL && player1.getHand() != TESOURA) {
            player1.setHand(InputUserTerminal.askInt("Escolha uma opção válida: "));
        }

        System.out.printf(player2.getName() + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player2.setHand(InputUserTerminal.askInt("Informe sua escolha: "));

        while (player2.getHand() != PEDRA && player2.getHand() != PAPEL && player2.getHand() != TESOURA) {
            player2.setHand(InputUserTerminal.askInt("Escolha uma opção válida: "));
        }

        while (player1.getHand() == player2.getHand()) {
            System.out.println("Empate!");
            drawSolver();
        }
    }

    private void findWinner() {
        if (player1.getHand() == player2.getHand()) {
            System.out.println("Empate!");
            drawSolver();
        }

        if (player1.getHand() == PEDRA && player2.getHand() == PAPEL) {
            handleResult(player2, player1);

        }

        if (player1.getHand() == PAPEL && player2.getHand() == PEDRA) {
            handleResult(player1, player2);
        }

        if (player1.getHand() == PEDRA && player2.getHand() == TESOURA) {
            handleResult(player1, player2);
        }

        if (player1.getHand() == TESOURA && player2.getHand() == PEDRA) {
            handleResult(player2, player1);
        }

        if (player1.getHand() == PAPEL && player2.getHand() == TESOURA) {
            handleResult(player2, player1);
        }

        if (player1.getHand() == TESOURA && player2.getHand() == PAPEL) {
            handleResult(player1, player2);
        }

    }

    private void handleResult(Player playerWinner, Player playerLoser) {
        winner = playerWinner.getName();
        loser = playerLoser.getName();
        winnerHand = playerWinner.getHand();
        playerWinner.setWinningCount(playerWinner.getWinningCount() + 1);
    }

    private void winnerCount(){
        System.out.println("Jogador: " + player1.getName() + " ganhou " + player1.getWinningCount() + " vezes!");
        System.out.println("Jogador: " + player2.getName() + " ganhou " + player2.getWinningCount() + " vezes!");
    }

    private boolean willContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja jogar novamente?");
        System.out.printf("1 - Sim %n2 - Não%n");
        int choice = scanner.nextInt();
        if (choice == 1){
            drawSolver();
        } else {
            System.out.println("Obrigado por jogar!");
            winnerCount();
            return false;
        }
        return true;
    }
}