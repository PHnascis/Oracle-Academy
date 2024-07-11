/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca_final;

/**
 *
 * @author kcnas
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados{

   public static Connection conn = null;
   
   // Configurações do banco de dados MySQL
   private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
   private static final String USER = "root";
   private static final String PASSWORD = "1234";
   
   public static Connection criarConn() throws SQLException{
       conn = DriverManager.getConnection(URL, USER, PASSWORD);
       return conn;
   }
   
   // Método para inserir dados
   public static void inserirLivro(Connection conn, String isbn, String titulo, String autores, String genero) throws SQLException {
       String sql = "INSERT INTO biblioteca.livros (isbn, titulo, autores, genero) VALUES (?, ?, ?, ?)";
       try (PreparedStatement statement = conn.prepareStatement(sql)) {
           statement.setString(1, isbn);
           statement.setString(2, titulo);
           statement.setString(3, autores);
           statement.setString(4, genero);

           int rowsInserted = statement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("Dados inseridos com sucesso!");
           }
       }
   }

   // Método para selecionar dados
   public static void selectData(Connection conn) throws SQLException {
       String sql = "SELECT * FROM biblioteca.livros";
       try (PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
           while (resultSet.next()) {
               String isbn = resultSet.getString("isbn");
               String titulo = resultSet.getString("titulo");
               String autores = resultSet.getString("autores");
               String genero = resultSet.getString("genero");
               
               System.out.println("isbn: " + isbn + ", titulo: " + titulo + ", autores:" + autores + ", genero" + genero);
           }
       }
   }
   
   public static void inserirCliente(Connection conn, int codigo, String nome, String telefone, String email) throws SQLException {
       String sql = "INSERT INTO biblioteca.usuarios (codigo, nome, telefone, email) VALUES (?, ?, ?, ?)";
       try (PreparedStatement statement = conn.prepareStatement(sql)) {
           statement.setInt(1, codigo);
           statement.setString(2, nome);
           statement.setString(3, telefone);
           statement.setString(4, email);

           int rowsInserted = statement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("Dados inseridos com sucesso!");
           }
       }
   }
   
      public static void devolucao(Connection conn, int codigo, String isbn, String dataemprestimo, String datadevolucao, int quantidade, String status) throws SQLException {
       String sql = "INSERT INTO biblioteca.emprestimos (codigo, isbn, dataemprestimo, datadevolucao, quantidade, status) VALUES (?, ?, ?, ?, ?, ?)";
       try (PreparedStatement statement = conn.prepareStatement(sql)) {
           statement.setInt(1, codigo);
           statement.setString(2, isbn);
           statement.setString(3, dataemprestimo);
           statement.setString(4, datadevolucao);
           statement.setInt(5, quantidade);
           statement.setString(6, status);

           int rowsInserted = statement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("Dados inseridos com sucesso!");
   
           }
       }
      }
}