package br.com.ragnainterprise.services;

import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.helpers.InputUserTerminal;

public class GameSelection {
    public void selectGame() {
        Player player = new Player();
        System.out.println("Escolha o jogo que deseja jogar!");
        int game = InputUserTerminal.askInt("Jogos disponíveis: %n 1 - Jankenpon %n 2 - Dota 2: ");
        int jkp = 1;
        int dota = 2;

        if (game == jkp) {
            JankenponService jankenponService = new JankenponService();
            jankenponService.gamePlay();
        }

    }
}