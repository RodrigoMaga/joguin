package br.com.ragnainterprise.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    public Connection connect(){
        Connection connection = null;
        try {
//            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/joguin", "admin", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }
        System.out.println("Conectado ao banco. Parabéns!");

        return connection;

    }
}
