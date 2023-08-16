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

        if (willContinue()) {
            gamePlay();
        }

    }

    private Player askPlayerInput() {
        Player player = new Player();

        player.name = InputUserTerminal.askString("Informe seu nome: ");
        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player.hand = InputUserTerminal.askInt("Informe sua escolha: ");

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Informe seu nome: ");
//        player.name = scanner.next();
//
//        System.out.printf("Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
//        System.out.print("Informe sua escolha: ");
//        player.hand = scanner.nextInt();


        while (player.hand != pedra && player.hand != papel && player.hand != tesoura){
            player.hand = InputUserTerminal.askInt("Escolha uma opção válida: ");
            //gethand();
            //quando tava chamando o método ele ficava reatribuindo o player aí o nome ficava null
        }

        return player;
    }

    private void drawSolver() {

        System.out.printf(player1.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player1.hand = InputUserTerminal.askInt("Informe sua escolha: ");

        while (player1.hand != pedra && player1.hand != papel && player1.hand != tesoura) {
            player1.hand = InputUserTerminal.askInt("Escolha uma opção válida: ");
        }

        System.out.printf(player2.name + " Opções disponíveis: %n 1 - Pedra %n 2 - Papel %n 3 - Tesoura%n");
        player2.hand = InputUserTerminal.askInt("Informe sua escolha: ");

        while (player2.hand != pedra && player2.hand != papel && player2.hand != tesoura) {
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