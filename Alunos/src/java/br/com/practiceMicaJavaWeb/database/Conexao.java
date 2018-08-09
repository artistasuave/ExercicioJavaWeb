package br.com.practiceMicaJavaWeb.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 * @author Michelle de Jesus Rogério
 */
public class Conexao {

    private static final String HOST = "jdbc:mysql://localhost/exercicio00Web";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;

    public static Connection ObterConexao() {
        try {
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);

            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void fecharConexao() {
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
