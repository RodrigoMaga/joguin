package br.com.ragnainterprise;

import br.com.ragnainterprise.config.DBConfig;
import br.com.ragnainterprise.domain.Player;
import br.com.ragnainterprise.repository.PlayerRepository;
import br.com.ragnainterprise.services.GameSelection;
import br.com.ragnainterprise.services.JankenponService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBConfig dbConfig = new DBConfig();

        Connection connection = dbConfig.connect();

        List<Player> players = PlayerRepository.getAll(connection);

        System.out.println(players);

//        GameSelection gameSelection = new GameSelection();
//        gameSelection.selectGame();
    }
}
