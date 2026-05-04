package com.luis.javapos.modulo2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/teste_jdbc";
        String user = "root";
        String password = "admin123";

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println("Connected sucessfully!");

        conn.close();
    }
}