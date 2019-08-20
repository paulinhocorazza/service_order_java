package io.github.paulinhocorazza.dal;

import java.sql.*;

/**
 *
 * @author pauloviniciusbarbosacorazza
 */
public class DatabaseConnection {

    //metodo de conexao
    public static Connection conector() {

        java.sql.Connection conexao = null;
        //linha abaixo chama o driver
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_order_service";
        String user = "root";
        String password = "";
        //fazendo a conexao

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println(conexao);
            return conexao;

        } catch (Exception e) {
            //tratativa de erro
            System.out.println(e);
           

        }
        return null;
    }
}
