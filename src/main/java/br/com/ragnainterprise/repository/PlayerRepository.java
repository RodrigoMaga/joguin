package br.com.ragnainterprise.repository;

import br.com.ragnainterprise.config.DBConfig;
import br.com.ragnainterprise.domain.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    public static List<Player> getAll() {
        List<Player> playerList = new ArrayList<>();

        Connection connection = DBConfig.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users ORDER BY id ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("username"));
                player.setHand(rs.getInt("hand"));
                player.setWinningCount(rs.getInt("wincount"));
                playerList.add(player);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return playerList;
    }

    public static void savePlayer(Player player) {
        Connection connection = DBConfig.getConnection();

        String SQL = "INSERT INTO users (id, username, hand, wincount) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, player.getId());
            ps.setString(2, player.getName());
            ps.setInt (3, player.getHand());
            ps.setInt (4, player.getWinningCount());

            ps.executeUpdate();
        } catch (Exception e) {
            try{
                connection.rollback();

            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }


    public static void insertPlayer(){

        Player player = new Player();
        player.setId(16);
        player.setName("Teste");
        player.setHand(3);
        player.setWinningCount(12);

        savePlayer(player);
    }
}
