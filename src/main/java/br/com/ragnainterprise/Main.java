package br.com.ragnainterprise;

import br.com.ragnainterprise.config.DBConfig;
import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.repository.PlayerRepository;
import br.com.ragnainterprise.services.GameSelection;


import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PlayerRepository.insertPlayer();

        List<Player> players = PlayerRepository.getAll();

        System.out.println(players);

//        GameSelection gameSelection = new GameSelection();
//        gameSelection.selectGame();
    }
}
