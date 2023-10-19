package br.com.ragnainterprise;

import br.com.ragnainterprise.config.DBConfig;
import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.repository.PlayerRepository;
import br.com.ragnainterprise.services.GameSelection;


import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBConfig dbConfig = new DBConfig();

        Connection connection = dbConfig.connect();

        List<Player> players = PlayerRepository.getAll(connection);

        System.out.println(players);

        PlayerRepository.insertPlayer();

//        GameSelection gameSelection = new GameSelection();
//        gameSelection.selectGame();
    }
}
