/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class Conexao {
    public Connection con;
    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/locadorafilme";
            String usuario = "root";
            String senha = "root";
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
