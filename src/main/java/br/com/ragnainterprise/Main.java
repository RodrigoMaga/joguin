package br.com.ragnainterprise;

import br.com.ragnainterprise.services.GameSelection;
import br.com.ragnainterprise.services.JankenponService;

public class Main {
    public static void main(String[] args) {
//        JankenponService jankenponService = new JankenponService();
//        jankenponService.gamePlay();

        GameSelection gameSelection = new GameSelection();
        gameSelection.selectGame();


    }
}