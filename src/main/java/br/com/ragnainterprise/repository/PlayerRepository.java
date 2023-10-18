package br.com.ragnainterprise.repository;

import br.com.ragnainterprise.domain.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    public static List<Player> getAll(Connection connection) {
        List<Player> playerList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users ORDER BY id ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.id = rs.getInt("id");
                player.name = rs.getString("username");
                player.hand = rs.getInt("hand");
                player.winningCount = rs.getInt("wincount");
                playerList.add(player);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return playerList;
    }
}
