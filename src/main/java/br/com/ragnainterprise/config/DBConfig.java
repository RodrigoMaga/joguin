package br.com.ragnainterprise.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    private static Connection connection = null;

    public DBConfig() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/joguin", "admin", "admin");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
                System.exit(0);
            }
            System.out.println("Entrou no if do connection");
        } else {
            System.out.println("Ficou no else");
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            new DBConfig();
        }
        return connection;
    }

}
